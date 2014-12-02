package com.jingyusoft.amity.domain;

public enum Gender {

	MALE("M"),

	FEMALE("F");

	private final String code;

	private Gender(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
