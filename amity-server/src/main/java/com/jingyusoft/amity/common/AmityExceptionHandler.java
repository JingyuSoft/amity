package com.jingyusoft.amity.common;

import org.apache.commons.lang3.exception.ExceptionUtils;

public abstract class AmityExceptionHandler {

	public static void handle(final String message, final Throwable t) {

		AmityMailAlert.send(message, ExceptionUtils.getStackTrace(t));
	}

	public static void handle(final Throwable t) {
		handle(t.getMessage(), t);
	}
}
