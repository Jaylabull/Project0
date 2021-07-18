package com.bank.exceptions;

public class TransactionNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public TransactionNotFoundException() {
		super("Sorry, this transcation cannot be found in database.");
	}
}
