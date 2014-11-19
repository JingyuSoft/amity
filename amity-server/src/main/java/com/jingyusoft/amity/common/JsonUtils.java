package com.jingyusoft.amity.common;

import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonUtils {

	public static <T> T fromJson(final String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	public static String objectToArray(String json, String objectName) {

		Pattern pattern = Pattern.compile("(?<=\"" + objectName + "\":)\\{[^\\}]+\\}");
		Matcher matcher = pattern.matcher(json);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "[" + matcher.group(0) + "]");
		}
		matcher.appendTail(sb);

		return sb.toString();
	}

	public static final String toJson(final Object obj) {
		return gson.toJson(obj);
	}

	private static Gson gson;

	static {
		final GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithModifiers(Modifier.TRANSIENT).excludeFieldsWithoutExposeAnnotation();
		gson = builder.create();
	}
}
