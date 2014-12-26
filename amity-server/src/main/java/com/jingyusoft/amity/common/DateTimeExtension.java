package com.jingyusoft.amity.common;

import org.joda.time.ReadableDateTime;

public interface DateTimeExtension extends ReadableDateTime {

	default String toDateString() {

		return toDateTime().toString("yyyy-MM-dd");
	}

	default String toDateTimeString() {

		return toDateTime().toString("yyyy-MM-dd HH:mm:ss");
	}
}
