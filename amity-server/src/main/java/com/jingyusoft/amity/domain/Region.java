package com.jingyusoft.amity.domain;

import com.jingyusoft.amity.entities.RegionEntity;

public class Region extends LocationBase {

	public Region(RegionEntity entity) {
		super(entity.getId(), entity.getCode(), entity.getName(), entity.getLatitude(), entity.getLongitude());
	}
}
