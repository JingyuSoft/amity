package com.jingyusoft.amity.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;

public final class SecurityUtils {

	public static final String getBase64SHA256Hash(final String value) {
		return Base64.getEncoder().encodeToString(getSHA256Hash(value));
	}

	public static final byte[] getSHA256Hash(final String value) {

		if (StringUtils.isEmpty(value)) {
			throw new AmityException("Cannot get SHA-256 hash for empty string");
		}

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(value.getBytes("UTF-8"));
			return hash;
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
