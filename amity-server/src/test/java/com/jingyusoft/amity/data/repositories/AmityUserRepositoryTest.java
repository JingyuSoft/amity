package com.jingyusoft.amity.data.repositories;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jingyusoft.amity.config.UnitTestConfigConstants;
import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.domain.AmityUserType;
import com.jingyusoft.amity.testgroups.DatabaseRequired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(UnitTestConfigConstants.APPLICATION_CONTEXT_PATH)
public class AmityUserRepositoryTest {

	@Resource
	private AmityUserRepository amityUserRepository;

	@Test
	@Category(DatabaseRequired.class)
	public void testCreateAmityUser() {
		AmityUserEntity amityUserEntity = new AmityUserEntity();
		amityUserEntity.setFirstName("Univer");
		amityUserEntity.setLastName("Shi");
		amityUserEntity.setAlias("Univer");
		amityUserEntity.setEmailAddress("univer.shi@gmail.com");
		amityUserEntity.setUserType(AmityUserType.AMITY.getCode());

		amityUserRepository.saveAndFlush(amityUserEntity);
		Assert.assertTrue(amityUserEntity.getId() > 0);

		amityUserRepository.getOne(amityUserEntity.getId());
	}
}
