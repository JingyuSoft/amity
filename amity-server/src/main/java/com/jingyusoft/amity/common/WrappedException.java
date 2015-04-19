package com.jingyusoft.amity.common;

public class WrappedException extends RuntimeException {

	public static RuntimeException insteadOf(final Throwable t) {
		return insteadOf(t, null);
	}

	public static RuntimeException insteadOf(final Throwable t, final String message) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		}

		if (message == null) {
			return new WrappedException(t);
		} else {
			return new WrappedException(message, t);
		}
	}

	public static WrappedException wrap(final Throwable t) {
		return new WrappedException(t);
	}

	private static final long serialVersionUID = 1L;

	public WrappedException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrappedException(Throwable cause) {
		super(cause);
	}

	public final Throwable unwrap() {
		Throwable cause = getCause();
		while (cause instanceof WrappedException) {
			cause = cause.getCause();
		}
		return Exception.class.cast(cause);
	}
}
