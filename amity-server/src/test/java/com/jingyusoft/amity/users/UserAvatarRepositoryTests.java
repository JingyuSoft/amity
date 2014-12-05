package com.jingyusoft.amity.users;

import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.config.UnitTestConfigConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(UnitTestConfigConstants.APPLICATION_CONTEXT_PATH)
public class UserAvatarRepositoryTests {

	@Resource
	private UserAvatarRepository userAvatarRepository;

	@Test
	public void testLoadAndSaveFile() {

		long amityUserId = new Random().nextLong();

		try {
			byte[] avatar = IOUtils.toByteArray(UserAvatarRepositoryTests.class.getResourceAsStream("Avatar.png"));
			userAvatarRepository.saveAvatar(amityUserId, avatar);

			Assert.assertTrue(userAvatarRepository.avatarFileExists(amityUserId));
			byte[] refetched = userAvatarRepository.getAvatar(amityUserId);

			Assert.assertArrayEquals(avatar, refetched);
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
