package com.jingyusoft.amity.refdata;

public class SearchableCity {

	private final Integer id;

	private final String cityName;

	private final String countryName;

	public SearchableCity(Integer id, String cityName, String countryName) {
		this.id = id;
		this.cityName = cityName;
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

	@Override
	public String toString() {
		return "SearchableCity [id=" + id + ", cityName=" + cityName + ", countryName=" + countryName + "]";
	}
}
