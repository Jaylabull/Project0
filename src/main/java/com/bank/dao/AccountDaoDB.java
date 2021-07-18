package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Account;
import com.bank.models.Transactions;
import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();


	@Override
	public List<Account> getAllAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		return null;
	}
	

@Override
	public Account getAccountByUser(String user) {
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "SELECT * FROM accounts WHERE customer_id =" + user + "'";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4)));
			}
			CallableStatement cs = con.prepareCall(sql);
			
			return (Account) accountList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createAccount(Account a) throws SQLException {
		try {
			Connection con = conUtil.getConnection();
			
			String sql =  "INSERT INTO accounts(account_number, customer_id, current_balance, account_type) values"
					+ "(?,?,?,?)";;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAccountNum());
			ps.setInt(2, a.getCustomerID());
			ps.setDouble(3, a.getCurrentBal());
			ps.setString(4, a.getAccountType());
		
			ps.execute();
					
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
//4
	@Override
	public void deleteAccount(Account a) {
		try {	
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM accounts WHERE accounts.customer_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAccountNum());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateAccount(Account a) throws SQLException {
		try {	
			Connection con = conUtil.getConnection();
			String sql = "UPDATE * FROM accounts WHERE transactions.account_balance =?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, a.getAccountNum());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}


	public Account viewBalance(Account a) throws SQLException {
			
		Account acct = new Account();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT current_balance FROM accounts WHERE current_balance = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				acct.setCurrentBal(rs.getDouble(3));
		
			}
			return acct;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return acct;
	
		
	}


}//End AccountUserDao Class
