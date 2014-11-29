package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

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
		AmityUser amityUser = authenticationService
				.authenticateFacebookAccount("CAACEdEose0cBAAI6igH7emPjSOBMI1LK3zEZCOfyAZB3GzcPPBhnJ6adCx7qdyZB2LJhZAylK7zrJRkh9BfnxJMWFcYYgoOEuDqav1ayleLmtuNL2SsRY8wotIo0OyrOZCDKOyS8FaYO3sTz5EB0YQiNE5VNHYzZCzFzdA7zp9gl39wTMreoRgZBK6MDUcExpZBLjtPZBNG1mCFUYvj6fQDt2ipBqiUeNAC4ZD");
		Assert.assertNotNull(amityUser);
	}
}
