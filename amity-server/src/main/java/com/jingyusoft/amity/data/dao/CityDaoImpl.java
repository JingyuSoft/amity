package com.jingyusoft.amity.data.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.common.ClasspathTextFile;
import com.jingyusoft.amity.refdata.SearchableCity;

@Repository
public class CityDaoImpl implements CityDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<SearchableCity> getSearchableCities() {

		Query query = entityManager.createNativeQuery(ClasspathTextFile.getContent("City-QuerySearchable.sql"));

		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();

		List<SearchableCity> result = list.stream()
				.map(item -> new SearchableCity((Integer) item[0], (String) item[1], (String) item[2]))
				.collect(Collectors.toList());

		return result;
	}
}
