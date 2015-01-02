package com.tucs.core.commons.log;

public interface ILogger {
  
	public void trace(String message);
    public boolean isTraceEnabled();
    public void trace(String message, Throwable ex);
	
	public void debug(String message);
    public boolean isDebugEnabled();
    public void debug(String message, Throwable ex);
   
    public void info(String message);
    public boolean isInfoEnabled();
    public void info(String message, Throwable ex);
    
    public void warn(String message);
    public boolean isWarnEnabled();
    public void warn(String message, Throwable ex);
    
    public void error(String message);
    public boolean isErrorEnabled();
    public void error(String message, Throwable ex);

}

