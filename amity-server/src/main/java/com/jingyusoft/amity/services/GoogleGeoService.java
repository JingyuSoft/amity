package com.jingyusoft.amity.services;

import com.google.code.geocoder.model.GeocodeResponse;

public interface GoogleGeoService {

	GeocodeResponse search(final String address);
}
