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
	public Itinerary createItinerary(final long amityUserId, final int departureCityId,
			final DateTime departureDateTime, final int arrivalCityId, final DateTime arrivalDateTime) {

		ItineraryEntity entity = new ItineraryEntity();
		entity.setUser(amityUserRepository.getOne(amityUserId));
		entity.setDepartureCity(cityRepository.getOne(departureCityId));
		entity.setDepartureDateTime(departureDateTime);
		entity.setArrivalCity(cityRepository.getOne(arrivalCityId));
		entity.setArrivalDateTime(arrivalDateTime);

		entity = itineraryRepository.saveAndFlush(entity);
		Itinerary itinerary = new Itinerary(entity);

		LOGGER.info("New itinerary created. " + itinerary);

		return itinerary;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteItinerary(long itineraryId) {
		if (itineraryRepository.exists(itineraryId)) {
			itineraryRepository.delete(itineraryId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Itinerary getItinerary(long itineraryId) {
		return new Itinerary(itineraryRepository.getOne(itineraryId));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Itinerary updateItinerary(long itineraryId, int departureCityId, DateTime departureDate, int arrivalCityId,
			DateTime arrivalDate) {

		ItineraryEntity itineraryEntity = itineraryRepository.getOne(itineraryId);

		if (itineraryEntity == null) {
			return null;
		}

		itineraryEntity.setDepartureCity(cityRepository.getOne(departureCityId));
		itineraryEntity.setDepartureDateTime(departureDate);
		itineraryEntity.setArrivalCity(cityRepository.getOne(arrivalCityId));
		itineraryEntity.setArrivalDateTime(arrivalDate);

		itineraryEntity = itineraryRepository.saveAndFlush(itineraryEntity);

		return new Itinerary(itineraryEntity);
	}
}
