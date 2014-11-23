package com.jingyusoft.amity.thrift.services;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.ItineraryService;

@Service
public class ItineraryServiceImpl implements ItineraryService.Iface {

	@Override
	public String echo(String request) throws TException {
		return request;
	}
}
