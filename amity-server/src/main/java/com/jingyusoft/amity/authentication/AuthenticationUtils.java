package com.jingyusoft.amity.authentication;

import java.util.Date;
import java.util.UUID;

import com.jingyusoft.amity.common.SecurityUtils;

public abstract class AuthenticationUtils {

	public static final String generateAuthToken(final String encryptedPassword) {
		return SecurityUtils.getBase64SHA256Hash(encryptedPassword + new Date().getTime());
	}

	public static final String generateSessionToken() {
		return SecurityUtils.getBase64SHA256Hash(UUID.randomUUID().toString());
	}
}
