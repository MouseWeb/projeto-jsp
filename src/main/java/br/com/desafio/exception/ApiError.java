package br.com.desafio.exception;

import org.springframework.http.HttpStatus;

public class ApiError {
	private final String statusMessage;
	private final Integer statusCode;
	private final String message;
	private final String exception;

	public ApiError(HttpStatus status, String message, String exception) {
		this.statusMessage = status.getReasonPhrase();
		this.statusCode = status.value();
		this.message = message;
		this.exception = exception;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public String getException() {
		return exception;
	}
}