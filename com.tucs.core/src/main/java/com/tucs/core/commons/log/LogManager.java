package com.tucs.core.commons.log;

public class LogManager {

	public ILogger getLogger(Class<?> klass) {
		return new SLF4JWrapper(klass);
	}

	public static ILogger getStaticLogger(Class<?> klass) {
		return new SLF4JWrapper(klass);
	}
	
}
