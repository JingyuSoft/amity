package com.jingyusoft.amity.services;

import java.util.List;

import org.joda.time.DateTime;

import com.jingyusoft.amity.domain.Itinerary;

public interface ItineraryService {

	Itinerary createItinerary(final long amityUserId, final int departureCityId, final DateTime departureDate,
			final int arrivalCityId, final DateTime arrivalDate);

	boolean deleteItinerary(final long itineraryId);

	Itinerary getItinerary(final long itineraryId);

	List<Itinerary> listItineraries(final long amityUserId);

	Itinerary updateItinerary(final long itineraryId, final int departureCityId, final DateTime departureDate,
			final int arrivalCityId, final DateTime arrivalDate);
}
