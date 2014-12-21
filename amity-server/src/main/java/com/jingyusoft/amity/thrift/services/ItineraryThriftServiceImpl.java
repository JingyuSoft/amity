package com.jingyusoft.amity.thrift.services;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.domain.Itinerary;
import com.jingyusoft.amity.services.ItineraryService;
import com.jingyusoft.amity.thrift.generated.CreateHelperItineraryRequest;
import com.jingyusoft.amity.thrift.generated.CreateHelperItineraryResponse;
import com.jingyusoft.amity.thrift.generated.ItineraryThriftService;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Service
public class ItineraryThriftServiceImpl implements ItineraryThriftService.Iface {

	@Resource
	private ItineraryService itineraryService;

	@Override
	public CreateHelperItineraryResponse createItinerary(CreateHelperItineraryRequest request,
			SessionCredentials credentials) throws TException {

		Itinerary itinerary = itineraryService.createItinerary(credentials.getAmityUserId(), request.getItinerary()
				.getDepartureCityId(), DateTime.parse(request.getItinerary().getDepartureDate()), request
				.getItinerary().getArrivalCityId(), DateTime.parse(request.getItinerary().getArrivalDate()));

		return new CreateHelperItineraryResponse().setItineraryId(itinerary.getItineraryId());
	}
}
