package com.jingyusoft.amity.domain.geographics;

import com.jingyusoft.amity.data.entities.CityEntity;

public class City extends LocationBase {

	private Integer countryId;

	private Country country;

	/**
	 * The name of the city and its subdivision, in case of any duplicated city names in the same country.
	 */
	private final String displayName;

	private final GeoLocation geoLocation;

	public City(CityEntity entity) {
		super(LocationType.CITY, entity.getId(), entity.getCityName());

		displayName = entity.getDisplayName();
		geoLocation = GeoLocation.from(entity.getLatitude(), entity.getLongitude());

		if (entity.getCountry() != null) {
			countryId = entity.getCountry().getId();
		}
	}

	public Country getCountry() {
		return country;
	}

	public Integer getCountryId() {
		return countryId;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
