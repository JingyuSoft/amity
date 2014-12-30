package com.jingyusoft.amity.refdata;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoubleField;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopFieldDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.AmityException;
import com.jingyusoft.amity.common.StringMessage;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.data.dao.CityDao;
import com.jingyusoft.amity.domain.geographics.GeoLocation;

@Component
@ManagedResource(objectName = "com.jingyusoft.amity.refdata:type=CitySearcher")
public class CitySearcher implements CitySearcherMXBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(CitySearcher.class);

	@Value("${amity.refdata.city.index.dir}")
	private String indexDirName;

	private final Analyzer analyzer = new KeywordAnalyzer();

	private Directory index;

	private final IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, analyzer);

	private IndexReader indexReader;

	private IndexSearcher indexSearcher;

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	@Resource
	private CityCache cityCache;

	@Resource
	private CityDao cityDao;

	private void deleteIndex() {
		File dir = new File(indexDirName);
		if (dir.isDirectory() && dir.exists()) {
			try {
				FileUtils.deleteDirectory(dir);
			} catch (IOException e) {
				throw WrappedException.insteadOf(e);
			}
		}
	}

	/**
	 *
	 * Get cities near the specified latitude / longitude within the delta
	 *
	 * @param latitude
	 *            The latitude
	 * @param longitude
	 *            The longitude
	 * @param delta
	 *            The delta of latitude and longitude to specify the rectangle to search cities within it
	 * @param maxCount
	 *            Maximum number of cities returned in the rectangle
	 *
	 * @return List of cities around the specified location
	 */
	public List<NearestCityResult> getNearestCities(final double latitude, final double longitude, double delta,
			int maxCount) {

		Validate.exclusiveBetween(-90, 90, latitude);
		Validate.inclusiveBetween(-180, 180, longitude);

		BooleanQuery query = new BooleanQuery();

		NumericRangeQuery<Double> latitudeQuery = NumericRangeQuery.newDoubleRange("latitude", latitude - delta,
				latitude + delta, true, true);
		query.add(latitudeQuery, BooleanClause.Occur.MUST);

		Query longitudeQuery = null;
		if (longitude - delta < -180) {
			BooleanQuery booleanQuery = new BooleanQuery();
			booleanQuery.add(NumericRangeQuery.newDoubleRange("longitude", -180.0, longitude + delta, false, true),
					Occur.SHOULD);
			booleanQuery.add(
					NumericRangeQuery.newDoubleRange("longitude", longitude - delta + 360.0, 180.0, true, true),
					Occur.SHOULD);
			longitudeQuery = booleanQuery;
		} else if (longitude + delta > 180) {
			BooleanQuery booleanQuery = new BooleanQuery();
			booleanQuery.add(NumericRangeQuery.newDoubleRange("longitude", longitude - delta, 180.0, true, true),
					Occur.SHOULD);
			booleanQuery.add(
					NumericRangeQuery.newDoubleRange("longitude", -180.0, longitude + delta - 360.0, false, true),
					Occur.SHOULD);
			longitudeQuery = booleanQuery;
		} else {
			longitudeQuery = NumericRangeQuery.newDoubleRange("longitude", longitude - delta, longitude + delta, true,
					true);
		}

		query.add(latitudeQuery, BooleanClause.Occur.MUST);
		query.add(longitudeQuery, BooleanClause.Occur.MUST);

		try {
			readWriteLock.readLock().lock();

			TopDocs topDocs = indexSearcher.search(query, maxCount);
			if (topDocs.scoreDocs.length == maxCount) {
				return getNearestCities(latitude, longitude, delta * 0.7, maxCount);
			} else if (topDocs.scoreDocs.length == 0) {
				return getNearestCities(latitude, longitude, delta * 2.0, maxCount);
			} else {
				return Arrays
						.asList(topDocs.scoreDocs)
						.stream()
						.map(item -> {
							try {
								return indexSearcher.doc(item.doc);
							} catch (Exception e) {
								throw WrappedException.insteadOf(e);
							}
						})
						.map(item -> new NearestCityResult(Integer.parseInt(item.get("id")), item.get("displayName"),
								Double.parseDouble(item.get("latitude")), Double.parseDouble(item.get("longitude"))))
								.collect(Collectors.toList());
			}
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		} catch (NumberFormatException e) {
			throw WrappedException.insteadOf(e);
		} finally {
			readWriteLock.readLock().unlock();
		}
	}

	public NearestCityResult getNearestCity(final double latitude, final double longitude) {
		List<NearestCityResult> nearestCities = getNearestCities(latitude, longitude, 0.1, 100);
		Optional<NearestCityResult> nearestCity = nearestCities.stream().min((a, b) -> {
			GeoLocation current = GeoLocation.from(latitude, longitude);
			return current.distanceTo(a.getGeoLocation()) - current.distanceTo(b.getGeoLocation()) < 0 ? -1 : 1;
		});
		return nearestCity.orElse(null);
	}

	@PostConstruct
	private void initialize() {

		initializeIndex();

		try {
			indexReader = DirectoryReader.open(index);
			indexSearcher = new IndexSearcher(indexReader);
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		}
	}

	private void initializeFromDatabase() {

		LOGGER.info("Initializing index from database...");

		List<SearchableCity> searchableCities = ImmutableList.copyOf(cityDao.getSearchableCities());

		LOGGER.info("Loaded {} cities from database", searchableCities.size());

		try (IndexWriter indexWriter = new IndexWriter(index, indexWriterConfig)) {
			for (SearchableCity searchableCity : searchableCities) {
				Document document = new Document();
				document.add(new StoredField("id", searchableCity.getId()));
				document.add(new TextField("city", searchableCity.getCityName().toLowerCase(), Field.Store.YES));
				document.add(new TextField("country", searchableCity.getCountryName().toLowerCase(), Field.Store.YES));
				document.add(new StoredField("displayName", searchableCity.getDisplayName() + ", "
						+ searchableCity.getCountryName()));
				document.add(new DoubleField("latitude", searchableCity.getLatitude(), Field.Store.YES));
				document.add(new DoubleField("longitude", searchableCity.getLongitude(), Field.Store.YES));
				try {
					indexWriter.addDocument(document);
				} catch (IOException e) {
					throw WrappedException.insteadOf(e);
				}
			}
		} catch (IOException e) {
			LOGGER.error("Failed to build city index", e);
			throw WrappedException.insteadOf(e);
		}

		LOGGER.info("Index on {} cities built into directory [{}]", searchableCities.size(), indexDirName);
	}

	private void initializeIndex() {

		try {
			readWriteLock.writeLock().lock();

			if (StringUtils.isBlank(indexDirName)) {
				LOGGER.info("Creating in memory index...");
				index = new RAMDirectory();

				initializeFromDatabase();
			} else {
				File indexDir = new File(indexDirName);

				if (indexDir.exists()) {
					try {
						index = new NIOFSDirectory(indexDir);
					} catch (IOException e) {
						LOGGER.error("Failed to load city index from directory [{}]", indexDir);

						try {
							FileUtils.deleteDirectory(indexDir);
						} catch (IOException ioe) {
							throw WrappedException.insteadOf(ioe);
						}
						LOGGER.info("Index directory [{}] deleted", indexDirName);
					}
				} else {
					// Create the index directory
					indexDir.mkdirs();

					try {
						index = new NIOFSDirectory(indexDir);
					} catch (IOException e) {
						throw WrappedException.insteadOf(e);
					}
				}

				if (FileUtils.listFiles(indexDir, null, false).size() == 0) {
					initializeFromDatabase();
				} else {
					LOGGER.info("Existing index loaded from directory [{}]", indexDirName);
				}
			}
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

	@Override
	@ManagedOperation(description = "Rebuild index")
	public void rebuildIndex() {
		try {
			indexReader.close();
			readWriteLock.writeLock().lock();

			deleteIndex();
			initializeIndex();

			try {
				indexReader = DirectoryReader.open(index);
				indexSearcher = new IndexSearcher(indexReader);
			} catch (IOException e) {
				throw WrappedException.insteadOf(e);
			}
		} catch (IOException e) {
			throw new AmityException("Failed to close index reader when rebuilding city index", e);
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

	public List<CitySearchResult> searchCitiesByName(final String criteria, final int maxCount) throws ParseException {
		final String pattern = criteria.toLowerCase();

		BooleanQuery query = new BooleanQuery();

		PrefixQuery cityQuery = new PrefixQuery(new Term("city", pattern));
		cityQuery.setBoost(1.5f);
		query.add(cityQuery, BooleanClause.Occur.SHOULD);

		PrefixQuery countryTermQuery = new PrefixQuery(new Term("country", pattern));
		query.add(countryTermQuery, BooleanClause.Occur.SHOULD);

		try {
			readWriteLock.readLock().lock();

			TopFieldDocs topDocs = indexSearcher.search(query, maxCount, new Sort(new SortField("city",
					SortField.Type.STRING)));

			List<CitySearchResult> citySearchResults = Lists.newArrayList();

			final StringBuilder sb = new StringBuilder();

			int i = 0;
			for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
				int docId = scoreDoc.doc;
				Document doc = indexSearcher.doc(docId);

				CitySearchResult citySearchResult = new CitySearchResult(Integer.parseInt(doc.get("id")),
						doc.get("displayName"));
				citySearchResults.add(citySearchResult);

				sb.append(StringUtils.leftPad(++i + ". ", String.valueOf(topDocs.scoreDocs.length).length() + 2));
				sb.append(StringUtils.rightPad(
						StringMessage.with("Doc = [{}], Score = [{}]  ", scoreDoc.doc, String.valueOf(scoreDoc.score)),
						20));
				sb.append(citySearchResult + SystemUtils.LINE_SEPARATOR);
			}

			LOGGER.debug("Found {} cities with pattern [{}]" + SystemUtils.LINE_SEPARATOR + sb.toString(),
					topDocs.scoreDocs.length, criteria);

			return ImmutableList.copyOf(citySearchResults);
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
}
