package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.thrift.generated.AmityToken;

public interface AuthenticationService {

	AmityUserAuthenticationResult amityUserLogin(final String emailAddress, final String plainPassword);

	AmityUserAuthenticationResult authenticateAmityUser(final long amityUserId, AmityToken authToken);

	AmityUserAuthenticationResult authenticateFacebookAccount(final String facebookToken);
}
