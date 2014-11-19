package com.jingyusoft.amity.domain;

import org.apache.commons.lang3.StringUtils;

public enum AmityUserType {

	AMITY("A"),

	FACEBOOK("F"),

	GOOGLE("G");

	public static final AmityUserType from(final String code) {
		for (final AmityUserType type : AmityUserType.values()) {
			if (StringUtils.equals(type.code, code)) {
				return type;
			}
		}

		return null;
	}

	final String code;

	private AmityUserType(final String code) {
		this.code = code;
	}

	public final String getCode() {
		return code;
	}
}
