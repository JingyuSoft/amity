package com.jingyusoft.amity.domain;

import com.jingyusoft.amity.entities.CountryEntity;

public class Country extends LocationBase {

	public Country(CountryEntity entity) {
		super(entity.getId(), entity.getCode(), entity.getName(), entity.getLatitude(), entity.getLongitude());
	}
}
