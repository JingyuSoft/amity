package com.jingyusoft.amity.domain;

import org.apache.commons.lang3.StringUtils;

public enum Gender {

	MALE("M"),

	FEMALE("F");

	public static Gender parse(final String code) {
		for (Gender gender : Gender.values()) {
			if (StringUtils.equals(gender.code, code)) {
				return gender;
			}
		}

		return null;
	}

	private final String code;

	private Gender(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
