package com.jingyusoft.amity.thrift.services;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.AuthenticationThriftService;
import com.jingyusoft.amity.thrift.generated.LoginFacebookAccountRequest;
import com.jingyusoft.amity.thrift.generated.LoginFacebookAccountResponse;

@Service
public class AuthenticationThriftServiceImpl implements AuthenticationThriftService.Iface {

	@Override
	public LoginFacebookAccountResponse loginFacebookAccount(LoginFacebookAccountRequest request) throws TException {
		return null;
	}
}
