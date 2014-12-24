package com.jingyusoft.amity.programs;

import org.apache.commons.lang3.StringUtils;

public class TestConsole {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		SpringMain.main(args);

		final String consoleClass = StringUtils.trim(args[0]);

		Class<?> clazz = Class.forName(consoleClass);

		TestConsoleBase console = TestConsoleBase.class.cast(SpringMain.getApplicationContext()
				.getAutowireCapableBeanFactory().createBean(clazz));

		try {
			System.out.println("Starting console [" + console.getClass().getSimpleName() + "]");
			console.startConsole();

			SpringMain.getApplicationContext().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
