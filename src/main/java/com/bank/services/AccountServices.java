package com.bank.services;

import java.sql.SQLException;

import com.bank.dao.AccountDao;
import com.bank.exceptions.InvalidTransactionException;
import com.bank.exceptions.UserNotFoundException;
import com.bank.logging.Logging;
import com.bank.models.Account;


public class AccountServices {

private static AccountDao aDao;
	
	public AccountServices(AccountDao a) {
		AccountServices.aDao = a;
	}
	
	public Account createAccount(int customerID, int balance, String acctType) throws UserNotFoundException {
		Account a = new Account(customerID, balance, acctType);
		acctType = acctType.toUpperCase();
		try {
			
			aDao.createAccount(a);
			Logging.logger.info("Your account has been created.");
			
		} catch (SQLException e) {
			
			Logging.logger.warn("Account created that already exists in the database");
			throw new UserNotFoundException();
		}
		 
		return a;
	}
		
	
}


