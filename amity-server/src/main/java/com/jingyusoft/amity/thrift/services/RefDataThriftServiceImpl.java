package com.jingyusoft.amity.thrift.services;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.ErrorCodes;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.refdata.CityCache;
import com.jingyusoft.amity.refdata.CitySearchResult;
import com.jingyusoft.amity.refdata.CitySearcher;
import com.jingyusoft.amity.refdata.NearestCityResult;
import com.jingyusoft.amity.thrift.generated.CitySearchResultDto;
import com.jingyusoft.amity.thrift.generated.GetCityRequest;
import com.jingyusoft.amity.thrift.generated.GetCityResponse;
import com.jingyusoft.amity.thrift.generated.GetNearestCityRequest;
import com.jingyusoft.amity.thrift.generated.GetNearestCityResponse;
import com.jingyusoft.amity.thrift.generated.RefDataThriftService;
import com.jingyusoft.amity.thrift.generated.SearchCitiesRequest;
import com.jingyusoft.amity.thrift.generated.SearchCitiesResponse;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Service
public class RefDataThriftServiceImpl implements RefDataThriftService.Iface {

	private static final Logger LOGGER = AmityLogger.getLogger();

	private static final int DEFAULT_SEARCH_RESULT_MAX_COUNT = 10;

	@Resource
	private CitySearcher citySearcher;

	@Resource
	private CityCache cityCache;

	@Override
	public GetCityResponse getCity(GetCityRequest request, SessionCredentials credentials) throws TException {

		City city = cityCache.get(request.getId());
		if (city == null) {
			return new GetCityResponse(ErrorCodes.CITY_NOT_FOUND_BY_ID);
		}

		return new GetCityResponse().setCity(city.toDto());
	}

	@Override
	public GetNearestCityResponse getNearestCity(GetNearestCityRequest request, SessionCredentials credentials)
			throws TException {

		LOGGER.debug("Getting nearest city by location [{}, {}]", request.getLatitude(), request.getLongitude());

		NearestCityResult nearestCityResult = citySearcher
				.getNearestCity(request.getLatitude(), request.getLongitude());

		if (nearestCityResult != null) {
			City nearestCity = cityCache.get(nearestCityResult.getCityId());
			LOGGER.debug("Nearest city for [{}, {}] = [{}]", request.getLatitude(), request.getLongitude(),
					nearestCity.getDisplayName());
			return new GetNearestCityResponse().setCity(nearestCity.toDto());
		} else {
			return new GetNearestCityResponse(ErrorCodes.CITY_NOT_FOUND_BY_LOCATION);
		}
	}

	@Override
	public SearchCitiesResponse searchCities(SearchCitiesRequest request, SessionCredentials credentials)
			throws TException {

		final String query = request.getSearchText();
		Integer maxCount = request.getMaxCount();
		if (maxCount == null) {
			maxCount = DEFAULT_SEARCH_RESULT_MAX_COUNT;
		}
		try {
			Collection<CitySearchResult> searchResult = citySearcher.searchCitiesByName(query, maxCount);
			return new SearchCitiesResponse().setCities(searchResult
					.stream()
					.map(item -> new CitySearchResultDto().setId(item.getId())
							.setDisplayName(item.getFullDisplayName())).collect(Collectors.toList()));
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
			return new SearchCitiesResponse(ErrorCodes.UNKNOWN);
		}
	}
}
