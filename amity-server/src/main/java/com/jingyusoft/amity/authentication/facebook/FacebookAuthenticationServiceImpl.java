package com.jingyusoft.amity.authentication.facebook;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.JsonUtils;
import com.jingyusoft.amity.common.WebUtils;

@Service
public class FacebookAuthenticationServiceImpl implements FacebookAuthenticationService {

	private static final Logger LOGGER = AmityLogger.getLogger();

	private static final String FACEBOOK_USER_INFO_URL_PREFIX = "https://graph.facebook.com/me?access_token=";

	@Override
	public FacebookUserInfo getUserInfo(String userAccessToken) {

		String json = WebUtils.readUrlAsString(FACEBOOK_USER_INFO_URL_PREFIX + userAccessToken);

		try {
			FacebookUserInfo userInfo = JsonUtils.fromJson(json, FacebookUserInfo.class);
			return userInfo;
		} catch (Exception e) {
			LOGGER.warn("Failed to get Facebook user info", e);
			return null;
		}
	}
}
