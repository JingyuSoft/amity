package com.jingyusoft.amity.authentication.facebook;

public interface FacebookAuthenticationService {

	FacebookUserInfo getUserInfo(final String userToken);
}
