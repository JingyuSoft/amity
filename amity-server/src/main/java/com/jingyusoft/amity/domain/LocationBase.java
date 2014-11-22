package com.jingyusoft.amity.domain;

public abstract class LocationBase {

	private int id;

	private String code;

	private String name;

	private Double latitude;

	private Double longitude;

	public LocationBase(int id, String code, String name, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setName(String name) {
		this.name = name;
	}
}
