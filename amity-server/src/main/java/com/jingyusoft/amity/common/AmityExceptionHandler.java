package com.jingyusoft.amity.common;

import org.apache.commons.lang3.exception.ExceptionUtils;

public abstract class AmityExceptionHandler {

	public static void handle(final String message, final Throwable t) {

		String subject = subjectPrefix + message;

		Mail.send(alertEmailAddress, subject, ExceptionUtils.getStackTrace(t));
	}

	public static void handle(final Throwable t) {
		handle(t.getMessage(), t);
	}

	public static void initializeWith(AmityPropertiesRepository amityProperties) {
		alertEmailAddress = amityProperties.getProperty("amity.exception.alert.email");
		subjectPrefix = StringMessage.with("[Amity {}] ", AmityEnvironment.getWorkingEnvironment().getConfigMode()
				.toUpperCase());
	}

	private static String alertEmailAddress;

	private static String subjectPrefix;
}
