package com.jingyusoft.amity.domain;

import org.joda.time.DateTime;

import com.jingyusoft.amity.data.entities.ItineraryEntity;
import com.jingyusoft.amity.domain.geographics.City;

public class Itinerary {

	private Long itineraryId;

	private AmityUser amityUser;

	private City departureCity;

	private DateTime departureDate;

	private City arrivalCity;

	private DateTime arrivalDate;

	public Itinerary(final ItineraryEntity entity) {
		itineraryId = entity.getId();
		amityUser = new AmityUser(entity.getUser());
		departureCity = new City(entity.getDepartureCity());
		departureDate = entity.getDepartureDate();
		arrivalCity = new City(entity.getArrivalCity());
		arrivalDate = entity.getArrivalDate();
	}

	public AmityUser getAmityUser() {
		return amityUser;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public DateTime getArrivalDate() {
		return arrivalDate;
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public DateTime getDepartureDate() {
		return departureDate;
	}

	public Long getItineraryId() {
		return itineraryId;
	}

	public final boolean isCreated() {
		return itineraryId != null;
	}

	public void setAmityUser(AmityUser amityUser) {
		this.amityUser = amityUser;
	}

	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public void setArrivalDate(DateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public void setDepartureDate(DateTime departureDate) {
		this.departureDate = departureDate;
	}

	public void setItineraryId(Long itineraryId) {
		this.itineraryId = itineraryId;
	}

	@Override
	public String toString() {
		return "Itinerary [itineraryId=" + itineraryId + ", amityUser=" + amityUser + ", departureCity="
				+ departureCity + ", departureDate=" + departureDate + ", arrivalCity=" + arrivalCity
				+ ", arrivalDate=" + arrivalDate + "]";
	}
}
