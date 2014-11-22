package com.jingyusoft.amity.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmityLogger {

	public static final Logger getLogger() {

		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
		Class<?> callingClass;
		try {
			callingClass = Class.forName(stackTraceElement.getClassName());
		} catch (ClassNotFoundException e) {
			throw WrappedException.insteadOf(e);
		}
		return LoggerFactory.getLogger(callingClass);
	}
}
