package com.jingyusoft.amity.authentication;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.jingyusoft.amity.thrift.generated.AmityToken;

@Repository
public class SessionRepository {

	private final Map<Long, AmityToken> map = Maps.newConcurrentMap();

	public void update(final long amityUserId, AmityToken sessionToken) {
		map.put(amityUserId, sessionToken);
	}

	public boolean verify(final long amityUserId, final AmityToken sessionToken) {
		AmityToken lookupResult = map.get(amityUserId);
		if (lookupResult == null) {
			return false;
		}

		return Objects.equals(sessionToken, lookupResult);
	}
}
