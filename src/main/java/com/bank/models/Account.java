package com.bank.models;

import java.util.List;
import java.util.Random;

public class Account {

	private int accountNum;
	private int customerID;
	private double currentBal;
	private String accountType;	
	private List<Transactions> transactions;
	
	public Account() {
		
	}
	
	public Account(int customerID, double currentBal, String accountType) {
		this.setAccountNum(new Random().nextInt(100000) + 100000);
		this.customerID = customerID;
		this.currentBal = currentBal;
		this.accountType = accountType;
	}
	
	public Account(int accountNum, int customerID, double currentBal, String accountType) {
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.currentBal = currentBal;
		this.accountType = accountType;
	}


	public int getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	public double getCurrentBal() {
		return currentBal;
	}

	public void setCurrentBal(double currentBal) {
		this.currentBal = currentBal;
	}

	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Account(int accountNum, int customerID, double currentBal, String accountType,
			List<Transactions> transactions) {
		super();
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.currentBal = currentBal;
		this.accountType = accountType;
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", customerID=" + customerID + ", currentBal=" + currentBal
				+ ", accountType=" + accountType + ", transactions=" + transactions + "]";
	}
		

}//End Account Class
