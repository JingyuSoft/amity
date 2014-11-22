package com.jingyusoft.amity.programs;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {

		if (args.length == 0 || StringUtils.isBlank(args[0])) {
			System.err.println("Application context file not specified");
			return;
		}

		applicationContext = new ClassPathXmlApplicationContext(args[0]);
		LOGGER.info("Spring main started successfullly. " + applicationContext.getBeanDefinitionCount()
				+ " beans created.");
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringMain.class);

	private static ApplicationContext applicationContext = null;
}
