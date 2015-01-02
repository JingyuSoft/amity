package com.jingyusoft.amity.thrift.services;

import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.google.common.cache.LoadingCache;
import com.jingyusoft.amity.common.DateTimeUtils;
import com.jingyusoft.amity.common.ErrorCodes;
import com.jingyusoft.amity.domain.HelpRequest;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.services.HelpRequestService;
import com.jingyusoft.amity.thrift.generated.CreateHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.CreateHelpRequestResponse;
import com.jingyusoft.amity.thrift.generated.DeleteHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.DeleteHelpRequestResponse;
import com.jingyusoft.amity.thrift.generated.GetHelpRequestRequest;
import com.jingyusoft.amity.thrift.generated.GetHelpRequestResponse;
import com.jingyusoft.amity.thrift.generated.HelpRequestDto;
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
	private LoadingCache<Integer, City> cityCache;

	@Override
	public CreateHelpRequestResponse createHelpRequest(CreateHelpRequestRequest request, SessionCredentials credentials)
			throws TException {

		HelpRequest helpRequest = helpRequestService.createHelpRequest(credentials.getAmityUserId(), request
				.getHelpRequest().getFromCityId(), DateTimeUtils.safeParse(request.getHelpRequest().getFromDate()),
				request.getHelpRequest().getToCityId(), DateTimeUtils.safeParse(request.getHelpRequest().getToDate()));

		return new CreateHelpRequestResponse().setHelpRequestId(helpRequest.getHelpRequestId());
	}

	@Override
	public DeleteHelpRequestResponse deleteHelpRequest(DeleteHelpRequestRequest request, SessionCredentials credentials)
			throws TException {

		if (helpRequestService.deleteHelpRequest(request.getHelpRequestId())) {
			return new DeleteHelpRequestResponse(ErrorCodes.HELP_REQUEST_NOT_FOUND_BY_ID);
		} else {
			return new DeleteHelpRequestResponse();
		}
	}

	@Override
	public GetHelpRequestResponse getHelpRequest(GetHelpRequestRequest request, SessionCredentials credentials)
			throws TException {

		HelpRequest helpRequest = helpRequestService.getHelpRequest(request.getHelpRequestId());
		if (helpRequest == null) {
			return new GetHelpRequestResponse(ErrorCodes.HELP_REQUEST_NOT_FOUND_BY_ID);
		} else {
			HelpRequestDto helpRequestDto = helpRequest.toDto();
			helpRequestDto.setFromCity(helpRequest.getFromCity().toDto());
			helpRequestDto.setToCity(helpRequest.getToCity().toDto());
			return new GetHelpRequestResponse().setHelpRequest(helpRequestDto);
		}
	}

	@Override
	public ListHelpRequestResponse listHelpRequests(ListHelpRequestRequest request, SessionCredentials credentials)
			throws TException {

		return new ListHelpRequestResponse().setHelpRequests(helpRequestService
				.listHelpRequests(request.getAmityUserId()).stream().map(item -> {
					HelpRequestDto helpRequestDto = item.toDto();
					helpRequestDto.setFromCity(item.getFromCity().toDto());
					helpRequestDto.setToCity(item.getToCity().toDto());
					return helpRequestDto;
				}).collect(Collectors.toList()));
	}

	@Override
	public UpdateHelpRequestResponse updateHelpRequest(UpdateHelpRequestRequest request, SessionCredentials credentials)
			throws TException {

		HelpRequest helpRequest = helpRequestService.updateHelpRequest(request.getHelpRequest().getId(), request
				.getHelpRequest().getFromCityId(), DateTimeUtils.safeParse(request.getHelpRequest().getFromDate()),
				request.getHelpRequest().getToCityId(), DateTimeUtils.safeParse(request.getHelpRequest().getToDate()));

		if (helpRequest == null) {
			return new UpdateHelpRequestResponse(ErrorCodes.HELP_REQUEST_NOT_FOUND_BY_ID);
		} else {
			return new UpdateHelpRequestResponse();
		}
	}
}
