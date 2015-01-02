package com.tucs.core.commons.exception;

/**
 * Classe utilizada para tratar exceções do tipo DbException
 * @author eduardo.moras
 *
 */
public class DbException extends BaseException {

	private static final long serialVersionUID = 3348007291119505595L;

	public DbException(String mensagem) {
		super(mensagem);
	}

	public DbException() {
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

	public DbException(Throwable cause) {
		super(cause);
	}

}
