package com.bank.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Transactions;

public class TransactionsDaoDB implements TransactionsDao{

	@Override
	public List<Transactions> getAllTransactions() {
		List<Transactions> transactionsls = new ArrayList<Transactions>();
		return null;
	}

	@Override
	public Transactions getTransactionByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeDeposit(Transactions t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeWithdrawl(Transactions t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
}
