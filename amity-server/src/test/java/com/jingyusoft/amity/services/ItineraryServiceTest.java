package com.jingyusoft.amity.services;

import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.queryparser.classic.ParseException;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.LoadingCache;
import com.jingyusoft.amity.config.UnitTestConfigConstants;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.domain.Itinerary;
import com.jingyusoft.amity.domain.ItinerarySearchOption;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.refdata.CitySearcher;
import com.jingyusoft.amity.testgroups.DatabaseRequired;
import com.jingyusoft.amity.users.UserAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(UnitTestConfigConstants.APPLICATION_CONTEXT_PATH)
public class ItineraryServiceTest {

	@Resource
	private ItineraryService itineraryService;

	@Resource
	private UserAccountService userAccountService;

	@Resource
	private CitySearcher citySearcher;

	@Resource
	private LoadingCache<Integer, City> cityCache;

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	@Category(DatabaseRequired.class)
	public void testItineraryCrud() throws ParseException {

		// Register user
		AmityUser amityUser = userAccountService.registerAmityUser("univer.shi@gmail.com", "dummy");

		// Create itinerary
		int departureCity = citySearcher.searchCitiesByName("Beijing", 1).get(0).getId();
		int arrivalCity = citySearcher.searchCitiesByName("Shanghai", 1).get(0).getId();
		Itinerary itinerary = itineraryService.createItinerary(amityUser.getId(), departureCity, DateTime.now(),
				arrivalCity, DateTime.now());
		Assert.assertNotNull(itinerary);

		// List itineraries
		List<Itinerary> list = itineraryService.listItineraries(amityUser.getId());
		Assert.assertEquals(1, list.size());
		Assert.assertNotNull(list.get(0).getDepartureCity());
		Assert.assertNotNull(list.get(0).getDepartureCity().getCountry());

		// Search itineraries
		List<Itinerary> searchResult = itineraryService.searchItineraries(cityCache.getUnchecked(departureCity),
				cityCache.getUnchecked(arrivalCity), new ItinerarySearchOption());
		Assert.assertEquals(1, searchResult.size());
	}
}
