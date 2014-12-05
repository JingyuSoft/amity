package com.jingyusoft.amity.programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.AmityPropertiesRepository;
import com.jingyusoft.amity.common.WrappedException;

public class SpringMain {

	public static void main(String[] args) {

		final String applicationContextFile = System.getProperty("application.context");
		if (StringUtils.isEmpty(applicationContextFile)) {
			System.err.println("Application context file not specified");
			return;
		}

		if (StringUtils.isEmpty(System.getProperty("jdbc.password"))) {
			LOGGER.info("Loading JDBC password from VM arguments [{}]", "jdbc.password");

			if (StringUtils.isEmpty(System.getProperty("jdbc.password.file"))) {
				LOGGER.info("Loading JDBC password from properties file");
				AmityPropertiesRepository propertiesRepository = new AmityPropertiesRepository();
				propertiesRepository.initialize();

				System.setProperty("jdbc.password", propertiesRepository.getProperty("jdbc.password"));
			} else {
				final String passwordFileName = System.getProperty("jdbc.password.file");
				LOGGER.info("Loading JDBC password from file [{}]", passwordFileName);
				// Load JDBC password from external file
				try {
					@SuppressWarnings("unchecked")
					List<String> lines = IOUtils.readLines(new FileInputStream(passwordFileName));
					System.setProperty("jdbc.password", lines.stream().findFirst().orElse(null));
				} catch (IOException e) {
					throw WrappedException.insteadOf(e);
				}
			}
		}

		if (StringUtils.isEmpty(System.getProperty("jdbc.password"))) {
			System.err.println("Failed to load Amity database password");
		}

		try {
			applicationContext = new ClassPathXmlApplicationContext(applicationContextFile);
			LOGGER.info("Spring main started successfullly. " + applicationContext.getBeanDefinitionCount()
					+ " beans created.");
		} catch (Exception e) {
			LOGGER.error("Failed to load Spring application context", e);
		}
	}

	static {
		DateTimeZone.setDefault(DateTimeZone.UTC);
	}

	private static final Logger LOGGER = AmityLogger.getLogger();

	private static ApplicationContext applicationContext = null;
}
