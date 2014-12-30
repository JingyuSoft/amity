package com.jingyusoft.amity.domain.geographics;

import java.text.DecimalFormat;

import net.jcip.annotations.Immutable;

@Immutable
public class GeoLocation {

	public static GeoLocation from(final double latitude, final double longitude) {
		return new GeoLocation(latitude, longitude);
	}

	private final double latitude;

	private final double longitude;

	private GeoLocation(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double distanceTo(final GeoLocation other) {
		return GeoUtils.distanceBetween(latitude, longitude, other.latitude, other.longitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		GeoLocation other = (GeoLocation) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude)) {
			return false;
		}
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude)) {
			return false;
		}
		return true;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ temp >>> 32);
		return result;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.####");
		return "[" + df.format(latitude) + ", " + df.format(longitude) + "]";
	}
}
