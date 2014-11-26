package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.domain.AmityUser;

public interface AuthenticationService {

	AmityUser authenticateFacebookAccount(final String facebookToken);
}
