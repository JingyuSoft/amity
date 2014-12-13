package com.jingyusoft.amity.authentication;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.thrift.generated.AmityToken;

@Repository
public class SessionRepository {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Value("${amity.authentication.session.expiry}")
	private int sessionExpiryInMinutes;

	private Cache<Long, AmityToken> tokens;

	@PostConstruct
	private void initialize() {
		tokens = CacheBuilder.newBuilder().expireAfterWrite(sessionExpiryInMinutes, TimeUnit.SECONDS)
				.removalListener(new RemovalListener<Long, AmityToken>() {

					@Override
					public void onRemoval(RemovalNotification<Long, AmityToken> notification) {
						LOGGER.info("Session token expired for user [{}]", notification.getKey());
					}
				}).build();
	}

	public void remove(final long amityUserId) {
		tokens.invalidate(amityUserId);
	}

	public void update(final long amityUserId, AmityToken sessionToken) {
		tokens.put(amityUserId, sessionToken);
		LOGGER.info("Session token [{}] assigned to user [{}]", sessionToken.getValue(), amityUserId);
	}

	public SessionVerificationResult verify(final long amityUserId, final AmityToken sessionToken) {
		AmityToken lookupResult = tokens.getIfPresent(amityUserId);
		if (lookupResult == null) {
			return SessionVerificationResult.NOT_EXIST;
		}

		return Objects.equals(sessionToken, lookupResult) ? SessionVerificationResult.SUCCESS
				: SessionVerificationResult.NOT_MATCH;
	}
}
