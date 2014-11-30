package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jingyusoft.amity.config.UnitTestConfigConstants;
import com.jingyusoft.amity.domain.AmityUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(UnitTestConfigConstants.APPLICATION_CONTEXT_PATH)
public class AuthenticationServiceTests {

	@Resource
	private AuthenticationService authenticationService;

	@Test
	public void testAuthenticateFacebookAccount() {

		final String facebookToken = System.getProperty("facebook.token");

		if (!StringUtils.isEmpty(facebookToken)) {
			AmityUser amityUser = authenticationService.authenticateFacebookAccount(facebookToken);
			Assert.assertNotNull(amityUser);
		}
	}
}
