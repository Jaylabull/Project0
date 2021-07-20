package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Transactions;
import com.bank.utils.ConnectionUtil;

public class TransactionsDaoDB implements TransactionsDao{
	/*
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public List<Transactions> getAllTransactions() {
		List<Transactions> transactionsls = new ArrayList<Transactions>();
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM transaction";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				transactionsls.add(new Transactions(rs.getInt(1) , rs.getTimestamp(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6)));
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
				
				trans.setTimestamp(rs.getTimestamp(2));
				trans.setAccountNum(rs.getInt(3));
				trans.setTransactionType(rs.getString(4));
				trans.setTransAmount(rs.getInt(5));
				trans.setAccountBal(rs.getDouble(6));
				
			}
			return trans;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	@Override
	public void logTransaction(Transactions t) {
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "INSERT INTO transactions(transaction_num, time_stamp, account_num, transaction_type, transaction_amount, account_balance) values"
					+ "(?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
		
				ps.setInt(1, t.getTransactionNum());
				ps.setTimestamp(2, t.getTimestamp());
				ps.setInt(3, t.getAccountNum());
				ps.setString(4, t.getTransactionType());
				ps.setInt(5, t.getTransAmount());
				ps.setDouble(6, t.getAccountBal());
				
				ps.execute();
				
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
*/
}
