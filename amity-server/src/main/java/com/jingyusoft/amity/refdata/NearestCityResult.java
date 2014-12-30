package com.jingyusoft.amity.refdata;

import com.jingyusoft.amity.domain.geographics.GeoLocation;

public class NearestCityResult {

	private final int cityId;

	private final String fullDisplayName;

	private final GeoLocation geoLocation;

	public NearestCityResult(int cityId, String fullDisplayName, double latitude, double longitude) {
		this.cityId = cityId;
		this.fullDisplayName = fullDisplayName;
		geoLocation = GeoLocation.from(latitude, longitude);
	}

	public int getCityId() {
		return cityId;
	}

	public String getFullDisplayName() {
		return fullDisplayName;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	@Override
	public String toString() {
		return "NearestCityResult [cityId=" + cityId + ", fullDisplayName=" + fullDisplayName + ", geoLocation="
				+ geoLocation + "]";
	}
}
