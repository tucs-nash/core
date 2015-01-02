package com.tucs.core.commons.exception;

/**
 * Classe utilizada para tratar exceções do tipo FormatException
 * @author eduardo.moras
 *
 */
public class FormatException extends BaseException {

	private static final long serialVersionUID = 5348330990004302057L;

	public FormatException(String mensagem) {
		super(mensagem);
	}

	public FormatException() {
	}

	public FormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormatException(Throwable cause) {
		super(cause);
	}

}
