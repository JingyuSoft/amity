package com.jingyusoft.amity.thrift.services;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.AmityService;

@Service
public class AmityServiceImpl implements AmityService.Iface {

	@Override
	public String echo(String request) throws TException {
		return request;
	}
}
