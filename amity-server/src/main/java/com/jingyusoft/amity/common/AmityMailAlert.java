package com.jingyusoft.amity.common;

import org.apache.commons.lang3.StringUtils;

public abstract class AmityMailAlert {

	public static void initializeWith(AmityPropertiesRepository amityProperties) {
		alertEmailAddress = amityProperties.getProperty("amity.exception.alert.email");
		subjectPrefix = StringMessage.with("[Amity {}] ", AmityEnvironment.getWorkingEnvironment().getConfigMode()
				.toUpperCase());
	}

	public static boolean send(final String subject) {
		return send(subject, StringUtils.EMPTY);
	}

	public static boolean send(final String subject, final String body) {
		if (!Mail.isInitialized()) {
			return false;
		}

		Mail.send(alertEmailAddress, subjectPrefix + subject, body);
		return true;
	}

	private static String subjectPrefix;

	private static String alertEmailAddress;
}
