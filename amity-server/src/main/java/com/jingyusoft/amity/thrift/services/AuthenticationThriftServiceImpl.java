package com.jingyusoft.amity.thrift.services;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.authentication.AuthenticationService;
import com.jingyusoft.amity.common.ErrorCodes;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.thrift.generated.AmityToken;
import com.jingyusoft.amity.thrift.generated.AuthenticationThriftService;
import com.jingyusoft.amity.thrift.generated.LoginFacebookAccountRequest;
import com.jingyusoft.amity.thrift.generated.LoginFacebookAccountResponse;

@Service
public class AuthenticationThriftServiceImpl implements AuthenticationThriftService.Iface {

	@Resource
	private AuthenticationService authenticationService;

	@Override
	public LoginFacebookAccountResponse loginFacebookAccount(LoginFacebookAccountRequest request) throws TException {
		AmityUser amityUser = authenticationService.authenticateFacebookAccount(request.getFacebookToken());

		if (amityUser == null) {
			return new LoginFacebookAccountResponse(ErrorCodes.UNAUTHORIZED);
		}

		LoginFacebookAccountResponse response = new LoginFacebookAccountResponse();
		response.setAmityUserId(amityUser.getId());
		response.setAuthToke(new AmityToken(amityUser.getAuthToken()));

		return response;
	}
}
