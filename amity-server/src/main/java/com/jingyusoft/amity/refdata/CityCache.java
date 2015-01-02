package com.jingyusoft.amity.refdata;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.data.entities.CityEntity;
import com.jingyusoft.amity.data.repositories.CityRepository;
import com.jingyusoft.amity.domain.geographics.City;
import com.jingyusoft.amity.domain.geographics.Country;

@Component
public class CityCache implements LoadingCache<Integer, City> {

	@Component
	public static class CityCacheLoader extends CacheLoader<Integer, City> {

		@Resource
		private CityRepository cityRepository;

		@Resource
		private LoadingCache<Integer, Country> countryCache;

		@Override
		@Transactional(propagation = Propagation.REQUIRED)
		public City load(Integer key) throws Exception {
			CityEntity cityEntity = cityRepository.getOne(key);
			if (cityEntity == null) {
				return null;
			}

			City city = new City(cityEntity);

			if (city.getCountryId() != null) {
				Country country = countryCache.get(city.getCountryId());
				city.setCountry(country);
				country.addCity(city);
			}

			return city;
		}
	}

	private final LoadingCache<Integer, City> innerCache;

	@Autowired
	public CityCache(CityCacheLoader cacheLoader) {
		innerCache = CacheBuilder.newBuilder().build(cacheLoader);
	}

	@Override
	public City apply(Integer key) {
		return innerCache.apply(key);
	}

	@Override
	public ConcurrentMap<Integer, City> asMap() {
		return innerCache.asMap();
	}

	@Override
	public void cleanUp() {
		innerCache.cleanUp();
	}

	@Override
	public boolean equals(Object object) {
		return innerCache.equals(object);
	}

	@Override
	public City get(Integer key) {
		try {
			return innerCache.get(key);
		} catch (ExecutionException e) {
			throw new ReferenceDataLoadException(City.class, key, e);
		}
	}

	@Override
	public City get(Integer key, Callable<? extends City> valueLoader) {
		try {
			return innerCache.get(key, valueLoader);
		} catch (ExecutionException e) {
			throw new ReferenceDataLoadException(City.class, key, e);
		}
	}

	@Override
	public ImmutableMap<Integer, City> getAll(Iterable<? extends Integer> keys) {
		try {
			return innerCache.getAll(keys);
		} catch (ExecutionException e) {
			throw new ReferenceDataLoadException(City.class, StringUtils.join(keys, ","), e);
		}
	}

	@Override
	public ImmutableMap<Integer, City> getAllPresent(Iterable<?> keys) {
		return innerCache.getAllPresent(keys);
	}

	public City getCityFromCache(final int cityId) {
		try {
			return innerCache.get(cityId);
		} catch (ExecutionException e) {
			throw WrappedException.insteadOf(e);
		}
	}

	@Override
	public City getIfPresent(Object key) {
		return innerCache.getIfPresent(key);
	}

	@Override
	public City getUnchecked(Integer key) {
		return innerCache.getUnchecked(key);
	}

	@Override
	public void invalidate(Object key) {
		innerCache.invalidate(key);
	}

	@Override
	public void invalidateAll() {
		innerCache.invalidateAll();
	}

	@Override
	public void invalidateAll(Iterable<?> keys) {
		innerCache.invalidateAll(keys);
	}

	@Override
	public void put(Integer key, City value) {
		innerCache.put(key, value);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends City> m) {
		innerCache.putAll(m);
	}

	@Override
	public void refresh(Integer key) {
		innerCache.refresh(key);
	}

	@Override
	public long size() {
		return innerCache.size();
	}

	@Override
	public CacheStats stats() {
		return innerCache.stats();
	}
}
