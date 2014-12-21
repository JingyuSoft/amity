package com.jingyusoft.amity.testdata;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class TestDataPreparer {

	@Resource
	private TestDataDao refDataTestDao;

	@PostConstruct
	public void initialize() {

		refDataTestDao.insertCountries();
		refDataTestDao.insertCities();
	}
}
