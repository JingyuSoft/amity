package com.jingyusoft.amity.programs;

public class TestConsole {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		SpringMain.main(args);

		final String consoleClass = System.getProperty("console.class");
		Class<?> clazz = Class.forName(consoleClass);

		TestConsoleBase console = TestConsoleBase.class.cast(SpringMain.getApplicationContext()
				.getAutowireCapableBeanFactory().createBean(clazz));

		try {
			System.out.println("Starting console [" + console.getClass().getSimpleName() + "]");
			console.startConsole();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
