package com.jingyusoft.amity.services;

import java.util.List;
import java.util.stream.Collectors;

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
	private Itinerary.Factory itineraryFactory;

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
		Itinerary itinerary = itineraryFactory.fromEntity(entity);

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
		ItineraryEntity itineraryEntity = itineraryRepository.getOne(itineraryId);
		Itinerary itinerary = itineraryFactory.fromEntity(itineraryEntity);
		return itinerary;
	}

	@Override
	public List<Itinerary> listItineraries(long amityUserId) {
		return itineraryRepository.listItineraries(amityUserId).stream().map(item -> {
			Itinerary itinerary = itineraryFactory.fromEntity(item);
			return itinerary;
		}).collect(Collectors.toList());
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

		return itineraryFactory.fromEntity(itineraryEntity);
	}
}
