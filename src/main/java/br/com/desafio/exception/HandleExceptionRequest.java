package br.com.desafio.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class HandleExceptionRequest extends ResponseEntityExceptionHandler {

	private static final Logger localLogger = Logger.getLogger(HandleExceptionRequest.class);

	@ExceptionHandler({ CustomGenericException.class })
	public ResponseEntity<Object> handleCustomException(CustomGenericException ex, WebRequest request) {
		localLogger.error(ex);


	    ApiError apiError = new ApiError(ex.getStatusCode(), ex.getErrMsg(), ex.getEx());
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.valueOf(apiError.getStatusCode()));
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleException(HttpServletRequest req, HttpServletResponse response, Exception e) {
		localLogger.error(e);

	    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro", e.getClass().getName());
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.valueOf(apiError.getStatusCode()));
	}


}
