package com.jingyusoft.amity.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.jingyusoft.amity.common.WrappedException;

@Service
public class GoogleGeoServiceImpl implements GoogleGeoService {

	private final Geocoder geocoder = new Geocoder();

	public GeocodeResponse search(final String address) {

		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("en")
				.getGeocoderRequest();

		try {
			GeocodeResponse response = geocoder.geocode(geocoderRequest);
			return response;
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
