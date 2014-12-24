package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.common.SecurityUtils;

public abstract class AuthenticationUtils {

	public static final String encryptPassword(final String plainPassword, final String passwordSand) {
		return SecurityUtils.getBase64SHA256Hash(plainPassword + passwordSand);
	}

	public static final String generateAuthToken(final String oauthTokenOrEncryptedPassword) {
		return SecurityUtils
				.getBase64SHA256Hash(oauthTokenOrEncryptedPassword + SecurityUtils.generateRandomString(64));
	}

	public static final String generateSessionToken() {
		return SecurityUtils.getBase64SHA256Hash(SecurityUtils.generateRandomString(64));
	}
}
