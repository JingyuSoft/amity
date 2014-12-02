package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.thrift.generated.AmityToken;

public interface AuthenticationService {

	AmityUser authenticateAmityUser(final long amityUserId, AmityToken authToken);

	AmityUser authenticateFacebookAccount(final String facebookToken);
}
