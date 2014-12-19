package com.jingyusoft.amity.domain.geographics;

import com.jingyusoft.amity.common.Ensure;

public abstract class LocationBase {

	private final LocationType locationType;

	private final int id;

	private final String code;

	private final String name;

	protected LocationBase(LocationType locationType, int id, String code, String name) {
		Ensure.notNull("code", code);
		Ensure.notNull("name", name);

		this.locationType = locationType;
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public String getName() {
		return name;
	}
}
