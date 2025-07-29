package com.sam.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.sam.exception.StudentException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private Environment environment;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception e) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setErrorMsg(environment.getProperty("general.EXCEPTION_MESSAGE"));
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorInfo> studentExceptionHandler(StudentException e) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setErrorMsg(e.getMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> validationExceptionHandler(MethodArgumentNotValidException e) {
		ErrorInfo errorInfo = new ErrorInfo();

		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setTimestamp(LocalDateTime.now());

		String errorMsg = e.getBindingResult().getAllErrors().stream()
				.map(x -> environment.getProperty(x.getDefaultMessage())).collect(Collectors.joining(","));

		errorInfo.setErrorMsg(errorMsg);

		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

}
