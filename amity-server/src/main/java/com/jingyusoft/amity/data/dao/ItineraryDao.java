package com.jingyusoft.amity.data.dao;

import java.util.List;

import com.jingyusoft.amity.data.entities.ItineraryEntity;

public interface ItineraryDao {

	List<ItineraryEntity> listItineraries(final long amityUserId);
}
