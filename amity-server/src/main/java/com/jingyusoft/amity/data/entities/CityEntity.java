package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "city", indexes = { @Index(name = "idx_city_by_country_id", columnList = "country_id", unique = false),
		@Index(name = "idx_city_by_city_name", columnList = "city_name", unique = false) })
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class CityEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CountryEntity.class, optional = false)
	@JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "fk_city_country_id_country_id"))
	private CountryEntity country;

	@Column(name = "subdivision_1_code", length = 10)
	private String subdivision1Code;

	@Column(name = "subdivision_1_name", length = 100)
	private String subdivision1Name;

	@Column(name = "subdivision_2_code", length = 10)
	private String subdivision2Code;

	@Column(name = "subdivision_2_name", length = 100)
	private String subdivision2Name;

	@Column(name = "city_name", length = 100, nullable = false)
	private String cityName;

	@Column(name = "display_name", length = 200)
	private String displayName;

	@Column(name = "metro_code", length = 10)
	private String metroCode;

	@Column(name = "time_zone", length = 50, nullable = false)
	private String timeZone;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	public String getCityName() {
		return cityName;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public String getDisplayName() {
		return displayName;
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

	public String getMetroCode() {
		return metroCode;
	}

	public String getSubdivision1Code() {
		return subdivision1Code;
	}

	public String getSubdivision1Name() {
		return subdivision1Name;
	}

	public String getSubdivision2Code() {
		return subdivision2Code;
	}

	public String getSubdivision2Name() {
		return subdivision2Name;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public void setMetroCode(String metroCode) {
		this.metroCode = metroCode;
	}

	public void setSubdivision1Code(String subdivision1Code) {
		this.subdivision1Code = subdivision1Code;
	}

	public void setSubdivision1Name(String subdivision1Name) {
		this.subdivision1Name = subdivision1Name;
	}

	public void setSubdivision2Code(String subdivision2Code) {
		this.subdivision2Code = subdivision2Code;
	}

	public void setSubdivision2Name(String subdivision2Name) {
		this.subdivision2Name = subdivision2Name;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}
