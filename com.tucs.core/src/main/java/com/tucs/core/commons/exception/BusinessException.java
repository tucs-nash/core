package com.tucs.core.commons.exception;

/**
 * Classe utilizada para tratar exceções do tipo BusinessException
 * @author thiago.almeida
 *
 */
public class BusinessException extends BaseException {

	private static final long serialVersionUID = 5348330990004302057L;

	public BusinessException(String mensagem) {
		super(mensagem);
	}

	public BusinessException() {
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
