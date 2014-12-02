package com.jingyusoft.amity.thrift.services;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.authentication.AuthenticationService;
import com.jingyusoft.amity.authentication.SessionService;
import com.jingyusoft.amity.common.ErrorCodes;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.thrift.generated.AmityToken;
import com.jingyusoft.amity.thrift.generated.AuthenticationThriftService;
import com.jingyusoft.amity.thrift.generated.LoginAmityAccountRequest;
import com.jingyusoft.amity.thrift.generated.LoginAmityAccountResponse;
import com.jingyusoft.amity.thrift.generated.LoginFacebookAccountRequest;
import com.jingyusoft.amity.thrift.generated.LoginFacebookAccountResponse;

@Service
public class AuthenticationThriftServiceImpl implements AuthenticationThriftService.Iface {

	@Resource
	private AuthenticationService authenticationService;

	@Resource
	private SessionService sessionService;

	@Override
	public LoginAmityAccountResponse loginAmityAccount(LoginAmityAccountRequest request) throws TException {
		AmityUser amityUser = authenticationService.authenticateAmityUser(request.getAmityUserId(),
				request.getAuthToken());
		if (amityUser != null) {
			return new LoginAmityAccountResponse().setSessionToken(sessionService.createSession(amityUser.getId()));
		} else {
			return new LoginAmityAccountResponse(ErrorCodes.UNAUTHORIZED);
		}
	}

	@Override
	public LoginFacebookAccountResponse loginFacebookAccount(LoginFacebookAccountRequest request) throws TException {
		AmityUser amityUser = authenticationService.authenticateFacebookAccount(request.getFacebookToken());

		if (amityUser == null) {
			return new LoginFacebookAccountResponse(ErrorCodes.UNAUTHORIZED);
		}

		LoginFacebookAccountResponse response = new LoginFacebookAccountResponse();
		response.setAmityUserId(amityUser.getId());
		response.setAuthToken(new AmityToken(amityUser.getAuthToken()));
		response.setSessionToken(sessionService.createSession(amityUser.getId()));

		return response;
	}
}
