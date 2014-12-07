package com.jingyusoft.amity.users;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.domain.AmityUser;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private UserAvatarRepository userAvatarRepository;

	@Override
	public AmityUser getAmityUser(long amityUserId) {
		return new AmityUser(amityUserRepository.getOne(amityUserId));
	}

	@Override
	public byte[] getAvatar(long amityUserId) {
		return userAvatarRepository.getAvatar(amityUserId);
	}

	@Override
	public boolean removeAvatar(long amityUserId) {
		return userAvatarRepository.removeAvatar(amityUserId);
	}

	@Override
	public String updateAvatar(long amityUserId, byte[] avatar) {
		return userAvatarRepository.updateAvatar(amityUserId, avatar);
	}

	@Override
	public void updateUserProfile(AmityUser amityUser) {
		amityUserRepository.saveAndFlush(amityUser.toEntity());
	}
}
