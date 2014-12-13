package com.jingyusoft.amity.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

import com.jingyusoft.amity.common.SecurityUtils;
import com.jingyusoft.amity.config.UnitTestConfigConstants;
import com.jingyusoft.amity.testgroups.DatabaseRequired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(UnitTestConfigConstants.APPLICATION_CONTEXT_PATH)
public class RedisBasicTest {

	@Value("${amity.redis.host}")
	private String redisHost;

	@Value("${amity.redis.port}")
	private int redisPort;

	@Value("${amity.redis.password.file}")
	private String redisPasswordFile;

	private String redisPassword;

	@Before
	public void before() {
		redisPassword = SecurityUtils.getPasswordFromFile(redisPasswordFile);
	}

	@Test
	@Category(DatabaseRequired.class)
	public void testConnection() {
		Jedis jedis = new Jedis(redisHost, redisPort);
		jedis.auth(redisPassword);
		jedis.connect();

		jedis.get("foo");
	}
}
