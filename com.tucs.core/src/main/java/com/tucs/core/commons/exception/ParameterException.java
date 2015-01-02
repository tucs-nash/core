package com.tucs.core.commons.exception;

/**
 * Classe utilizada para tratar exceções do tipo BusinessException
 * @author thiago.almeida
 *
 */
public class ParameterException extends BaseException {

	private static final long serialVersionUID = 5348330990004302057L;

	public ParameterException(String mensagem) {
		super(mensagem);
	}

	public ParameterException() {
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

}
