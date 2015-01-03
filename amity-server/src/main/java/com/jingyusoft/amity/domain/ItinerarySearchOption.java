package com.jingyusoft.amity.domain;

public class ItinerarySearchOption {

	private double departureSearchRadius = 20.0;

	private double arrivalSearchRadius = 20.0;

	private int maxNearbyDepartureCities = 1000;

	private int maxNearbyArrivalCities = 1000;

	public double getArrivalSearchRadius() {
		return arrivalSearchRadius;
	}

	public double getDepartureSearchRadius() {
		return departureSearchRadius;
	}

	public int getMaxNearbyArrivalCities() {
		return maxNearbyArrivalCities;
	}

	public int getMaxNearbyDepartureCities() {
		return maxNearbyDepartureCities;
	}

	public void setArrivalSearchRadius(double arrivalSearchRadius) {
		this.arrivalSearchRadius = arrivalSearchRadius;
	}

	public void setDepartureSearchRadius(double departureSearchRadius) {
		this.departureSearchRadius = departureSearchRadius;
	}

	public void setMaxNearbyArrivalCities(int maxNearbyArrivalCities) {
		this.maxNearbyArrivalCities = maxNearbyArrivalCities;
	}

	public void setMaxNearbyDepartureCities(int maxNearbyDepartureCities) {
		this.maxNearbyDepartureCities = maxNearbyDepartureCities;
	}
}
