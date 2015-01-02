package com.tucs.core.commons.exception;

/**
 * Classe utilizada para tratar exceções do tipo BeanException
 * @author eduardo.moras
 *
 */
public class BeanException extends BaseException {

	private static final long serialVersionUID = 2818668579631100848L;

	public BeanException(String mensagem) {
		super(mensagem);
	}

	public BeanException() {
	}

	public BeanException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanException(Throwable cause) {
		super(cause);
	}

}
