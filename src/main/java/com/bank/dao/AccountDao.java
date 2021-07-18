package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Account;
import com.bank.models.Transactions;

public interface AccountDao {

	 List<Account> getAllAccounts();
		
	 Account getAccountByUser(String user);
	
	 void createAccount(Account a) throws SQLException;
	
//	 void updateAccount(Account a) throws SQLException;
	 
	 void deleteAccount(Account a);

	void updateAccount(Account a) throws SQLException;
	
}
