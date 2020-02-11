package com.hcl.ing.forextransfer.exception;

public class InvalidAccountNumber extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public InvalidAccountNumber(String message) {
		super(message);
	}	
}
