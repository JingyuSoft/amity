package com.jingyusoft.amity.users;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.domain.AmityUser;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private UserAvatarRepository userAvatarRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AmityUser getAmityUser(long amityUserId) {
		return new AmityUser(amityUserRepository.getOne(amityUserId));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public byte[] getAvatar(long amityUserId) {
		return userAvatarRepository.getAvatar(amityUserId);
	}

	@Override
	public AmityUser registerAmityUser(String emailAddress, String password) {
		// TODO Auto-generated method stub
		return null;
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
