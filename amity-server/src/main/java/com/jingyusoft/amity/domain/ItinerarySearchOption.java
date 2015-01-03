package com.jingyusoft.amity.domain;

public class ItinerarySearchOption {

	private double maxDistanceToDepartureLocation = 20.0;

	private double maxDistanceToArrivalLocation = 20.0;

	private int maxNearbyDepartureCities = 1000;

	private int maxNearbyArrivalCities = 1000;

	public double getMaxDistanceToArrivalLocation() {
		return maxDistanceToArrivalLocation;
	}

	public double getMaxDistanceToDepartureLocation() {
		return maxDistanceToDepartureLocation;
	}

	public int getMaxNearbyArrivalCities() {
		return maxNearbyArrivalCities;
	}

	public int getMaxNearbyDepartureCities() {
		return maxNearbyDepartureCities;
	}

	public void setMaxDistanceToArrivalLocation(double maxDistanceToArrivalLocation) {
		this.maxDistanceToArrivalLocation = maxDistanceToArrivalLocation;
	}

	public void setMaxDistanceToDepartureLocation(double maxDistanceToDepartureLocation) {
		this.maxDistanceToDepartureLocation = maxDistanceToDepartureLocation;
	}

	public void setMaxNearbyArrivalCities(int maxNearbyArrivalCities) {
		this.maxNearbyArrivalCities = maxNearbyArrivalCities;
	}

	public void setMaxNearbyDepartureCities(int maxNearbyDepartureCities) {
		this.maxNearbyDepartureCities = maxNearbyDepartureCities;
	}
}
