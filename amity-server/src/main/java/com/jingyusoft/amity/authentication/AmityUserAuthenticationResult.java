package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.common.Ensure;
import com.jingyusoft.amity.domain.AmityUser;

public class AmityUserAuthenticationResult {

	public static final AmityUserAuthenticationResult fail(AuthenticationResult result) {
		return new AmityUserAuthenticationResult(result, null);
	}

	public static final AmityUserAuthenticationResult success(AmityUser amityUser) {
		Ensure.notNull("amityUser", amityUser);

		return new AmityUserAuthenticationResult(AuthenticationResult.SUCCESS, amityUser);
	}

	private final AuthenticationResult authenticationResult;

	private final AmityUser amityUser;

	private AmityUserAuthenticationResult(AuthenticationResult authenticationResult, AmityUser amityUser) {
		this.authenticationResult = authenticationResult;
		this.amityUser = amityUser;
	}

	public AmityUser getAmityUser() {
		return amityUser;
	}

	public AuthenticationResult getAuthenticationResult() {
		return authenticationResult;
	}
}
