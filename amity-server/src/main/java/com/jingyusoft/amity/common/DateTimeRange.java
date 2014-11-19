package com.jingyusoft.amity.common;

import net.jcip.annotations.Immutable;

@Immutable
public class DateTimeRange {

	public static DateTimeRange from(DateTime start, DateTime end) {
		DateTimeRange range = new DateTimeRange();
		range.start = start;
		range.end = end;
		return range;
	}

	private DateTime start;

	private DateTime end;

	private DateTimeRange() {
	}

	public final DateTime getEnd() {
		return end;
	}

	public final DateTime getStart() {
		return start;
	}
}
