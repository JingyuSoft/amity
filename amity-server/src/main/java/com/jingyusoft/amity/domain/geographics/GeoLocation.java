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

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.####");
		return "[" + df.format(latitude) + ", " + df.format(longitude) + "]";
	}
}
