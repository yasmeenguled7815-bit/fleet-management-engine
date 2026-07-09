package com.enginefleet.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,String>>
	handleNotFound(ResourceNotFoundException ex){
		
		Map<String,String> map=new HashMap<>();
		
		map.put("error",ex.getMessage());
		
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> handleException(Exception ex){
		Map<String,String> map=new HashMap<>();
		
		map.put("error",ex.getMessage());
		
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
}
