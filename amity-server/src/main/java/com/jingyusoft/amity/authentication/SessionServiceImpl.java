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
	public boolean validateSessionToken(long amityUserId, AmityToken sessionToken) {
		boolean result = sessionRepository.verify(amityUserId, sessionToken);
		if (result) {
			LOGGER.info("Session token valid. User = [{}], Token = [{}]", amityUserId, sessionToken.getValue());
		} else {
			LOGGER.warn("Session token invalid. User = [{}], Token = [{}]", amityUserId, sessionToken.getValue());
		}
		return result;
	}
}
