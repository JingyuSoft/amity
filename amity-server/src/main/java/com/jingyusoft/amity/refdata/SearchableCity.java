package com.jingyusoft.amity.refdata;

public class SearchableCity {

	private final Integer id;

	private final String cityName;

	private final String regionname;

	private final String countryName;

	public SearchableCity(Integer id, String cityName, String regionname, String countryName) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.regionname = regionname;
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

	public String getRegionname() {
		return regionname;
	}
}
