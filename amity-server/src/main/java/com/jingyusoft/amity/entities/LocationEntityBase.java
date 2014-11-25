package com.jingyusoft.amity.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class LocationEntityBase {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "code", length = 12, nullable = false)
	private String code;

	@Column(name = "name", length = 64, nullable = false)
	private String name;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Version
	@Column(name = "version_lock")
	private Integer versionLock;

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

	public Integer getVersionLock() {
		return versionLock;
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

	public void setVersionLock(Integer versionLock) {
		this.versionLock = versionLock;
	}
}
