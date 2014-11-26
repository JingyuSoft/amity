package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.thrift.generated.AmityToken;

public interface SessionService {

	AmityToken createSessionToken(final AmityToken authToken);

	boolean validateSessionToken(final long amityUserId, AmityToken sessionToken);
}
