package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.AmityToken;

@Service
public class SessionServiceImpl implements SessionService {

	@Resource
	private SessionRepository sessionRepository;

	@Override
	public AmityToken createSession(long amityUserId, AmityToken authToken) {
		AmityToken sessionToken = new AmityToken(AuthenticationUtils.generateSessionToken());
		sessionRepository.update(amityUserId, sessionToken);
		return sessionToken;
	}

	@Override
	public boolean validateSessionToken(long amityUserId, AmityToken sessionToken) {
		return sessionRepository.verify(amityUserId, sessionToken);
	}
}
