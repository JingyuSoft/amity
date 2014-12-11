package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "help_request")
public class HelpRequestEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "from_city", foreignKey = @ForeignKey(name = "fk_help_request_from_city"))
	@Audited(withModifiedFlag = true)
	private CityEntity fromCity;

	@Column(name = "from_latitude", nullable = true)
	@Audited(withModifiedFlag = true)
	private Double fromLatitude;

	@Column(name = "from_longitude", nullable = true)
	@Audited(withModifiedFlag = true)
	private Double fromLongitude;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "to_city", foreignKey = @ForeignKey(name = "fk_help_request_to_city"))
	@Audited(withModifiedFlag = true)
	private CityEntity toCity;

	@Column(name = "to_latitude", nullable = true)
	@Audited(withModifiedFlag = true)
	private Double toLatitude;

	@Column(name = "to_longitude", nullable = true)
	@Audited(withModifiedFlag = true)
	private Double toLongitude;

	@Version
	@Column(name = "version_lock")
	private Integer versionLock;

	public CityEntity getFromCity() {
		return fromCity;
	}

	public Double getFromLatitude() {
		return fromLatitude;
	}

	public Double getFromLongitude() {
		return fromLongitude;
	}

	public Long getId() {
		return id;
	}

	public CityEntity getToCity() {
		return toCity;
	}

	public Double getToLatitude() {
		return toLatitude;
	}

	public Double getToLongitude() {
		return toLongitude;
	}

	public Integer getVersionLock() {
		return versionLock;
	}

	public void setFromCity(CityEntity fromCity) {
		this.fromCity = fromCity;
	}

	public void setFromLatitude(Double fromLatitude) {
		this.fromLatitude = fromLatitude;
	}

	public void setFromLongitude(Double fromLongitude) {
		this.fromLongitude = fromLongitude;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setToCity(CityEntity toCity) {
		this.toCity = toCity;
	}

	public void setToLatitude(Double toLatitude) {
		this.toLatitude = toLatitude;
	}

	public void setToLongitude(Double toLongitude) {
		this.toLongitude = toLongitude;
	}

	public void setVersionLock(Integer versionLock) {
		this.versionLock = versionLock;
	}
}
