package com.jingyusoft.amity.programs;

import javax.annotation.Resource;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderResult;
import com.jingyusoft.amity.services.GoogleGeoService;

public class GeoCoderConsole extends TestConsoleBase {

	@Resource
	private GoogleGeoService googleGeoService;

	@Override
	protected void startConsole() {

		GeocodeResponse geocoderResponse = googleGeoService.search("Beijing, China");
		for (GeocoderResult result : geocoderResponse.getResults()) {
			System.out.println(result.getGeometry().getLocation().toString());
		}
	}
}
