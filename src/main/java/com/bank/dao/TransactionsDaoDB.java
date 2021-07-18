package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Transactions;
import com.bank.utils.ConnectionUtil;

public class TransactionsDaoDB implements TransactionsDao{
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public List<Transactions> getAllTransactions() {
		List<Transactions> transactionsls = new ArrayList<Transactions>();
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statement we write our query as a string
			String sql = "SELECT * FROM transaction";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				transactionsls.add(new Transactions(rs.getTimestamp(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5)));
			}
			
			return transactionsls;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Transactions getTransactionByUser(String transaction) {
		Transactions trans = new Transactions();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM transactions WHERE transactions.transaction_num = '" + transaction + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				trans.setTimestamp(rs.getTimestamp(1));
				trans.setAccountNum(rs.getInt(2));
				trans.setTransAmount(rs.getDouble(3));
				trans.setTransactionType(rs.getString(4));
				trans.setAccountBal(rs.getDouble(5));
			}
			return trans;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void logTransaction(Transactions t) throws SQLException {
		
		
	}

	


	
	
}
