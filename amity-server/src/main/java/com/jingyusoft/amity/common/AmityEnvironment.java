package com.jingyusoft.amity.common;

import org.apache.commons.lang3.StringUtils;

import com.jingyusoft.amity.AmityException;

public class AmityEnvironment {

	public static enum WorkingEnvironment {

		PROD("prod"),

		QA("qa"),

		DEV("dev"),

		UNIT_TEST("test");

		private final String configMode;

		private WorkingEnvironment(final String configMode) {
			this.configMode = configMode;
		}

		public String getConfigMode() {
			return configMode;
		}
	}

	public static WorkingEnvironment getWorkingEnvironment() {
		return workingEnvironment;
	}

	private static WorkingEnvironment workingEnvironment;

	static {
		final String configMode = System.getProperty("config.mode");
		if (StringUtils.isBlank(configMode)) {
			throw new AmityException("Failed to detect working environment. [config.mode] property not set.");
		}

		for (WorkingEnvironment environment : WorkingEnvironment.values()) {
			if (configMode.startsWith(environment.getConfigMode())) {
				workingEnvironment = environment;
			}
		}

		if (workingEnvironment == null) {
			throw new AmityException("Failed to detect working environment. ");
		}
	}
}
