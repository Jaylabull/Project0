package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
	public Account getAccountByUser(User u) {
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "{?=call get_user_accounts(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, u.getId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				
				Account ac = new Account(rs.getInt(1) ,rs.getInt(2), rs.getInt(3), rs.getString(4));
				accountList.add(0, ac);;
			}
//			u.setAccountNum(accountList);
			u.setAccount(accountList);
			con.setAutoCommit(true);
			return (Account) accountList.get(1);
			
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

}//End AccountUserDao Class
