package com.jingyusoft.amity.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.common.collect.Maps;

public class ClasspathTextFile {

	public static String getContent(final String name) {
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
		Class<?> callingClass;
		try {
			callingClass = Class.forName(stackTraceElement.getClassName());
		} catch (ClassNotFoundException e) {
			throw WrappedException.insteadOf(e);
		}

		final String key = callingClass.getName() + "_" + name;
		if (!map.containsKey(key)) {
			try {
				load(callingClass, name);
			} catch (IOException e) {
				throw WrappedException.insteadOf(e);
			}
		}

		return map.get(key);
	}

	private static void load(Class<?> clazz, final String name) throws IOException {
		InputStream resourceAsStream = clazz.getResourceAsStream(name);
		final String content = IOUtils.toString(resourceAsStream);
		map.put(clazz.getName() + "_" + name, content);
	}

	private static final Map<String, String> map = Maps.newHashMap();
}
