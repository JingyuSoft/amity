package com.jingyusoft.amity.domain.geographics;

public enum LocationType {

	COUNTRY("CO"),

	CITY("CI");

	private String code;

	private LocationType(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
