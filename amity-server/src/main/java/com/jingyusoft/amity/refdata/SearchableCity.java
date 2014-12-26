package com.jingyusoft.amity.refdata;

public class SearchableCity {

	private Integer id;

	private String cityName;

	private String countryName;

	private String cityDisplayName;

	public SearchableCity() {
	}

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

	public void setCityDisplayName(String cityDisplayName) {
		this.cityDisplayName = cityDisplayName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SearchableCity [id=" + id + ", cityName=" + cityName + ", countryName=" + countryName
				+ ", cityDisplayName=" + cityDisplayName + "]";
	}
}
