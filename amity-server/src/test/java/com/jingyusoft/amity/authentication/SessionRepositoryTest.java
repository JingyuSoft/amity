package com.jingyusoft.amity.authentication;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.config.UnitTestConfigConstants;
import com.jingyusoft.amity.thrift.generated.AmityToken;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(UnitTestConfigConstants.APPLICATION_CONTEXT_PATH)
public class SessionRepositoryTest {

	@Resource
	private SessionRepository sessionRepository;

	@Test
	public void testExpiry() {
		AmityToken sessionToken = new AmityToken(UUID.randomUUID().toString());
		sessionRepository.update(1, sessionToken);

		Assert.assertEquals(SessionVerificationResult.SUCCESS, sessionRepository.verify(1, sessionToken));

		Assert.assertEquals(SessionVerificationResult.NOT_MATCH,
				sessionRepository.verify(1, new AmityToken(UUID.randomUUID().toString())));

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			throw WrappedException.insteadOf(e);
		}

		Assert.assertEquals(SessionVerificationResult.NOT_EXIST, sessionRepository.verify(1, sessionToken));
	}
}
