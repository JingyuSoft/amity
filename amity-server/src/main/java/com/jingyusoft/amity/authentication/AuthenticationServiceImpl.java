package com.jingyusoft.amity.authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean authenticateFacebookAccount(int facebookId, String facebookToken) {
		return false;
	}
}
