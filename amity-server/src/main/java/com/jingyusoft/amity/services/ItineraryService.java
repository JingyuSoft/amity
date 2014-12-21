package com.jingyusoft.amity.services;

import org.joda.time.DateTime;

import com.jingyusoft.amity.domain.Itinerary;

public interface ItineraryService {

	Itinerary createItinerary(final long amityUserId, final int departureCityId, final DateTime departureDate,
			final int arrivalCityId, final DateTime arrivalDate);
}
