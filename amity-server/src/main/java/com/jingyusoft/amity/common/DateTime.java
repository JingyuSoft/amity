package com.jingyusoft.amity.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import net.jcip.annotations.Immutable;

import org.apache.commons.lang3.time.DateUtils;

@Immutable
public final class DateTime {

	public static final DateTime now() {
		return new DateTime(new Date().getTime());
	}

	public static final DateTime parseUtcDate(final String value) {
		try {
			Date date = THREAD_LOCAL_DATE_FORMAT.get().parse(value);
			return new DateTime(date.getTime());
		} catch (ParseException e) {
			throw WrappedException.insteadOf(e);
		}
	}

	private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATE_FORMAT = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			return dateFormat;
		}
	};

	private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATE_TIME_FORMAT = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			return dateFormat;
		}
	};

	private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATE_TIME_WITH_MILLESECONDS_FORMAT = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			return dateFormat;
		}
	};

	private final Date date;

	public DateTime(final Date date) {
		this.date = date;
	}

	public DateTime(long ticks) {
		date = new Date(ticks);
	}

	public final DateTime add(long value, TimeUnit timeUnit) {
		return new DateTime(ticks() + timeUnit.toMillis(value));
	}

	public final DateTime addDays(int amount) {
		return new DateTime(DateUtils.addDays(date, amount));
	}

	public final DateTime addHours(int amount) {
		return new DateTime(DateUtils.addHours(date, amount));
	}

	public final DateTime addMilliseconds(int amount) {
		return new DateTime(DateUtils.addMilliseconds(date, amount));
	}

	public final DateTime addMinutes(int amount) {
		return new DateTime(DateUtils.addMinutes(date, amount));
	}

	public final DateTime addMonths(int amount) {
		return new DateTime(DateUtils.addMonths(date, amount));
	}

	public final DateTime addSeconds(int amount) {
		return new DateTime(DateUtils.addSeconds(date, amount));
	}

	public final DateTime addWeeks(int amount) {
		return new DateTime(DateUtils.addWeeks(date, amount));
	}

	public final DateTime addYears(int amount) {
		return new DateTime(DateUtils.addYears(date, amount));
	}

	public boolean after(DateTime dateTime) {
		Ensure.notNull("dateTime", dateTime);
		return date.after(dateTime.toDate());
	}

	public boolean before(DateTime dateTime) {
		Ensure.notNull("dateTime", dateTime);
		return date.before(dateTime.toDate());
	}

	public final DateTime ceiling(int field) {
		return new DateTime(DateUtils.ceiling(date, field).getTime());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DateTime other = (DateTime) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return date.hashCode();
	}

	public final DateTime round(int field) {
		return new DateTime(DateUtils.round(date, field).getTime());
	}

	public final long ticks() {
		return date.getTime();
	}

	public Date toDate() {
		return date;
	}

	public String toDateString() {
		return THREAD_LOCAL_DATE_FORMAT.get().format(date);
	}

	public String toDateString(int gmtOffsetInSeconds) {
		return THREAD_LOCAL_DATE_FORMAT.get().format(new Date(date.getTime() + gmtOffsetInSeconds * 1000));
	}

	public String toDateTimeString() {
		return THREAD_LOCAL_DATE_TIME_FORMAT.get().format(date);
	}

	public String toDateTimeString(int gmtOffsetInSeconds) {
		return THREAD_LOCAL_DATE_TIME_FORMAT.get().format(new Date(date.getTime() + gmtOffsetInSeconds * 1000));
	}

	public String toDateTimeStringWithMilliseconds() {
		return THREAD_LOCAL_DATE_TIME_WITH_MILLESECONDS_FORMAT.get().format(date);
	}

	public String toDateTimeStringWithMilliseconds(int gmtOffsetInSeconds) {
		return THREAD_LOCAL_DATE_TIME_WITH_MILLESECONDS_FORMAT.get().format(
				new Date(date.getTime() + gmtOffsetInSeconds * 1000));
	}

	@Override
	public String toString() {
		return toDateTimeString();
	}

	public final DateTime truncate(int field) {
		return new DateTime(DateUtils.truncate(date, field).getTime());
	}
}
