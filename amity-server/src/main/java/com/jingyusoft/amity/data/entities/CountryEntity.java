package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "country")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class CountryEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "continent_code", length = 2, nullable = false)
	private String continentCode;

	@Column(name = "continent_name", length = 20, nullable = false)
	private String continentName;

	@Column(name = "country_code", length = 2, nullable = false)
	private String countryCode;

	@Column(name = "country_name", length = 100, nullable = false)
	private String countryName;

	public String getContinentCode() {
		return continentCode;
	}

	public String getContinentName() {
		return continentName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public Integer getId() {
		return id;
	}

	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
