package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Account;
import com.bank.models.Transactions;
import com.bank.models.User;

public interface AccountDao {

	 List<Account> getAllAccounts();
	
	 void createAccount(Account a) throws SQLException;
	
	 void deleteAccount(Account a);

	 void updateAccount(Account a) throws SQLException;

//	Account viewBalance(User u) throws SQLException;
	
	 Account viewBalance(Account a) throws SQLException;
	 
	 Account getAccountByUser(String user);
	
}
