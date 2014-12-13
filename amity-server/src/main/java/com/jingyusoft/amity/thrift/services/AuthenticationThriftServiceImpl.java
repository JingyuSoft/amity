package com.jingyusoft.amity.thrift.services;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyusoft.amity.authentication.AuthenticationService;
import com.jingyusoft.amity.authentication.SessionService;
import com.jingyusoft.amity.common.ErrorCodes;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.domain.Gender;
import com.jingyusoft.amity.thrift.generated.AmityToken;
import com.jingyusoft.amity.thrift.generated.AmityUserDto;
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
			LoginAmityAccountResponse response = new LoginAmityAccountResponse().setSessionToken(sessionService
					.createSession(amityUser.getId()));
			AmityUserDto amityUserDto = amityUser.toDto();
			amityUserDto.setAvatar(userAccountService.getAvatar(amityUser.getId()));
			response.setAmityUser(amityUserDto);
			return response;
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
		AmityUserDto amityUserDto = amityUser.toDto();
		amityUserDto.setAvatar(userAccountService.getAvatar(amityUser.getId()));
		response.setAmityUser(amityUserDto);

		return response;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public UpdateAmityAccountResponse updateAmityAccount(UpdateAmityAccountRequest request,
			SessionCredentials credentials) throws TException {

		AmityUser amityUser = userAccountService.getAmityUser(request.getAmityUserId());
		if (StringUtils.isNotBlank(request.getUsername())) {
			amityUser.setUserName(request.getUsername());
		}
		amityUser.setFirstName(request.getFirstName());
		amityUser.setLastName(request.getLastName());
		amityUser.setGender(Gender.parse(request.getGender()));
		amityUser.setAlias(request.getUserAlias());

		if (request.getAvatar() != null && request.getAvatar().length > 0) {
			String avatarFileName = userAccountService.updateAvatar(request.getAmityUserId(), request.getAvatar());
			amityUser.setAvatar(avatarFileName);
		}

		userAccountService.updateUserProfile(amityUser);

		return new UpdateAmityAccountResponse();
	}
}
