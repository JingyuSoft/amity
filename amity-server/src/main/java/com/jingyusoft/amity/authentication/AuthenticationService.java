package com.jingyusoft.amity.authentication;

public interface AuthenticationService {

	boolean authenticateFacebookAccount(final int facebookId, final String facebookToken);
}
