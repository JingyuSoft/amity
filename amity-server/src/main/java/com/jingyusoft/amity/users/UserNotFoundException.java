package com.jingyusoft.amity.users;

import com.jingyusoft.amity.AmityException;
import com.jingyusoft.amity.common.StringMessage;

public class UserNotFoundException extends AmityException {

	public static final UserNotFoundException byEmail(final String emailAddress) {
		return new UserNotFoundException(StringMessage.with("Amity user not found with email address [{}]",
				emailAddress));
	}

	public static final UserNotFoundException byId(final String amityUserId) {
		return new UserNotFoundException(StringMessage.with("Amity user not found with ID [{}]", amityUserId));
	}

	private static final long serialVersionUID = 1L;

	private UserNotFoundException(final String message) {
		super(message);
	}
}
