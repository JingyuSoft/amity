package com.jingyusoft.amity.domain.geographics;

import com.jingyusoft.amity.common.Ensure;

public abstract class LocationBase {

	private final int id;

	private final String code;

	private final String name;

	private final GeoLocation location;

	protected LocationBase(int id, String code, String name, Double latitude, Double longitude) {
		Ensure.notNull("code", code);
		Ensure.notNull("name", name);
		Ensure.notNull("latitude", latitude);
		Ensure.notNull("longitude", longitude);

		this.id = id;
		this.code = code;
		this.name = name;
		location = GeoLocation.from(latitude, longitude);
	}

	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
	}

	public GeoLocation getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}
}
