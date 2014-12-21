package com.jingyusoft.amity.refdata;

import com.jingyusoft.amity.AmityException;

public class ReferenceDataLoadException extends AmityException {

	private static final long serialVersionUID = 1L;

	private final Class<?> referenceDataType;

	private final String key;

	public ReferenceDataLoadException(Class<?> referenceDataType, final Object key, Exception e) {
		super("Failed to load " + referenceDataType.getSimpleName() + " with key(s) [" + String.valueOf(key) + "]", e);

		this.referenceDataType = referenceDataType;
		this.key = String.valueOf(key);
	}

	public String getKey() {
		return key;
	}

	public Class<?> getReferenceDataType() {
		return referenceDataType;
	}
}
