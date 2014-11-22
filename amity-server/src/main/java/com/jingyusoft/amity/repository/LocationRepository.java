package com.jingyusoft.amity.repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.dao.CityDao;
import com.jingyusoft.amity.dao.CountryDao;
import com.jingyusoft.amity.dao.RegionDao;

@Repository
public class LocationRepository {

	@Resource
	private CountryDao countryDao;

	@Resource
	private RegionDao regionDao;

	@Resource
	private CityDao cityyDao;

	@PostConstruct
	private void initialize() {

	}
}
