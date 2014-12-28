package com.jingyusoft.amity.services;

import java.util.List;

import org.joda.time.DateTime;

import com.jingyusoft.amity.domain.HelpRequest;

public interface HelpRequestService {

	HelpRequest createHelpRequest(final long amityUserId, final int fromCityId, final DateTime fromDate,
			final int toCityId, final DateTime toDate);

	boolean deleteHelpRequest(final long helpRequestId);

	HelpRequest getHelpRequest(final long helpRequestId);

	List<HelpRequest> listHelpRequests(final long amityUserId);

	HelpRequest updateHelpRequest(final long helpRequestId, final int fromCityId, final DateTime fromDate,
			final int toCityId, final DateTime toDate);
}
