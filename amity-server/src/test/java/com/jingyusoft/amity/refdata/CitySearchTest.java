package com.jingyusoft.amity.refdata;

import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.testgroups.DatabaseRequired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/com/jingyusoft/amity/refdata/application-context-unit-test-refdata.xml")
public class CitySearchTest {

	@Resource
	private CitySearcher citySearcher;

	@Test
	@Category(DatabaseRequired.class)
	public void testSearchCity() {
		Assert.assertNotNull(citySearcher);

		try {
			List<CitySearchResult> result = citySearcher.searchCities("bei", 10);
			Assert.assertTrue(result.size() > 0);
			System.out.println(result.size());
		} catch (ParseException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
