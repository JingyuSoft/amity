package com.jingyusoft.amity.testdata;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyusoft.amity.common.ClasspathTextFile;

@Service
public class TestDataDaoImpl implements TestDataDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertCities() {
		entityManager.createNativeQuery(ClasspathTextFile.getContent("insert_cities.sql")).executeUpdate();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertCountries() {
		entityManager.createNativeQuery(ClasspathTextFile.getContent("insert_countries.sql")).executeUpdate();
	}
}
