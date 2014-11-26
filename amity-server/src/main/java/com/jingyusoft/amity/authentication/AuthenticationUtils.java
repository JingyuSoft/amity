package com.jingyusoft.amity.authentication;

import java.util.Date;

import com.jingyusoft.amity.common.SecurityUtils;

public abstract class AuthenticationUtils {

	public static final String generateAuthToken(final String encryptedPassword) {
		return SecurityUtils.getBase64SHA256Hash(encryptedPassword + new Date().getTime());
	}
}
