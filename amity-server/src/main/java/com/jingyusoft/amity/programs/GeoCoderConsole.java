package com.jingyusoft.amity.programs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.code.geocoder.model.GeocodeResponse;
import com.jingyusoft.amity.common.StringMessage;
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

		@Override
		public String toString() {
			return StringMessage.with("{} ({}, {})", cityName, latitude, longitude);
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
				.createNativeQuery("SELECT concat(ifnull(ci.display_name, ci.city_name), ', ', co.country_name), ci.latitude, ci.longitude FROM city ci INNER JOIN country co ON ci.country_id = co.id AND co.country_name = 'China' limit 100");

		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();

		List<HelperCity> helpers = list.stream()
				.map(item -> new HelperCity((String) item[0], (Double) item[1], (Double) item[2]))
				.collect(Collectors.toList());

		for (HelperCity city : helpers) {

			GeoLocation amityLocation = GeoLocation.from(city.getLatitude(), city.getLongitude());

			GeocodeResponse geocoderResponse = googleGeoService.search(city.getCityName());
			List<GeoLocation> googleLocations = geocoderResponse
					.getResults()
					.stream()
					.map(item -> GeoLocation.from(item.getGeometry().getLocation().getLat().doubleValue(), item
							.getGeometry().getLocation().getLng().doubleValue())).collect(Collectors.toList());

			Optional<GeoLocation> googleLocationOptional = googleLocations.stream().min(
					(a, b) -> amityLocation.distanceTo(a) <= amityLocation.distanceTo(b) ? -1 : 1);

			if (googleLocationOptional.isPresent()) {
				GeoLocation googleLocation = googleLocationOptional.get();

				StringBuilder sb = new StringBuilder();
				sb.append(StringUtils.rightPad(city.getCityName(), 40));

				sb.append(StringUtils.rightPad(amityLocation.toString(), 30));
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
