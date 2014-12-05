package com.jingyusoft.amity.users;

import com.jingyusoft.amity.domain.AmityUser;

public interface UserAccountService {

	AmityUser getAmityUser(long amityUserId);

	void updateUserProfile(AmityUser amityUser);

	String uploadAvatar(long amityUserId, byte[] avatar);
}
