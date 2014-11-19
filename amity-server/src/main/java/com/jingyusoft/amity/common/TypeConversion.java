package com.jingyusoft.amity.common;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

public class TypeConversion {

	public static <T> T convertType(Object source, Class<T> targetType) {
		return conversionService.convert(source, targetType);
	}

	private static GenericConversionService conversionService = new GenericConversionService();

	static {
		DefaultConversionService.addDefaultConverters(conversionService);
	}
}
