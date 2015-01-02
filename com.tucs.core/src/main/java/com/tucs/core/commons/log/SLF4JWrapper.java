package com.tucs.core.commons.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JWrapper implements ILogger {

	private final Logger log;
	
	public SLF4JWrapper(Class<?> klass) {
		super();
		this.log = LoggerFactory.getLogger(klass);
	}

	public void trace(String message) {
		log.trace(message);
	}

	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public void trace(String message, Throwable ex) {
		log.trace(message, ex);
	}

	public void debug(String message) {
		log.debug(message);
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public void debug(String message, Throwable ex) {
		log.debug(message, ex);
	}

	public void info(String message) {
		log.info(message);
	}

	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	public void info(String message, Throwable ex) {
		log.info(message, ex);
	}

	public void warn(String message) {
		log.warn(message);
	}

	public boolean isWarnEnabled() {
		return log.isWarnEnabled();
	}

	public void warn(String message, Throwable ex) {
		log.warn(message, ex);
	}

	public void error(String message) {
		log.error(message);
	}

	public boolean isErrorEnabled() {
		return log.isErrorEnabled();
	}

	public void error(String message, Throwable ex) {
		log.error(message, ex);
	}

}
