package com.jingyusoft.amity.domain.geographics;

import com.jingyusoft.amity.data.entities.CityEntity;
import com.jingyusoft.amity.thrift.generated.CityDto;

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

	public CityDto toDto() {
		CityDto cityDto = new CityDto();
		cityDto.setId(getId());
		cityDto.setCode(getCode());
		cityDto.setName(getName());
		cityDto.setLatitude(getLocation().getLatitude());
		cityDto.setLongitude(getLocation().getLongitude());
		return cityDto;
	}
}
