package com.jingyusoft.amity.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity extends LocationEntityBase {

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CountryEntity.class)
	@JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "fk_city_country_id_country_id"))
	private CountryEntity country;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = RegionEntity.class)
	@JoinColumn(name = "region_id", foreignKey = @ForeignKey(name = "fk_city_region_id_region_id"))
	private RegionEntity region;

	public CountryEntity getCountry() {
		return country;
	}

	public RegionEntity getRegion() {
		return region;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public void setRegion(RegionEntity region) {
		this.region = region;
	}
}
