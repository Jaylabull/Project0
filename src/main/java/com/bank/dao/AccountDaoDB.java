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

import com.bank.logging.Logging;
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
				accountList.add(0, ac);
			}
			u.setAccount(accountList);
			con.setAutoCommit(true);
			return (Account) accountList.get(0);
			
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
		ps.setInt(3, (int) a.getCurrentBal());
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



	public void makeDeposit(User u, int deposit) {
		Account a = new Account();
		try {	
			Connection con = conUtil.getConnection();
			
			String sql = "UPDATE accounts SET current_balance = ? WHERE customer_id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, deposit + a.getCurrentBal());
			ps.setInt(2, a.getCustomerID());
			ps.execute();
			
			Logging.logger.info("Your deposit has been processed.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void makeWithdrawl(User u, int deposit) {
		Account a = new Account();
		try {	
			Connection con = conUtil.getConnection();
			
			String sql = "UPDATE accounts SET current_balance = ? WHERE customer_id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, deposit - a.getCurrentBal());
			ps.setInt(2, a.getCustomerID());
			ps.execute();
			
			Logging.logger.info("Your deposit has been processed.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//transfer method
//	public void transfer(String acct1, String acct2, int transferAmt) {
//		AccountDaoDB a = new AccountDaoDB();
//		Account ac = null;
//		acct1 = ac.getAccountType();
//		acct2 = ac.getAccountType();
//		
//		
//	}

}//End AccountUserDao Class
