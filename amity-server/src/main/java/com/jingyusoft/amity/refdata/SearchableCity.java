package com.jingyusoft.amity.refdata;

public class SearchableCity {

	private final Integer id;

	private final String cityName;

	private final String countryName;

	private final String cityDisplayName;

	public SearchableCity(Integer id, String cityName, final String cityDisplayName, String countryName) {
		this.id = id;
		this.cityName = cityName;
		this.cityDisplayName = cityDisplayName;
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getDisplayName() {
		return cityDisplayName;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "SearchableCity [id=" + id + ", cityName=" + cityName + ", countryName=" + countryName
				+ ", cityDisplayName=" + cityDisplayName + "]";
	}
}
