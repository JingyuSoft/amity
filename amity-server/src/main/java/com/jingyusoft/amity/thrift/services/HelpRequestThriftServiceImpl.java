package com.jingyusoft.amity.thrift.services;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.refdata.CityCache;
import com.jingyusoft.amity.services.HelpRequestService;
import com.jingyusoft.amity.thrift.generated.CreateHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.CreateHelpRequestResponse;
import com.jingyusoft.amity.thrift.generated.DeleteHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.DeleteHelpRequestResponse;
import com.jingyusoft.amity.thrift.generated.GetHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.GetHelpRequestResponse;
import com.jingyusoft.amity.thrift.generated.HelpRequestThriftService;
import com.jingyusoft.amity.thrift.generated.ListHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.ListHelpRequestResponse;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;
import com.jingyusoft.amity.thrift.generated.UpdateHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.UpdateHelpRequestResponse;

@Service
public class HelpRequestThriftServiceImpl implements HelpRequestThriftService.Iface {

	@Resource
	private HelpRequestService helpRequestService;

	@Resource
	private CityCache cityCache;

	@Override
	public CreateHelpRequestResponse createHelpRequest(CreateHelpRequestRequest request, SessionCredentials credentials)
			throws TException {

		return null;
	}

	@Override
	public DeleteHelpRequestResponse deleteHelpRequest(DeleteHelpRequestRequest request, SessionCredentials credentials)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetHelpRequestResponse getHelpRequest(GetHelpRequestRequest request, SessionCredentials credentials)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListHelpRequestResponse listHelpRequests(ListHelpRequestRequest request, SessionCredentials credentials)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateHelpRequestResponse updateHelpRequest(UpdateHelpRequestRequest request, SessionCredentials credentials)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}
}
