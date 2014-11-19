package com.jingyusoft.amity.common;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Repository;

@Repository
public class AmityPropertiesRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmityPropertiesRepository.class);

	private Properties mergedProperties;

	public String getProperty(String key) {
		return mergedProperties.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return mergedProperties.getProperty(key, defaultValue);
	}

	@PostConstruct
	public void initialize() {

		try {
			ClassPathResource resource = new ClassPathResource("config-default.properties");
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			LOGGER.info("Properties loaded from [{}]", resource.getFilename());

			final String configMode = System.getProperty("config.mode");
			if (!StringUtils.isBlank(configMode)) {
				ClassPathResource configModeResource = new ClassPathResource("config-" + configMode + ".properties");
				Properties configModeProperties = PropertiesLoaderUtils.loadProperties(configModeResource);
				LOGGER.info("Properties loaded from [{}]", configModeResource.getFilename());

				for (Entry<Object, Object> entry : configModeProperties.entrySet()) {
					properties.put(entry.getKey(), entry.getValue());
				}
			}

			mergedProperties = properties;
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			WrappedException.insteadOf(e);
		}
	}
}
