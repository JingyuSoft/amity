package com.jingyusoft.amity.authentication;

public enum SessionVerificationResult {

	SUCCESS(true),

	NOT_EXIST(false),

	NOT_MATCH(false);

	private boolean success;

	private SessionVerificationResult(final boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}
}
