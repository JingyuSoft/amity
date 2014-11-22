package com.jingyusoft.amity.domain;

import com.jingyusoft.amity.entities.CityEntity;

public class City extends LocationBase {

	public City(CityEntity entity) {
		super(entity.getId(), entity.getCode(), entity.getName(), entity.getLatitude(), entity.getLongitude());
	}
}
