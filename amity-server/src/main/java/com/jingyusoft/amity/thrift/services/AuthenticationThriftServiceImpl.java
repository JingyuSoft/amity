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
import com.jingyusoft.amity.thrift.generated.SessionCredentials;
import com.jingyusoft.amity.thrift.generated.UpdateAmityAccountRequest;
import com.jingyusoft.amity.thrift.generated.UpdateAmityAccountResponse;
import com.jingyusoft.amity.users.UserAccountService;

@Service
public class AuthenticationThriftServiceImpl implements AuthenticationThriftService.Iface {

	@Resource
	private AuthenticationService authenticationService;

	@Resource
	private SessionService sessionService;

	@Resource
	private UserAccountService userAccountService;

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

	@Override
	public UpdateAmityAccountResponse updateAmityAccount(UpdateAmityAccountRequest request,
			SessionCredentials credentials) throws TException {

		AmityUser amityUser = userAccountService.getAmityUser(request.getAmityUserId());
		amityUser.setUserName(request.getUsername());
		amityUser.setFirstName(request.getFirstName());
		amityUser.setLastName(request.getLastName());
		amityUser.setAlias(request.getUserAlias());

		String avatarFileName = userAccountService.uploadAvatar(request.getAmityUserId(), request.getAvatar());
		amityUser.setAvatar(avatarFileName);

		userAccountService.updateUserProfile(amityUser);

		return new UpdateAmityAccountResponse();
	}
}
