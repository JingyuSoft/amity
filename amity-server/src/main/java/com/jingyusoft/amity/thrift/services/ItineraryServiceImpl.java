package com.jingyusoft.amity.thrift.services;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.CreateHelperItineraryRequest;
import com.jingyusoft.amity.thrift.generated.CreateHelperItineraryResponse;
import com.jingyusoft.amity.thrift.generated.ItineraryThriftService;

@Service
public class ItineraryServiceImpl implements ItineraryThriftService.Iface {

	@Override
	public CreateHelperItineraryResponse createItinerary(CreateHelperItineraryRequest request) throws TException {
		// TODO Auto-generated method stub
		return null;
	}
}
