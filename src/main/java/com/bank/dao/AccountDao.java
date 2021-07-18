package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Account;

public interface AccountDao {
//	1
	 List<Account> getAllAccounts();
//	2		
	 Account getAccountByUser(String user);
//	3	
	 void createAccount(Account a) throws SQLException;
	
//	4	
	 void deleteAccount(Account a);
	
}
