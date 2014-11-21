package com.jingyusoft.amity.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryEntity extends LocationEntityBase {

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RegionEntity.class)
	@JoinColumn(name = "country_id")
	private List<RegionEntity> regions;

	public List<RegionEntity> getRegions() {
		return regions;
	}

	public void setRegions(List<RegionEntity> regions) {
		this.regions = regions;
	}
}
