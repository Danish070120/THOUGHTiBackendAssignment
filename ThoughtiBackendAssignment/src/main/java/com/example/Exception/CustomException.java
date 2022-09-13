package com.example.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomException(int i, String message2) {
		this.errorCode = i;
		this.message = message2;
	}

	private Integer errorCode;
	private String message;

}
