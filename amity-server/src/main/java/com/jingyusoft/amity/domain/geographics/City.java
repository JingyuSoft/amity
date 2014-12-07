package com.jingyusoft.amity.domain.geographics;

import com.jingyusoft.amity.data.entities.CityEntity;

public class City extends LocationBase {

	private Region region;

	private Country country;

	public City(CityEntity entity) {
		super(entity.getId(), entity.getCode(), entity.getName(), entity.getLatitude(), entity.getLongitude());
	}

	public Country getCountry() {
		return country != null ? country : region.getCountry();
	}

	public Region getRegion() {
		return region;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
