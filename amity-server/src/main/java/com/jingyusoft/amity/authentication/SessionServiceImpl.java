package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.thrift.generated.AmityToken;

@Service
public class SessionServiceImpl implements SessionService {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Resource
	private SessionRepository sessionRepository;

	@Resource
	private AuthenticationService authenticationService;

	@Override
	public AmityToken createSession(long amityUserId) {
		AmityToken sessionToken = new AmityToken(AuthenticationUtils.generateSessionToken());
		sessionRepository.update(amityUserId, sessionToken);
		return sessionToken;
	}

	@Override
	public void expireSession(final long amityUserId) {
		sessionRepository.remove(amityUserId);
	}

	@Override
	public boolean validateSessionToken(long amityUserId, AmityToken sessionToken) {
		SessionVerificationResult result = sessionRepository.verify(amityUserId, sessionToken);
		switch (result) {
		case SUCCESS:
			LOGGER.info("Session token valid. User = [{}], Token = [{}]", amityUserId, sessionToken.getValue());
			break;
		case NOT_EXIST:
			LOGGER.warn("Session token does not exist. User = [{}], Token = [{}]", amityUserId, sessionToken.getValue());
			break;
		case NOT_MATCH:
			LOGGER.warn("Session token does not match. User = [{}], Token = [{}]", amityUserId, sessionToken.getValue());
			break;
		}
		return result.isSuccess();
	}
}
