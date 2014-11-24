package com.jingyusoft.amity.common;

import org.apache.commons.lang3.StringUtils;

import com.jingyusoft.amity.AmityException;

public final class Ensure {

	public static final void notBlank(final String name, final String value) {
		if (StringUtils.isBlank(value)) {
			throw new AmityException("String [" + name + "] is blank");
		}
	}

	public static final void notNull(final String name, final Object obj) {
		if (obj == null) {
			throw new AmityException("Object [" + name + "] is null");
		}
	}
}
