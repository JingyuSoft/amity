package com.jingyusoft.amity.thrift.services;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.CreateHelperItineraryRequest;
import com.jingyusoft.amity.thrift.generated.CreateHelperItineraryResponse;
import com.jingyusoft.amity.thrift.generated.ItineraryThriftService;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Service
public class ItineraryServiceImpl implements ItineraryThriftService.Iface {

	@Override
	public CreateHelperItineraryResponse createItinerary(CreateHelperItineraryRequest request,
			SessionCredentials credentials) throws TException {
		return null;
	}
}
