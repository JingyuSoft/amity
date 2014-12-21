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
import com.jingyusoft.amity.refdata.CitySearchResult;
import com.jingyusoft.amity.refdata.CitySearcher;
import com.jingyusoft.amity.thrift.generated.CitySearchResultDto;
import com.jingyusoft.amity.thrift.generated.RefDataThriftService;
import com.jingyusoft.amity.thrift.generated.SearchCitiesRequest;
import com.jingyusoft.amity.thrift.generated.SearchCitiesResponse;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Service
public class RefDataThriftServiceImpl implements RefDataThriftService.Iface {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Resource
	private CitySearcher citySearcher;

	@Override
	public SearchCitiesResponse searchCities(SearchCitiesRequest request, SessionCredentials credentials)
			throws TException {

		final String query = request.getSearchText() + "*";
		try {
			Collection<CitySearchResult> searchResult = citySearcher.searchCities(query, 10);
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
