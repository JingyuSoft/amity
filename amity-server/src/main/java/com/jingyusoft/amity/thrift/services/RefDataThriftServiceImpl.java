package com.jingyusoft.amity.thrift.services;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.thrift.generated.GetCitiesByRegionRequest;
import com.jingyusoft.amity.thrift.generated.GetCitiesByRegionResponse;
import com.jingyusoft.amity.thrift.generated.GetCitiesResponse;
import com.jingyusoft.amity.thrift.generated.GetCountriesResponse;
import com.jingyusoft.amity.thrift.generated.GetRegionsAndCitiesByCountryRequest;
import com.jingyusoft.amity.thrift.generated.GetRegionsAndCitiesByCountryResponse;
import com.jingyusoft.amity.thrift.generated.GetRegionsResponse;
import com.jingyusoft.amity.thrift.generated.RefDataThriftService;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Service
public class RefDataThriftServiceImpl implements RefDataThriftService.Iface {

	@Override
	public GetCitiesResponse getCities(SessionCredentials credentials) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCitiesByRegionResponse getCitiesByRegion(GetCitiesByRegionRequest request, SessionCredentials credentials)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCountriesResponse getCountries(SessionCredentials credentials) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRegionsResponse getRegions(SessionCredentials credentials) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRegionsAndCitiesByCountryResponse getRegionsAndCitiesByCountry(
			GetRegionsAndCitiesByCountryRequest request, SessionCredentials credentials) throws TException {
		// TODO Auto-generated method stub
		return null;
	}
}
