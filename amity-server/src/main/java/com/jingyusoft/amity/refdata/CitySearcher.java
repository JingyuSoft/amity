package com.jingyusoft.amity.refdata;

import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

public interface CitySearcher {

	List<NearestCityResult> getNearestCities(final double latitude, final double longitude, double distance,
			int maxCount);

	NearestCityResult getNearestCity(final double latitude, final double longitude);

	List<CitySearchResult> searchCitiesByName(final String criteria, final int maxCount) throws ParseException;
}
