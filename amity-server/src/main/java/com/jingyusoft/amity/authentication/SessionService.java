package com.jingyusoft.amity.authentication;

import com.jingyusoft.amity.thrift.generated.AmityToken;

public interface SessionService {

	AmityToken createSession(final long amityUserId);

	boolean validateSessionToken(final long amityUserId, AmityToken sessionToken);
}
