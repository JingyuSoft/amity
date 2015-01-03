package com.jingyusoft.amity.thrift.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.google.common.cache.LoadingCache;
import com.jingyusoft.amity.common.DateTimeUtils;
import com.jingyusoft.amity.common.ErrorCodes;
import com.jingyusoft.amity.domain.Itinerary;
import com.jingyusoft.amity.domain.ItinerarySearchOption;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.refdata.CitySearcher;
import com.jingyusoft.amity.services.ItineraryService;
import com.jingyusoft.amity.thrift.generated.CreateItineraryRequest;
import com.jingyusoft.amity.thrift.generated.CreateItineraryResponse;
import com.jingyusoft.amity.thrift.generated.DeleteItineraryRequest;
import com.jingyusoft.amity.thrift.generated.DeleteItineraryResponse;
import com.jingyusoft.amity.thrift.generated.GetItineraryRequest;
import com.jingyusoft.amity.thrift.generated.GetItineraryResponse;
import com.jingyusoft.amity.thrift.generated.ItineraryDto;
import com.jingyusoft.amity.thrift.generated.ItineraryThriftService;
import com.jingyusoft.amity.thrift.generated.ListItinerariesRequest;
import com.jingyusoft.amity.thrift.generated.ListItinerariesResponse;
import com.jingyusoft.amity.thrift.generated.SearchItinerariesRequest;
import com.jingyusoft.amity.thrift.generated.SearchItinerariesResponse;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;
import com.jingyusoft.amity.thrift.generated.UpdateItineraryRequest;
import com.jingyusoft.amity.thrift.generated.UpdateItineraryResponse;

@Service
public class ItineraryThriftServiceImpl implements ItineraryThriftService.Iface {

	@Resource
	private ItineraryService itineraryService;

	@Resource
	private LoadingCache<Integer, City> cityCache;

	@Resource
	private CitySearcher citySearcher;

	@Override
	public CreateItineraryResponse createItinerary(CreateItineraryRequest request, SessionCredentials credentials)
			throws TException {

		Itinerary itinerary = itineraryService.createItinerary(credentials.getAmityUserId(), request.getItinerary()
				.getDepartureCityId(), DateTimeUtils.safeParse(request.getItinerary().getDepartureDate()), request
				.getItinerary().getArrivalCityId(), DateTimeUtils.safeParse(request.getItinerary().getArrivalDate()));

		return new CreateItineraryResponse().setItineraryId(itinerary.getItineraryId());
	}

	@Override
	public DeleteItineraryResponse deleteItinerary(DeleteItineraryRequest request, SessionCredentials credentials)
			throws TException {

		if (itineraryService.deleteItinerary(request.getItineraryId())) {
			return new DeleteItineraryResponse(ErrorCodes.ITINERARY_NOT_FOUND_BY_ID);
		} else {
			return new DeleteItineraryResponse();
		}
	}

	@Override
	public GetItineraryResponse getItinerary(GetItineraryRequest request, SessionCredentials credentials)
			throws TException {

		Itinerary itinerary = itineraryService.getItinerary(request.getItineraryId());
		if (itinerary == null) {
			return new GetItineraryResponse(ErrorCodes.ITINERARY_NOT_FOUND_BY_ID);
		} else {
			ItineraryDto itineraryDto = itinerary.toDto();
			itineraryDto.setDepartureCity(itinerary.getDepartureCity().toDto());
			itineraryDto.setArrivalCity(itinerary.getArrivalCity().toDto());
			return new GetItineraryResponse().setItinerary(itineraryDto);
		}
	}

	@Override
	public ListItinerariesResponse listItineraries(ListItinerariesRequest request, SessionCredentials credentials)
			throws TException {

		return new ListItinerariesResponse().setItineraries(itineraryService.listItineraries(request.getAmityUserId())
				.stream().map(item -> {
					ItineraryDto itineraryDto = item.toDto();
					itineraryDto.setDepartureCity(item.getDepartureCity().toDto());
					itineraryDto.setArrivalCity(item.getArrivalCity().toDto());
					return itineraryDto;
				}).collect(Collectors.toList()));
	}

	@Override
	public SearchItinerariesResponse searchItineraries(SearchItinerariesRequest request, SessionCredentials credentials)
			throws TException {

		City departureCity = null;
		if (request.getDepartureCityId() != 0) {
			departureCity = cityCache.getUnchecked(request.getDepartureCityId());
		} else {
			departureCity = cityCache.getUnchecked(citySearcher.getNearestCity(request.getDepartureLatitude(),
					request.getDepartureLongitude()).getCityId());
		}

		City arrivalCity = null;
		if (request.getArrivalCityId() != 0) {
			arrivalCity = cityCache.getUnchecked(request.getArrivalCityId());
		} else {
			arrivalCity = cityCache.getUnchecked(citySearcher.getNearestCity(request.getArrivalLatitude(),
					request.getArrivalLongitude()).getCityId());
		}

		ItinerarySearchOption searchOption = new ItinerarySearchOption();
		if (request.getDepartureSearchRadius() > 0) {
			searchOption.setDepartureSearchRadius(request.getDepartureSearchRadius());
		}
		if (request.getArrivalSearchRadius() > 0) {
			searchOption.setArrivalSearchRadius(request.getArrivalSearchRadius());
		}

		List<Itinerary> searchResult = itineraryService.searchItineraries(departureCity, arrivalCity, searchOption);

		return new SearchItinerariesResponse().setItineraries(searchResult.stream().map(item -> item.toDto())
				.collect(Collectors.toList()));
	}

	@Override
	public UpdateItineraryResponse updateItinerary(UpdateItineraryRequest request, SessionCredentials credentials)
			throws TException {

		Itinerary itinerary = itineraryService.updateItinerary(request.getItinerary().getId(), request.getItinerary()
				.getDepartureCityId(), DateTimeUtils.safeParse(request.getItinerary().getDepartureDate()), request
				.getItinerary().getArrivalCityId(), DateTimeUtils.safeParse(request.getItinerary().getArrivalDate()));

		if (itinerary == null) {
			return new UpdateItineraryResponse(ErrorCodes.ITINERARY_NOT_FOUND_BY_ID);
		} else {
			return new UpdateItineraryResponse();
		}
	}
}
