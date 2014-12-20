package com.jingyusoft.amity.refdata;

public class SearchableCity {

	private final Integer id;

	private final String cityName;

	private final String regionName;

	private final String countryName;

	public SearchableCity(Integer id, String cityName, String regionName, String countryName) {
		this.id = id;
		this.cityName = cityName;
		this.regionName = regionName;
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public Integer getId() {
		return id;
	}

	public String getRegionName() {
		return regionName;
	}
}
