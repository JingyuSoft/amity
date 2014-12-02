package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.StringMessage;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.thrift.generated.AmityToken;

@Service
public class SessionServiceImpl implements SessionService {

	@Resource
	private SessionRepository sessionRepository;

	@Resource
	private AuthenticationService authenticationService;

	@Override
	public AmityToken createSession(long amityUserId, AmityToken authToken) {
		AmityUser amityUser = authenticationService.authenticateAmityUser(amityUserId, authToken);
		if (amityUser == null) {
			throw new AmityAuthenticationException(StringMessage.with("Invalid auth token for user [{}]", amityUserId));
		}

		AmityToken sessionToken = new AmityToken(AuthenticationUtils.generateSessionToken());
		sessionRepository.update(amityUserId, sessionToken);
		return sessionToken;
	}

	@Override
	public boolean validateSessionToken(long amityUserId, AmityToken sessionToken) {
		return sessionRepository.verify(amityUserId, sessionToken);
	}
}
