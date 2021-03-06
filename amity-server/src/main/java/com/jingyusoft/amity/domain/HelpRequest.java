package com.jingyusoft.amity.domain;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.google.common.cache.LoadingCache;
import com.jingyusoft.amity.common.DateTimeUtils;
import com.jingyusoft.amity.data.entities.HelpRequestEntity;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.thrift.generated.HelpRequestDto;

public class HelpRequest {

	@Service
	public static class Factory {

		@Resource
		private LoadingCache<Integer, City> cityCache;

		public HelpRequest fromEntity(HelpRequestEntity entity) {

			HelpRequest helpRequest = new HelpRequest();

			helpRequest.helpRequestId = entity.getId();
			helpRequest.amityUser = new AmityUser(entity.getUser());
			helpRequest.fromCity = cityCache.getUnchecked(entity.getFromCity().getId());
			helpRequest.fromDateTime = entity.getFromDateTime();
			helpRequest.toCity = cityCache.getUnchecked(entity.getToCity().getId());
			helpRequest.toDateTime = entity.getToDateTime();

			return helpRequest;
		}
	}

	private Long helpRequestId;

	private AmityUser amityUser;

	private City fromCity;

	private DateTime fromDateTime;

	private City toCity;

	private DateTime toDateTime;

	private HelpRequest() {
	}

	public AmityUser getAmityUser() {
		return amityUser;
	}

	public City getFromCity() {
		return fromCity;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public Long getHelpRequestId() {
		return helpRequestId;
	}

	public City getToCity() {
		return toCity;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setAmityUser(AmityUser amityUser) {
		this.amityUser = amityUser;
	}

	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public void setHelpRequestId(Long helpRequestId) {
		this.helpRequestId = helpRequestId;
	}

	public void setToCity(City toCity) {
		this.toCity = toCity;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public HelpRequestDto toDto() {
		return new HelpRequestDto().setId(getHelpRequestId()).setUserId(amityUser.getId())
				.setFromCityId(fromCity.getId()).setFromDate(DateTimeUtils.toDateString(fromDateTime))
				.setToCityId(toCity.getId()).setToDate(DateTimeUtils.toDateString(toDateTime));
	}

	@Override
	public String toString() {
		return "HelpRequest [helpRequestId=" + helpRequestId + ", amityUser=" + amityUser + ", fromCity=" + fromCity
				+ ", fromDateTime=" + fromDateTime + ", toCity=" + toCity + ", toDateTime=" + toDateTime + "]";
	}
}
