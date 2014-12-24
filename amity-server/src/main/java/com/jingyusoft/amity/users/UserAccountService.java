package com.jingyusoft.amity.users;

import java.util.Optional;

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
	 * Get Amity user by email address
	 *
	 * @param emailAddress
	 *            Email address
	 *
	 * @return Amity User
	 */
	Optional<AmityUser> getAmityUserByEmail(final String emailAddress);

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
	 * Register a new Amity user
	 *
	 * @param emailAddress
	 *            Email address
	 * @param password
	 *            Plain text password
	 *
	 * @return The registered Amity user
	 */
	AmityUser registerAmityUser(String emailAddress, String password);

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
