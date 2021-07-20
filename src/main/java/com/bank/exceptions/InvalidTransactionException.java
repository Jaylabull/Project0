package com.bank.exceptions;

public class InvalidTransactionException extends RuntimeException {


	
	private static final long serialVersionUID = 1L;

	public InvalidTransactionException() {
		super("Sorry, this transcation could not be processed.");
	}
	
}
