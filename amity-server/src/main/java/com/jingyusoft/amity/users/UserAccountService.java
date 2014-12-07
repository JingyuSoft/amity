package com.jingyusoft.amity.users;

import com.jingyusoft.amity.domain.AmityUser;

public interface UserAccountService {

	/**
	 *
	 * Get Amity user by ID
	 *
	 * @param amityUserId
	 *            Amity user ID
	 *
	 * @return Amity user
	 */
	AmityUser getAmityUser(long amityUserId);

	/**
	 *
	 * Get user avatar
	 *
	 * @param amityUserId
	 *            Amity user ID
	 *
	 * @return The avatar file in byte array
	 */
	byte[] getAvatar(long amityUserId);

	/**
	 *
	 * Remove user avatar
	 *
	 * @param amityUserId
	 *            Amity user ID
	 *
	 * @return True if the avatar existed and was successfully removed; otherwise false.
	 */
	boolean removeAvatar(long amityUserId);

	/**
	 *
	 * Update user avatar
	 *
	 * @param amityUserId
	 *            Amity user ID
	 * @param avatar
	 *            The avatar file in byte array
	 *
	 * @return The file name of the avatar
	 */
	String updateAvatar(long amityUserId, byte[] avatar);

	/**
	 *
	 * Update the user profile
	 *
	 * @param amityUser
	 */
	void updateUserProfile(AmityUser amityUser);
}
