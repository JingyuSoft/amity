package com.jingyusoft.amity.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.data.entities.HelpRequestEntity;
import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.data.repositories.CityRepository;
import com.jingyusoft.amity.data.repositories.HelpRequestRepository;
import com.jingyusoft.amity.domain.HelpRequest;
import com.jingyusoft.amity.users.UserAccountService;

@Service
public class HelpRequestServiceImpl implements HelpRequestService {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Resource
	private HelpRequestRepository helpRequestRepository;

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private CityRepository cityRepository;

	@Resource
	private UserAccountService userAccountService;

	@Resource
	private HelpRequest.Factory helpRequestFactory;

	@Override
	public HelpRequest createHelpRequest(long amityUserId, int fromCityId, DateTime fromDate, int toCityId,
			DateTime toDate) {

		HelpRequestEntity entity = new HelpRequestEntity();
		entity.setUser(amityUserRepository.getOne(amityUserId));
		entity.setFromCity(cityRepository.getOne(fromCityId));
		entity.setFromDateTime(fromDate);
		entity.setToCity(cityRepository.getOne(toCityId));
		entity.setToDateTime(toDate);

		entity = helpRequestRepository.saveAndFlush(entity);
		HelpRequest helpRequest = helpRequestFactory.fromEntity(entity);

		LOGGER.info("New help request created. " + helpRequest);

		return helpRequest;

	}

	@Override
	public boolean deleteHelpRequest(long helpRequestId) {
		if (helpRequestRepository.exists(helpRequestId)) {
			helpRequestRepository.delete(helpRequestId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public HelpRequest getHelpRequest(long helpRequestId) {
		HelpRequestEntity helpRequestEntity = helpRequestRepository.getOne(helpRequestId);
		HelpRequest helpRequest = helpRequestFactory.fromEntity(helpRequestEntity);
		return helpRequest;
	}

	@Override
	public List<HelpRequest> listHelpRequests(long amityUserId) {
		return helpRequestRepository.listHelpRequests(amityUserId).stream().map(item -> {
			HelpRequest helpRequest = helpRequestFactory.fromEntity(item);
			return helpRequest;
		}).collect(Collectors.toList());
	}

	@Override
	public HelpRequest updateHelpRequest(long helpRequestId, int fromCityId, DateTime fromDate, int toCityId,
			DateTime toDate) {

		HelpRequestEntity helpRequestEntity = helpRequestRepository.getOne(helpRequestId);

		if (helpRequestEntity == null) {
			return null;
		}

		helpRequestEntity.setFromCity(cityRepository.getOne(fromCityId));
		helpRequestEntity.setFromDateTime(fromDate);
		helpRequestEntity.setToCity(cityRepository.getOne(toCityId));
		helpRequestEntity.setToDateTime(toDate);

		helpRequestEntity = helpRequestRepository.saveAndFlush(helpRequestEntity);

		return helpRequestFactory.fromEntity(helpRequestEntity);
	}

}
