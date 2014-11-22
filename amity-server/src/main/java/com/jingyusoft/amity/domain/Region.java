package com.jingyusoft.amity.domain;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.entities.RegionEntity;

public class Region extends LocationBase {

	private Country country;

	private final List<City> cities = Lists.newArrayList();

	public Region(RegionEntity entity) {
		super(entity.getId(), entity.getCode(), entity.getName(), entity.getLatitude(), entity.getLongitude());
	}

	public Region addCity(City city) {
		cities.add(city);
		return this;
	}

	public List<City> getCities() {
		return ImmutableList.copyOf(cities);
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
