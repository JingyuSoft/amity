package com.jingyusoft.amity.thrift.services;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.RefDataThriftService;
import com.jingyusoft.amity.thrift.generated.SearchCitiesRequest;
import com.jingyusoft.amity.thrift.generated.SearchCitiesResponse;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Service
public class RefDataThriftServiceImpl implements RefDataThriftService.Iface {

	@Override
	public SearchCitiesResponse searchCities(SearchCitiesRequest request, SessionCredentials credentials)
			throws TException {
		throw new NotImplementedException("");
	}
}
