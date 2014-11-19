package com.jingyusoft.amity.common;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

public final class StringMessage {

	public final static String with(String value, final Object... args) {
		FormattingTuple formattingTuple = MessageFormatter.arrayFormat(value, args);
		return formattingTuple.getMessage();
	}
}