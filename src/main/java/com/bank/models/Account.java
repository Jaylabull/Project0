package com.bank.models;

import java.util.List;
import java.util.Random;

public class Account {

	private int accountNum;
	private int customerID;
	private double startingBal;
	private String accountType;	
	private List<Transactions> transactions;
	
	public Account(int customerID, double startingBal, String accountType) {
		this.setAccountNum(new Random().nextInt(100000) + 100000);
		this.customerID = customerID;
		this.startingBal = startingBal;
		this.accountType = accountType;
	}
	
	public Account(int accountNum, int customerID, double startingBal, String accountType) {
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.startingBal = startingBal;
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
	
	public double getStartingBal() {
		return startingBal;
	}
	
	public void setStartingBal(double startingBal) {
		this.startingBal = startingBal;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", customerID=" + customerID + ", startingBal=" + startingBal
				+ ", accountType=" + accountType + "]";
	}	



}//End Account Class
