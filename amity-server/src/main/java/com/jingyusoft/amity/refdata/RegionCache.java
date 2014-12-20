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
import com.jingyusoft.amity.data.repositories.RegionRepository;
import com.jingyusoft.amity.domain.geographics.Country;
import com.jingyusoft.amity.domain.geographics.Region;

@Component
public class RegionCache implements LoadingCache<Integer, Region> {

	@Component
	public static class RegionCacheLoader extends CacheLoader<Integer, Region> {

		@Resource
		private RegionRepository regionRepository;

		@Resource
		private CountryCache countryCache;

		@Override
		@Transactional(propagation = Propagation.REQUIRED)
		public Region load(Integer key) throws Exception {
			Region region = new Region(regionRepository.getOne(key));
			if (region.getCountryId() != null) {
				Country country = countryCache.get(region.getCountryId());
				region.setCountry(country);
				country.addRegion(region);
			}
			return region;
		}
	}

	@Resource
	private RegionRepository regionRepository;

	@Resource
	private CountryCache countryCache;

	private final LoadingCache<Integer, Region> innerCache;

	@Autowired
	public RegionCache(RegionCacheLoader cacheLoader) {
		innerCache = CacheBuilder.newBuilder().build(cacheLoader);
	}

	@Override
	public Region apply(Integer key) {
		return innerCache.apply(key);
	}

	@Override
	public ConcurrentMap<Integer, Region> asMap() {
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
	public Region get(Integer key) throws ExecutionException {
		return innerCache.get(key);
	}

	@Override
	public Region get(Integer key, Callable<? extends Region> valueLoader) throws ExecutionException {
		return innerCache.get(key, valueLoader);
	}

	@Override
	public ImmutableMap<Integer, Region> getAll(Iterable<? extends Integer> keys) throws ExecutionException {
		return innerCache.getAll(keys);
	}

	@Override
	public ImmutableMap<Integer, Region> getAllPresent(Iterable<?> keys) {
		return innerCache.getAllPresent(keys);
	}

	@Override
	public Region getIfPresent(Object key) {
		return innerCache.getIfPresent(key);
	}

	@Override
	public Region getUnchecked(Integer key) {
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
	public void put(Integer key, Region value) {
		innerCache.put(key, value);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Region> m) {
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
