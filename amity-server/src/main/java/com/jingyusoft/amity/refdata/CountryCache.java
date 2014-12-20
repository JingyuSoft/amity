package com.jingyusoft.amity.refdata;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.jingyusoft.amity.data.repositories.CountryRepository;
import com.jingyusoft.amity.domain.geographics.Country;

@Component
public class CountryCache implements LoadingCache<Integer, Country> {

	@Component
	public static class CountryCacheLoader extends CacheLoader<Integer, Country> {

		@Resource
		private CountryRepository countryRepository;

		@Override
		@Transactional(propagation = Propagation.REQUIRED)
		public Country load(Integer key) throws Exception {
			Country country = new Country(countryRepository.getOne(key));
			return country;
		}
	}

	private final LoadingCache<Integer, Country> innerCache;

	@Autowired
	public CountryCache(CountryCacheLoader cacheLoader) {
		innerCache = CacheBuilder.newBuilder().build(cacheLoader);
	}

	@Override
	public Country apply(Integer key) {
		return innerCache.apply(key);
	}

	@Override
	public ConcurrentMap<Integer, Country> asMap() {
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
	public Country get(Integer key) throws ExecutionException {
		return innerCache.get(key);
	}

	@Override
	public Country get(Integer key, Callable<? extends Country> valueLoader) throws ExecutionException {
		return innerCache.get(key, valueLoader);
	}

	@Override
	public ImmutableMap<Integer, Country> getAll(Iterable<? extends Integer> keys) throws ExecutionException {
		return innerCache.getAll(keys);
	}

	@Override
	public ImmutableMap<Integer, Country> getAllPresent(Iterable<?> keys) {
		return innerCache.getAllPresent(keys);
	}

	@Override
	public Country getIfPresent(Object key) {
		return innerCache.getIfPresent(key);
	}

	@Override
	public Country getUnchecked(Integer key) {
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
	public void put(Integer key, Country value) {
		innerCache.put(key, value);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Country> m) {
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
