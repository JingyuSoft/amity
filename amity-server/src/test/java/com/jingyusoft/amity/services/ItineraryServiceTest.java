package com.jingyusoft.amity.services;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jingyusoft.amity.config.UnitTestConfigConstants;
import com.jingyusoft.amity.users.UserAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(UnitTestConfigConstants.APPLICATION_CONTEXT_PATH)
public class ItineraryServiceTest {

	@Resource
	private ItineraryService itineraryService;

	@Resource
	private UserAccountService userAccountService;

	@Test
	public void testItineraryCrud() {
	}
}
