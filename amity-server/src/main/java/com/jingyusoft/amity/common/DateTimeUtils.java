package com.jingyusoft.amity.common;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public abstract class DateTimeUtils {

	public static DateTime safeParse(final String value) {
		return StringUtils.isNotEmpty(value) ? DateTime.parse(value) : null;
	}

	public static final String toDateString(final DateTime dateTime) {
		if (dateTime == null) {
			return null;
		}

		return dateTime.toString("yyyy-MM-dd");
	}

	public static final String toDateTimeString(final DateTime dateTime) {
		if (dateTime == null) {
			return null;
		}

		return dateTime.toString("yyyy-MM-dd HH:mm:ss");
	}
}
