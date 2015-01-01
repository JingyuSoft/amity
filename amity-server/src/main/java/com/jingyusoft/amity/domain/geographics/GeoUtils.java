package com.jingyusoft.amity.domain.geographics;

public class GeoUtils {

	public static double degreeToRadian(double deg) {
		return deg * Math.PI / 180.0;
	}

	public static double distanceBetween(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(degreeToRadian(lat1)) * Math.sin(degreeToRadian(lat2)) + Math.cos(degreeToRadian(lat1))
				* Math.cos(degreeToRadian(lat2)) * Math.cos(degreeToRadian(theta));
		dist = Math.acos(dist);
		dist = radianToDegree(dist);
		dist = dist * 60 * 1.853159616;
		return dist;
	}

	public static double radianToDegree(double rad) {
		return rad * 180 / Math.PI;
	}
}
