package com.bank.exceptions;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User tried logging in with credentials that do not exists.");
	}
}
