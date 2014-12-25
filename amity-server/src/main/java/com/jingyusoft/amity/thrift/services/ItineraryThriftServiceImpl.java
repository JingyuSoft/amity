package com.jingyusoft.amity.thrift.services;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.domain.Itinerary;
import com.jingyusoft.amity.services.ItineraryService;
import com.jingyusoft.amity.thrift.generated.CreateItineraryRequest;
import com.jingyusoft.amity.thrift.generated.CreateItineraryResponse;
import com.jingyusoft.amity.thrift.generated.ItineraryThriftService;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Service
public class ItineraryThriftServiceImpl implements ItineraryThriftService.Iface {

	@Resource
	private ItineraryService itineraryService;

	@Override
	public CreateItineraryResponse createItinerary(CreateItineraryRequest request, SessionCredentials credentials)
			throws TException {

		Itinerary itinerary = itineraryService.createItinerary(credentials.getAmityUserId(), request.getItinerary()
				.getDepartureCityId(), DateTime.parse(request.getItinerary().getDepartureDate()), request
				.getItinerary().getArrivalCityId(), DateTime.parse(request.getItinerary().getArrivalDate()));

		return new CreateItineraryResponse().setItineraryId(itinerary.getItineraryId());
	}
}
