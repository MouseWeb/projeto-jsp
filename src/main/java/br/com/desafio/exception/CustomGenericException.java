package br.com.desafio.exception;

import br.com.desafio.util.UtilService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errMsg;
	private final HttpStatus statusCode;
	private final Exception ex;
	private final transient UtilService util;

	public CustomGenericException(HttpStatus statusCode, Exception ex, UtilService util) {
		this.statusCode = statusCode;
		this.ex = ex;
		this.util = util;
	}

	public CustomGenericException(String errMsg, HttpStatus statusCode, UtilService util) {
		this(statusCode, null, util);
		this.errMsg = errMsg;
	}

	public CustomGenericException(HttpStatus statusCode, Exception ex, String mensagemErro, UtilService util) {
		this.statusCode = statusCode;
		this.ex = ex;
		this.errMsg = mensagemErro;
		this.util = util;
	}

	public CustomGenericException(String errMsg, UtilService util) {
		this(errMsg, HttpStatus.INTERNAL_SERVER_ERROR, util);
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public String getErrMsg() {
		if (ex instanceof JpaSystemException) {
			errMsg = ExceptionUtils.getRootCauseMessage(ex);
		}

		if (errMsg == null) {
			errMsg = util.getMessage("exception.internal.error");
		}

		return errMsg;
	}

	public String getEx() {
		if (ex != null) {
			return ex.getClass().getSimpleName();
		} else {
			return "CustomGenericException";
		}
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String getMessage() {
		return this.errMsg;
	}

}