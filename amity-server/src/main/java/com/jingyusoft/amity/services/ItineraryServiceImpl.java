package com.jingyusoft.amity.services;

import java.util.List;
import java.util.Set;
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
import com.jingyusoft.amity.domain.ItinerarySearchOption;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.refdata.CitySearcher;
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

	@Resource
	private CitySearcher citySearcher;

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
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Itinerary> searchItineraries(City departureCity, City arrivalCity, ItinerarySearchOption searchOption) {

		Set<Integer> departureCityIds = citySearcher
				.getNearestCities(departureCity.getGeoLocation().getLatitude(),
						departureCity.getGeoLocation().getLongitude(),
						searchOption.getMaxDistanceToDepartureLocation(), searchOption.getMaxNearbyDepartureCities())
						.stream().map(item -> item.getCityId()).collect(Collectors.toSet());
		departureCityIds.add(departureCity.getId());

		Set<Integer> arrivalCityIds = citySearcher
				.getNearestCities(arrivalCity.getGeoLocation().getLatitude(),
						arrivalCity.getGeoLocation().getLongitude(), searchOption.getMaxDistanceToArrivalLocation(),
						searchOption.getMaxNearbyArrivalCities()).stream().map(item -> item.getCityId())
						.collect(Collectors.toSet());
		arrivalCityIds.add(arrivalCity.getId());

		List<Itinerary> searchResult = itineraryRepository.searchItineraries(departureCityIds, departureCityIds)
				.stream().map(item -> itineraryFactory.fromEntity(item)).collect(Collectors.toList());

		return searchResult;
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
