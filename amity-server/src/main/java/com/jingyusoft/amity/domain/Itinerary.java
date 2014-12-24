package com.jingyusoft.amity.domain;

import org.joda.time.DateTime;

import com.jingyusoft.amity.data.entities.ItineraryEntity;
import com.jingyusoft.amity.domain.geographics.City;

public class Itinerary {

	private Long itineraryId;

	private AmityUser amityUser;

	private City departureCity;

	private DateTime departureDateTime;

	private City arrivalCity;

	private DateTime arrivalDateTime;

	public Itinerary(final ItineraryEntity entity) {
		itineraryId = entity.getId();
		amityUser = new AmityUser(entity.getUser());
		departureCity = new City(entity.getDepartureCity());
		departureDateTime = entity.getDepartureDateTime();
		arrivalCity = new City(entity.getArrivalCity());
		arrivalDateTime = entity.getArrivalDateTime();
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

	@Override
	public String toString() {
		return "Itinerary [itineraryId=" + itineraryId + ", amityUser=" + amityUser + ", departureCity="
				+ departureCity + ", departureDateTime=" + departureDateTime + ", arrivalCity=" + arrivalCity
				+ ", arrivalDateTime=" + arrivalDateTime + "]";
	}
}
