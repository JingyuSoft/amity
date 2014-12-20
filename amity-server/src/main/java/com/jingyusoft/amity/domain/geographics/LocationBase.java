package com.jingyusoft.amity.domain.geographics;

import com.jingyusoft.amity.common.Ensure;

public abstract class LocationBase {

	private final LocationType locationType;

	private final int id;

	private final String name;

	protected LocationBase(LocationType locationType, int id, String name) {
		Ensure.notNull("name", name);

		this.locationType = locationType;
		this.id = id;
		this.name = name;
	}

	public String getDisplayName() {
		return name;
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
