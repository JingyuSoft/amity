package com.jingyusoft.amity.users;

import com.jingyusoft.amity.domain.AmityUser;

public interface UserAccountService {

	AmityUser getAmityUser(long amityUserId);

	byte[] getAvatar(long amityUserId);

	void removeAvatar(long amityUserId);

	String updateAvatar(long amityUserId, byte[] avatar);

	void updateUserProfile(AmityUser amityUser);
}
