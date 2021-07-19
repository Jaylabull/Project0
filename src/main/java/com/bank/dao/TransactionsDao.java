package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Transactions;

public interface TransactionsDao {
	

	 List<Transactions> getAllTransactions();
	
	 Transactions getTransactionByUser(String user);

	 //makeDeposit 
	 
	 public Transactions makeDeposit(int accountNum, double deposit);
	 
	 //make withdrawal
	 
	 //make transfer b/t accounts

}
