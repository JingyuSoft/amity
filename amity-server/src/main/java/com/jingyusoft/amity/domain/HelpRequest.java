package com.jingyusoft.amity.domain;

import org.joda.time.DateTime;

import com.jingyusoft.amity.data.entities.HelpRequestEntity;
import com.jingyusoft.amity.domain.geographics.City;

public class HelpRequest {

	private Long helpRequestId;

	private AmityUser amityUser;

	private City fromCity;

	private DateTime fromDateTime;

	private City toCity;

	private DateTime toDateTime;

	public HelpRequest(HelpRequestEntity entity) {
		helpRequestId = entity.getId();
		amityUser = new AmityUser(entity.getAmityUser());
		fromCity = new City(entity.getFromCity());
		fromDateTime = entity.getFromDateTime();
		toCity = new City(entity.getToCity());
		toDateTime = entity.getToDateTime();
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

	@Override
	public String toString() {
		return "HelpRequest [helpRequestId=" + helpRequestId + ", amityUser=" + amityUser + ", fromCity=" + fromCity
				+ ", fromDateTime=" + fromDateTime + ", toCity=" + toCity + ", toDateTime=" + toDateTime + "]";
	}
}
