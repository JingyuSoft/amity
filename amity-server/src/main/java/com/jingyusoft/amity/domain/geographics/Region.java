package com.jingyusoft.amity.domain.geographics;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.data.entities.RegionEntity;

public class Region extends LocationBase {

	private final Integer countryId;

	private Country country;

	private final List<City> cities = Lists.newArrayList();

	public Region(RegionEntity entity) {
		super(LocationType.REGION, entity.getId(), entity.getCode(), entity.getName());
		countryId = entity.getCountry().getId();
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

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
