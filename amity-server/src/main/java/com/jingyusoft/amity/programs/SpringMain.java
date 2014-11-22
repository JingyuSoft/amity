package com.jingyusoft.amity.programs;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.AmityPropertiesRepository;

public class SpringMain {

	public static void main(String[] args) {

		final String applicationContextFile = System.getProperty("application.context");
		if (StringUtils.isEmpty(applicationContextFile)) {
			System.err.println("Application context file not specified");
			return;
		}

		AmityPropertiesRepository propertiesRepository = new AmityPropertiesRepository();
		propertiesRepository.initialize();

		final String jdbcPassword = propertiesRepository.getProperty("jdbc.password");

		if (StringUtils.isEmpty(System.getProperty("amity_database_password")) && !StringUtils.isEmpty(jdbcPassword)) {
			System.setProperty("amity_database_password", jdbcPassword);
		}

		applicationContext = new ClassPathXmlApplicationContext(applicationContextFile);
		LOGGER.info("Spring main started successfullly. " + applicationContext.getBeanDefinitionCount()
				+ " beans created.");
	}

	private static final Logger LOGGER = AmityLogger.getLogger();

	private static ApplicationContext applicationContext = null;
}
