package com.jingyusoft.amity.data.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "region", indexes = { @Index(name = "idx_region_by_code", columnList = "code", unique = true) })
@Audited(withModifiedFlag = true)
public class RegionEntity extends LocationEntityBase {

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CountryEntity.class)
	@JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "fk_region_country_id_country_id"))
	private CountryEntity country;

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
}
