package com.enginefleet.Exception;

public class ApiRateLimitException extends RuntimeException {
	
	public ApiRateLimitException(String message) {
		super(message);
	}

}
