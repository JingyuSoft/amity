package com.jingyusoft.amity.authentication.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.JsonUtils;
import com.jingyusoft.amity.common.WrappedException;

@Service
public class FacebookAuthenticationServiceImpl implements FacebookAuthenticationService {

	private static String readUrl(String urlString) {

		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}

			return buffer.toString();
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// Ignore
				}
			}
		}
	}

	private static final String FACEBOOK_USER_INFO_URL_PREFIX = "https://graph.facebook.com/me?access_token=";

	@Override
	public FacebookUserInfo getUserInfo(String userAccessToken) {
		final String url = FACEBOOK_USER_INFO_URL_PREFIX + userAccessToken;

		String json = readUrl(url);

		FacebookUserInfo userInfo = JsonUtils.fromJson(json, FacebookUserInfo.class);

		return userInfo;
	}
}
