package com.jingyusoft.amity.domain;

import org.apache.commons.lang3.StringUtils;

public enum Gender {

	MALE("M"),

	FEMALE("F");

	public static Gender parse(final String code) {
		if (StringUtils.isEmpty(code)) {
			return null;
		}

		for (Gender gender : Gender.values()) {
			if (StringUtils.equals(gender.code, code)) {
				return gender;
			}
		}

		throw new IllegalArgumentException("Invalid gender code [" + code + "]");
	}

	private final String code;

	private Gender(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
