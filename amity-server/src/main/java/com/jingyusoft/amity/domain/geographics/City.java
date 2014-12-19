package com.jingyusoft.amity.domain.geographics;

import com.jingyusoft.amity.data.entities.CityEntity;
import com.jingyusoft.amity.thrift.generated.CityDto;

public class City extends LocationBase {

	private Integer regionId;

	private Integer countryId;

	private Region region;

	private Country country;

	private final GeoLocation geoLocation;

	public City(CityEntity entity) {
		super(LocationType.CITY, entity.getId(), entity.getCode(), entity.getName());

		geoLocation = GeoLocation.from(entity.getLatitude(), entity.getLongitude());

		if (entity.getRegion() != null) {
			regionId = entity.getRegion().getId();
		}
		if (entity.getCountry() != null) {
			countryId = entity.getCountry().getId();
		}
	}

	public Country getCountry() {
		return country != null ? country : region.getCountry();
	}

	public Integer getCountryId() {
		return countryId;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public Region getRegion() {
		return region;
	}

	public Integer getRegionId() {
		return regionId;
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
		cityDto.setName(getName());
		cityDto.setLatitude(geoLocation.getLatitude());
		cityDto.setLongitude(geoLocation.getLongitude());
		if (getRegion() != null) {
			cityDto.setRegionName(getRegion().getName());
		}
		if (getCountry() != null) {
			cityDto.setCountryName(getCountry().getName());
		}
		return cityDto;
	}
}
