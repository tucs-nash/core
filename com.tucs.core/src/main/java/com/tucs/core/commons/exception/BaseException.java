package com.tucs.core.commons.exception;


/**
 * Classe utilizada para tratar exceções.
 * @author eduardo.moras
 *
 */
public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 5760433605349600329L;

	public BaseException(String mensagem){
		super(mensagem);
	}
	public BaseException (){
		super();
	}
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}
}

