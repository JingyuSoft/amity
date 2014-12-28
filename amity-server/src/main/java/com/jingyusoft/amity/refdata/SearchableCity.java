package com.jingyusoft.amity.refdata;

public class SearchableCity {

	private Integer id;

	private String cityName;

	private String countryName;

	private String cityDisplayName;

	private Double latitude;

	private Double longitude;

	public SearchableCity() {
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

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
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

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "SearchableCity [id=" + id + ", cityName=" + cityName + ", countryName=" + countryName
				+ ", cityDisplayName=" + cityDisplayName + "]";
	}
}
