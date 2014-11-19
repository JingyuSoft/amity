package com.jingyusoft.amity.common;

public class AmityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AmityException() {
		super();
	}

	public AmityException(String message, Throwable cause) {
		super(message, cause);
	}

	public AmityException(String message) {
		super(message);
	}

	public AmityException(Throwable cause) {
		super(cause);
	}
}
