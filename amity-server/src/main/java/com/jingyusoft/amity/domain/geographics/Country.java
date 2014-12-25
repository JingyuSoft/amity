package com.jingyusoft.amity.domain.geographics;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.data.entities.CountryEntity;
import com.jingyusoft.amity.thrift.generated.CountryDto;

public class Country extends LocationBase {

	private final String continentCode;

	private final String continentName;

	private final String code;

	private final List<City> cities = Lists.newArrayList();

	public Country(CountryEntity entity) {
		super(LocationType.COUNTRY, entity.getId(), entity.getCountryName());

		continentCode = entity.getContinentCode();
		continentName = entity.getContinentName();
		code = entity.getCountryCode();
	}

	public Country addCity(final City city) {
		cities.add(city);
		return this;
	}

	public List<City> getCities() {
		return ImmutableList.copyOf(cities);
	}

	public String getCode() {
		return code;
	}

	public String getContinendCode() {
		return continentCode;
	}

	public String getContinentName() {
		return continentName;
	}

	public CountryDto toDto() {
		return new CountryDto().setId(getId()).setCode(code).setName(getName()).setContinentCode(continentCode)
				.setContinentName(continentName);
	}
}
