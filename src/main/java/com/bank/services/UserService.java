package com.bank.services;

import java.sql.SQLException;

import com.bank.dao.UserDao;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.exceptions.UserNameAlreadyExistsException;
import com.bank.exceptions.UserNotFoundException;
import com.bank.logging.Logging;
import com.bank.models.User;

public class UserService {
	private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	public User signUp(String first, String last, String email, String password) throws UserNameAlreadyExistsException{
		User u = new User(first, last, email, password);
		try {
			uDao.createUser(u);
			Logging.logger.info("New user has registered.");
		} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database.");
			throw new UserNameAlreadyExistsException();
		}
		
		return u;
		
	}
	
public User signIn(String username, String password) throws UserNotFoundException, InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(username);
		
		if(u.getId() == 0) {
			Logging.logger.warn("User tried loggging in that does not exist.");
			throw new UserNotFoundException();
		}
		else if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials.");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in.");
			return u;
		}
}
	
	
}
