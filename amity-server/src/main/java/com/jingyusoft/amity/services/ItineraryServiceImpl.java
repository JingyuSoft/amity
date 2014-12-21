package com.jingyusoft.amity.services;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.data.entities.ItineraryEntity;
import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.data.repositories.CityRepository;
import com.jingyusoft.amity.data.repositories.ItineraryRepository;
import com.jingyusoft.amity.domain.Itinerary;
import com.jingyusoft.amity.refdata.CityCache;
import com.jingyusoft.amity.users.UserAccountService;

@Service
public class ItineraryServiceImpl implements ItineraryService {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Resource
	private ItineraryRepository itineraryRepository;

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private CityRepository cityRepository;

	@Resource
	private UserAccountService userAccountService;

	@Resource
	private CityCache cityCache;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Itinerary createItinerary(final long amityUserId, final int departureCityId, final DateTime departureDate,
			final int arrivalCityId, final DateTime arrivalDate) {

		ItineraryEntity entity = new ItineraryEntity();
		entity.setUser(amityUserRepository.getOne(amityUserId));
		entity.setDepartureCity(cityRepository.getOne(departureCityId));
		entity.setDepartureDate(departureDate);
		entity.setArrivalCity(cityRepository.getOne(arrivalCityId));
		entity.setArrivalDate(arrivalDate);

		entity = itineraryRepository.saveAndFlush(entity);
		Itinerary itinerary = new Itinerary(entity);

		LOGGER.info("New itinerary created. " + itinerary.toString());

		return itinerary;
	}
}
