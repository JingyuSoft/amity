package com.jingyusoft.amity.users;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyusoft.amity.authentication.AuthenticationUtils;
import com.jingyusoft.amity.common.SecurityUtils;
import com.jingyusoft.amity.data.dao.UserAccountDao;
import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.diagnostics.ExecutionTimed;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.domain.AmityUserType;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private UserAvatarRepository userAvatarRepository;

	@Resource
	private UserAccountDao userAccountDao;

	@Override
	@ExecutionTimed
	@Transactional(propagation = Propagation.REQUIRED)
	public AmityUser getAmityUser(long amityUserId) {
		return new AmityUser(amityUserRepository.getOne(amityUserId));
	}

	@Override
	public Optional<AmityUser> getAmityUserByEmail(String emailAddress) {
		Optional<AmityUserEntity> amityUserEntity = userAccountDao.getAmityUserByEmail(emailAddress);
		if (amityUserEntity.isPresent()) {
			return Optional.of(new AmityUser(amityUserEntity.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public byte[] getAvatar(long amityUserId) {
		return userAvatarRepository.getAvatar(amityUserId);
	}

	@Override
	public AmityUser registerAmityUser(String emailAddress, String password) {
		AmityUserEntity amityUserEntity = new AmityUserEntity();
		amityUserEntity.setUserType(AmityUserType.AMITY.getCode());
		amityUserEntity.setEmailAddress(emailAddress);
		amityUserEntity.setPasswordSand(SecurityUtils.generateRandomString(16));
		final String encryptedPassword = AuthenticationUtils.encryptPassword(password,
				amityUserEntity.getPasswordSand());
		amityUserEntity.setEncryptedPassword(encryptedPassword);
		amityUserEntity = amityUserRepository.saveAndFlush(amityUserEntity);
		return new AmityUser(amityUserEntity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean removeAvatar(long amityUserId) {
		return userAvatarRepository.removeAvatar(amityUserId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateAvatar(long amityUserId, byte[] avatar) {
		return userAvatarRepository.updateAvatar(amityUserId, avatar);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUserProfile(AmityUser amityUser) {
		amityUserRepository.saveAndFlush(amityUser.toEntity());
	}
}
