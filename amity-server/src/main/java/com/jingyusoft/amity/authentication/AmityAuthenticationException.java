package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.AmityException;

public class AmityAuthenticationException extends AmityException {

	private static final long serialVersionUID = 1L;

	public AmityAuthenticationException() {
		super();
	}

	public AmityAuthenticationException(String message) {
		super(message);
	}

	public AmityAuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AmityAuthenticationException(Throwable cause) {
		super(cause);
	}
}
