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

import com.jingyusoft.amity.config.UnitTestConfigConstants;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.domain.Itinerary;
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

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	@Category(DatabaseRequired.class)
	public void testItineraryCrud() throws ParseException {

		AmityUser amityUser = userAccountService.registerAmityUser("univer.shi@gmail.com", "dummy");
		int departureCity = citySearcher.searchCities("Beijing", 1).get(0).getId();
		int arrivalCity = citySearcher.searchCities("Shanghai", 1).get(0).getId();
		Itinerary itinerary = itineraryService.createItinerary(amityUser.getId(), departureCity, DateTime.now(),
				arrivalCity, DateTime.now());
		Assert.assertNotNull(itinerary);

		List<Itinerary> list = itineraryService.listItineraries(amityUser.getId());
		Assert.assertEquals(1, list.size());
	}
}
