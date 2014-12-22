package com.jingyusoft.amity.programs;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderResult;
import com.jingyusoft.amity.domain.geographics.GeoLocation;
import com.jingyusoft.amity.services.GoogleGeoService;

public class GeoCoderConsole extends TestConsoleBase {

	private static class HelperCity {

		private final String cityName;

		private final double latitude;

		private final double longitude;

		public HelperCity(String cityName, double latitude, double longitude) {
			this.cityName = cityName;
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public String getCityName() {
			return cityName;
		}

		public double getLatitude() {
			return latitude;
		}

		public double getLongitude() {
			return longitude;
		}
	}

	@Resource
	private GoogleGeoService googleGeoService;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	protected void startConsole() {

		Query query = entityManager
				.createNativeQuery("SELECT concat(ifnull(ci.display_name, ci.city_name), ', ', co.country_name), ci.latitude, ci.longitude FROM city ci INNER JOIN country co ON ci.country_id = co.id limit 10000");

		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();

		List<HelperCity> helpers = list.stream()
				.map(item -> new HelperCity((String) item[0], (Double) item[1], (Double) item[2]))
				.collect(Collectors.toList());

		for (HelperCity city : helpers) {

			GeocodeResponse geocoderResponse = googleGeoService.search(city.getCityName());
			for (GeocoderResult result : geocoderResponse.getResults()) {
				StringBuilder sb = new StringBuilder();
				sb.append(StringUtils.rightPad(city.getCityName(), 40));

				GeoLocation amityLocation = GeoLocation.from(city.getLatitude(), city.getLongitude());
				sb.append(StringUtils.rightPad(amityLocation.toString(), 30));

				GeoLocation googleLocation = GeoLocation.from(
						result.getGeometry().getLocation().getLat().doubleValue(), result.getGeometry().getLocation()
								.getLng().doubleValue());
				sb.append(StringUtils.rightPad(googleLocation.toString(), 30));

				double distance = amityLocation.distanceTo(googleLocation);
				sb.append(distance);

				if (distance <= 10) {
					System.out.println(sb.toString());
				} else {
					System.err.println(sb.toString());
				}
			}
		}
	}
}
