package com.jingyusoft.amity.domain;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.google.common.cache.LoadingCache;
import com.jingyusoft.amity.common.DateTimeUtils;
import com.jingyusoft.amity.data.entities.ItineraryEntity;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.thrift.generated.ItineraryDto;

public class Itinerary {

	@Service
	public static class Factory {

		@Resource
		private LoadingCache<Integer, City> cityCache;

		public Itinerary fromEntity(ItineraryEntity entity) {
			Itinerary itinerary = new Itinerary();
			itinerary.itineraryId = entity.getId();
			itinerary.amityUser = new AmityUser(entity.getUser());
			itinerary.departureCity = cityCache.getUnchecked(entity.getDepartureCity().getId());
			itinerary.departureDateTime = entity.getDepartureDateTime();
			itinerary.arrivalCity = cityCache.getUnchecked(entity.getArrivalCity().getId());
			itinerary.arrivalDateTime = entity.getArrivalDateTime();
			return itinerary;
		}
	}

	private Long itineraryId;

	private AmityUser amityUser;

	private City departureCity;

	private DateTime departureDateTime;

	private City arrivalCity;

	private DateTime arrivalDateTime;

	private Itinerary() {
	}

	public AmityUser getAmityUser() {
		return amityUser;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public DateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public DateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public Long getItineraryId() {
		return itineraryId;
	}

	public void setAmityUser(AmityUser amityUser) {
		this.amityUser = amityUser;
	}

	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public void setArrivalDateTime(DateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public void setDepartureDateTime(DateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public void setItineraryId(Long itineraryId) {
		this.itineraryId = itineraryId;
	}

	public ItineraryDto toDto() {
		return new ItineraryDto().setId(getItineraryId()).setUserId(amityUser.getId())
				.setDepartureCityId(departureCity.getId())
				.setDepartureDate(DateTimeUtils.toDateString(departureDateTime))
				.setArrivalCityId(getArrivalCity().getId()).setArrivalDate(DateTimeUtils.toDateString(arrivalDateTime));
	}

	@Override
	public String toString() {
		return "Itinerary [itineraryId=" + itineraryId + ", amityUser=" + amityUser + ", departureCity="
				+ departureCity + ", departureDateTime=" + departureDateTime + ", arrivalCity=" + arrivalCity
				+ ", arrivalDateTime=" + arrivalDateTime + "]";
	}
}
