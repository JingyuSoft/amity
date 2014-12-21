package com.jingyusoft.amity.refdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jingyusoft.amity.common.StringMessage;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.data.dao.CityDao;

@Component
public class CitySearcher {

	private static final Logger LOGGER = LoggerFactory.getLogger(CitySearcher.class);

	@Value("${amity.refdata.city.index.dir}")
	private String indexDirName;

	private final Analyzer analyzer = new StandardAnalyzer();

	private Directory index;

	private final IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, analyzer);

	@Resource
	private CityCache cityCache;

	@Resource
	private CityDao cityDao;

	public void deleteIndex() {
		File dir = new File(indexDirName);
		if (dir.exists()) {
			try {
				FileUtils.deleteDirectory(dir);
			} catch (IOException e) {
				throw WrappedException.insteadOf(e);
			}
		}
	}

	@PostConstruct
	private void initialize() {

		initializeIndex();
	}

	private void initializeFromDatabase() {

		LOGGER.info("Initializing index from database...");

		List<SearchableCity> searchableCities = ImmutableList.copyOf(cityDao.getSearchableCities());

		LOGGER.info("Loaded {} cities from database", searchableCities.size());

		try (IndexWriter indexWriter = new IndexWriter(index, indexWriterConfig)) {
			for (SearchableCity searchableCity : searchableCities) {
				Document document = new Document();
				document.add(new TextField("city", searchableCity.getCityName(), Field.Store.YES));
				document.add(new TextField("country", searchableCity.getCountryName(), Field.Store.YES));
				document.add(new IntField("id", searchableCity.getId(), Field.Store.YES));
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
			}

			if (index == null) {

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
	}

	public List<SearchableCity> searchCities(final String criteria, final int maxCount) throws ParseException {
		final String pattern = criteria;

		QueryParser parser = new QueryParser("amity", analyzer);
		Query query = parser.parse("city:" + pattern + " country:" + pattern);
		// Query query = new PrefixQuery(new Term("city", pattern));

		TopScoreDocCollector collector = TopScoreDocCollector.create(maxCount, true);

		try (IndexReader reader = DirectoryReader.open(index)) {
			IndexSearcher searcher = new IndexSearcher(reader);

			searcher.search(query, collector);
			TopDocs topDocs = collector.topDocs();

			List<SearchableCity> searchResult = Lists.newArrayList();

			final StringBuilder sb = new StringBuilder();

			int i = 0;
			for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
				int docId = scoreDoc.doc;
				Document doc = searcher.doc(docId);

				SearchableCity searchableCity = new SearchableCity(Integer.parseInt(doc.get("id")), doc.get("city"),
						doc.get("country"));
				searchResult.add(searchableCity);

				sb.append(StringUtils.leftPad(++i + ". ", String.valueOf(topDocs.scoreDocs.length).length() + 2));
				sb.append(StringUtils.rightPad(
						StringMessage.with("Doc = [{}], Score = [{}]  ", scoreDoc.doc, String.valueOf(scoreDoc.score)),
						20));
				sb.append(searchableCity + SystemUtils.LINE_SEPARATOR);
			}

			LOGGER.debug("Found {} cities with pattern [{}]" + SystemUtils.LINE_SEPARATOR + sb.toString(),
					topDocs.scoreDocs.length, criteria);

			return ImmutableList.copyOf(searchResult);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			throw WrappedException.insteadOf(e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			throw WrappedException.insteadOf(e);
		}
	}
}
