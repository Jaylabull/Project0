package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Transactions;

public interface TransactionsDao {
	

	 List<Transactions> getAllTransactions();
	
	 Transactions getTransactionByUser(String user);

	void logTransaction(Transactions t) throws SQLException ;
	
//	 void viewBalance(Transactions t) throws SQLException;
//	 
//	 void makeWithdrawl(Transactions t) throws SQLException;

}
