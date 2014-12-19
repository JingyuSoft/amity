package com.jingyusoft.amity.refdata;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.data.repositories.CityRepository;
import com.jingyusoft.amity.data.repositories.CountryRepository;
import com.jingyusoft.amity.data.repositories.RegionRepository;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.domain.geographics.Country;
import com.jingyusoft.amity.domain.geographics.Region;

@Repository
public class LocationCache {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocationCache.class);

	@Resource
	private CountryRepository countryRepository;

	@Resource
	private RegionRepository regionRepository;

	@Resource
	private CityRepository cityRepository;

	private final LoadingCache<Integer, Country> countryCache = CacheBuilder.newBuilder().build(
			new CacheLoader<Integer, Country>() {

				@Override
				public Country load(Integer key) throws Exception {
					Country country = new Country(countryRepository.getOne(key));
					return country;
				}
			});

	private final LoadingCache<Integer, Region> regionCache = CacheBuilder.newBuilder().build(
			new CacheLoader<Integer, Region>() {

				@Override
				public Region load(Integer key) throws Exception {
					Region region = new Region(regionRepository.getOne(key));
					if (region.getCountryId() != null) {
						Country country = countryCache.get(region.getCountryId());
						region.setCountry(country);
						country.addRegion(region);
					}
					return region;
				}
			});

	private final LoadingCache<Integer, City> cityCache = CacheBuilder.newBuilder().build(
			new CacheLoader<Integer, City>() {

				@Override
				public City load(Integer key) throws Exception {
					City city = new City(cityRepository.getOne(key));

					if (city.getRegionId() != null) {
						Region region = regionCache.get(city.getRegionId());
						city.setRegion(region);
						region.addCity(city);
					}

					if (city.getCountryId() != null) {
						Country country = countryCache.get(city.getCountryId());
						city.setCountry(country);
						country.addCity(city);
					}

					return city;
				}
			});

	public City getCityFromCache(final int cityId) {
		try {
			return cityCache.get(cityId);
		} catch (ExecutionException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
