package com.jingyusoft.amity.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsole {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Please specify application context");
		}

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(args[0]);
		applicationContext.close();
	}
}
