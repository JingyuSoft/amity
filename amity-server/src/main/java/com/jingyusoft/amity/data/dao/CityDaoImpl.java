package com.jingyusoft.amity.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyusoft.amity.common.ClasspathTextFile;
import com.jingyusoft.amity.data.DataConstants;
import com.jingyusoft.amity.refdata.SearchableCity;

@Repository
public class CityDaoImpl implements CityDao {

	@PersistenceContext
	private EntityManager entityManager;

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public CityDaoImpl(@Qualifier(DataConstants.DATA_SOURCE_BEAN_ID) DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SearchableCity> getSearchableCities() {

		List<SearchableCity> result = jdbcTemplate.query(ClasspathTextFile.getContent("City-QuerySearchable.sql"),
				BeanPropertyRowMapper.newInstance(SearchableCity.class));

		return result;
	}
}
