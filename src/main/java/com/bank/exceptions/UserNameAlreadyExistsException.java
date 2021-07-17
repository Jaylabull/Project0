package com.bank.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistsException() {
		super("The user name already exists in the database");
	}
}
