package com.jingyusoft.amity.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class RegionEntity extends LocationEntityBase {

	@OneToMany(fetch = FetchType.LAZY, targetEntity = CityEntity.class)
	@JoinColumn(name = "region_id")
	private List<CityEntity> cities;

	public List<CityEntity> getCities() {
		return cities;
	}

	public void setCities(List<CityEntity> cities) {
		this.cities = cities;
	}
}
