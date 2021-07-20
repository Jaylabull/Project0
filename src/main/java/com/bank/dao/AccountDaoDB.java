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
import java.util.Scanner;

import com.bank.logging.Logging;
import com.bank.models.Account;
import com.bank.models.Transactions;
import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{
	Scanner in = new Scanner(System.in);
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
//				System.out.println(accountList);
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
		ps.setInt(3,(int)a.getCurrentBal());
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
		Account a = getAccountByUser(u);
		try {	
			Connection con = conUtil.getConnection();
			
			String sql = "UPDATE accounts SET current_balance = ? WHERE customer_id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getCurrentBal() + deposit);
			ps.setInt(2, u.getId());
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
			
			ps.setInt(1, a.getCurrentBal() - deposit);
			ps.setInt(2, u.getId());
			ps.execute();
			
			Logging.logger.info("Your deposit has been processed.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void transfer() {
		
		System.out.println("Please enter Account number you would like to transfer from: ");
		String acctNum = in.nextLine();
		
		System.out.println("Enter the amount you would like to transfer: ");
		int transferAmt = in.nextInt();
		
		if(transferAmt > 0) {
			
			String sql = "SELECT current_balance FROM accounts WHERE account_number = ?";
			Connection con = conUtil.getConnection();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, acctNum);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					int acctBalance = rs.getInt("current_balance");
					
					if(transferAmt <= acctBalance) {
						
						System.out.println("Please enter Account number you would like to transfer to: ");
						String toAcctNum = in.nextLine();
						
						String sql2 = "SELECT current_balance FROM accounts WHERE account_number = ?";
						PreparedStatement ps2 = con.prepareStatement(sql2);
						
						ps2.setString(1, toAcctNum);
						
						rs = ps2.executeQuery();
						
						if(rs.next()) {
							
						String sql3 = "UPDATE accounts SET current_balance =? WHERE account_number =?";
						
						PreparedStatement ps3 = con.prepareStatement(sql3);
						ps3.setInt(1, acctBalance - transferAmt);
						ps3.setString(2, acctNum);
						
						ps3.executeUpdate();
	
						String sql4 = "UPDATE accounts SET current_balance =? WHERE account_number = ?";
						
						PreparedStatement ps4 = con.prepareStatement(sql4);
						ps3.setInt(1, acctBalance + transferAmt);
						ps3.setString(2, toAcctNum);
						
						ps3.executeUpdate();
						
						System.out.println("Your transfer has been processed.");
						
					
					}else {
						System.out.println("The account you want to transfer to does not exist.");
					}
					}else {
						System.out.println("You don't have sufficient funds to make a transfer.");
					}
					}else {
						System.out.println("Please enter the correct account number.");
					}
				
				}catch (SQLException e) {
				e.printStackTrace();}	
		}
	}//End Transfer Method
}//End AccountUserDao Class
