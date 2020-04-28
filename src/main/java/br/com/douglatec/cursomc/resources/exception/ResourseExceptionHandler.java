package br.com.douglatec.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.douglatec.cursomc.services.exceptions.ObjectNoFoundException;

@ControllerAdvice
public class ResourseExceptionHandler {
	
	@ExceptionHandler(ObjectNoFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNoFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}