package com.jingyusoft.amity.domain.geographics;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.data.entities.CountryEntity;

public class Country extends LocationBase {

	private final List<City> cities = Lists.newArrayList();

	public Country(CountryEntity entity) {
		super(LocationType.COUNTRY, entity.getId(), entity.getCountryName());
	}

	public Country addCity(final City city) {
		cities.add(city);
		return this;
	}

	public List<City> getCities() {
		return ImmutableList.copyOf(cities);
	}
}
