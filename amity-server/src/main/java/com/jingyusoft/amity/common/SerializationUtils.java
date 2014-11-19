package com.jingyusoft.amity.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class SerializationUtils {

	@SuppressWarnings("unchecked")
	public static final <T> T clone(T obj) {
		return (T) deserialize(serialize(obj), obj.getClass());
	}

	public static final <T> T deserialize(final byte[] buffer, Class<T> clazz) {

		try (Input input = new Input(new ByteArrayInputStream(buffer))) {
			return clazz.cast(kryo.get().readObject(input, clazz));
		}
	}

	public static final byte[] serialize(Object obj) {

		try (Output output = new Output(new ByteArrayOutputStream())) {
			kryo.get().writeObject(output, obj);
			return output.getBuffer();
		}
	}

	private static final ThreadLocal<Kryo> kryo = new ThreadLocal<Kryo>() {
		@Override
		protected Kryo initialValue() {
			return new Kryo();
		}
	};
}
