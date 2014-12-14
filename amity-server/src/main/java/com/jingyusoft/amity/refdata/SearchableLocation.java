package com.jingyusoft.amity.refdata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.domain.geographics.Country;
import com.jingyusoft.amity.domain.geographics.LocationBase;
import com.jingyusoft.amity.domain.geographics.Region;

public class SearchableLocation {

	private String name;

	private LocationBase location;

	private List<LocationBase> resultLocations;

	public SearchableLocation(City city) {
		location = city;
		name = city.getName();
		resultLocations = ImmutableList.of(city);
	}

	public SearchableLocation(Country country) {
		location = country;
		name = country.getName();
		List<City> cities = Lists.newArrayList();
		cities.addAll(country.getRegions().stream()
				.flatMap(region -> Stream.of(region.getCities().toArray(new City[0]))).collect(Collectors.toList()));
		cities.addAll(country.getCities());
		resultLocations = ImmutableList.copyOf(cities);
	}

	public SearchableLocation(Region region) {
		location = region;
		name = region.getName();
		resultLocations = ImmutableList.copyOf(region.getCities());
	}

	public LocationBase getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public List<LocationBase> getResultLocations() {
		return resultLocations;
	}

	public void setLocation(LocationBase location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResultLocations(List<LocationBase> resultLocations) {
		this.resultLocations = resultLocations;
	}
}
