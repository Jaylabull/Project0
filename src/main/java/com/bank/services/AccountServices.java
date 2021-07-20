package com.bank.services;

import java.sql.SQLException;

import com.bank.dao.AccountDao;
import com.bank.exceptions.InvalidTransactionException;
import com.bank.exceptions.UserNotFoundException;
import com.bank.logging.Logging;
import com.bank.models.Account;
import com.bank.models.System;
import com.bank.models.Transactions;

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
	
	public static void makeDeposit(int uID, int deposit) throws InvalidTransactionException {
		TransactionServices tServ = new TransactionServices();
		
		Account a = new Account();
		
		a.setCurrentBal(a.getCurrentBal() + deposit);
		
//		try {
//		
//
////			aDao.updateAccount(a);
////			Transactions t = new Transactions(a.getAccountNum(), deposit);
////			tServ.logTransaction(t);
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new InvalidTransactionException();
//		}
	}
	
	
}


//
//public Account makeDeposit(int accountNum, double deposit) throws InvalidTransactionException{
//	Account tr = new Account();
//		
//	try {
//		 tDao.logTransaction(tr);
//		Logging.logger.info("Your deposit has been made!");
//	}catch (SQLException e) {
//		
//		Logging.logger.warn("Sorry, could not process your account.");
//		throw new InvalidTransactionException();
//		
//	}
//
//
//	return tr;
//}