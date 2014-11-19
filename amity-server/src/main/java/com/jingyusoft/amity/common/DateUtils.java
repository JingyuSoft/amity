package com.jingyusoft.amity.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

	public static final Date parseDate(final String value) {

		try {
			return DATE_FORMAT.parse(value);
		} catch (ParseException e) {
			throw WrappedException.insteadOf(e);
		}
	}

	public static final Date parseTime(final String value) {

		try {
			return TIME_FORMAT.parse(value);
		} catch (ParseException e) {
			throw WrappedException.insteadOf(e);
		}
	}

	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
