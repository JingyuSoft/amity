package com.jingyusoft.amity.authentication;

import java.util.Map;
import java.util.Objects;

import net.jcip.annotations.ThreadSafe;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.thrift.generated.AmityToken;

@Repository
@ThreadSafe
public class SessionRepository {

	private static final Logger LOGGER = AmityLogger.getLogger();

	private final Map<Long, AmityToken> map = Maps.newConcurrentMap();

	public void update(final long amityUserId, AmityToken sessionToken) {
		AmityToken previousToken = map.put(amityUserId, sessionToken);
		if (previousToken != null) {
			LOGGER.info("Session token replaced for user [{}]. Old = [{}], New = [{}]", amityUserId,
					previousToken.getValue(), sessionToken.getValue());
		} else {
			LOGGER.info("Session token created for user [{}]. Token = [{}]", amityUserId, sessionToken.getValue());
		}
	}

	public boolean verify(final long amityUserId, final AmityToken sessionToken) {
		AmityToken lookupResult = map.get(amityUserId);
		if (lookupResult == null) {
			return false;
		}

		return Objects.equals(sessionToken, lookupResult);
	}
}
