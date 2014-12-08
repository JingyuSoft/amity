package com.jingyusoft.amity.domain.geographics;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.data.entities.RegionEntity;
import com.jingyusoft.amity.thrift.generated.RegionDto;

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

	public RegionDto toDto() {
		RegionDto regionDto = new RegionDto();
		regionDto.setId(getId());
		regionDto.setCode(getCode());
		regionDto.setName(getName());
		regionDto.setLatitude(getLocation().getLatitude());
		regionDto.setLongitude(getLocation().getLongitude());
		return regionDto;
	}
}
