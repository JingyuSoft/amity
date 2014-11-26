package com.jingyusoft.amity.common;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public final class JsonUtils {

	private static class JodaDateTimeConverter implements JsonSerializer<DateTime>, JsonDeserializer<DateTime> {

		private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");

		@Override
		public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			return DateTime.parse(json.getAsString(), DATE_TIME_FORMAT);
		}

		@Override
		public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(DATE_TIME_FORMAT.print(src));
		}
	}

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

	public static final Type DATE_TIME_TYPE = new TypeToken<DateTime>() {
	}.getType();

	static {
		final GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(DATE_TIME_TYPE, new JodaDateTimeConverter());
		builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
		gson = builder.create();
	}
}
