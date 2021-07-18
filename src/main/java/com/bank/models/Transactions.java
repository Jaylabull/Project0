package com.bank.models;

import java.sql.Timestamp;

public class Transactions {

	private Timestamp timestamp;
	private int accountNum;
	private String transactionType;
	private double transAmount;
	private double accountBal;
	

	public Transactions(Timestamp timestamp, int accountNum, String transactionType, double transAmount, double accountBal) {
		this.timestamp = timestamp ;
		this.accountNum = accountNum;
		this.transactionType = transactionType;
		this.transAmount = transAmount;
		this.accountBal = accountBal;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}


	public double getTransAmount() {
		return transAmount;
	}


	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}


	public double getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}


	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	@Override
	public String toString() {
		return "Transactions [timestamp=" + timestamp + ", accountNum=" + accountNum + ", transactionType="
				+ transactionType + ", transAmount=" + transAmount + ", accountBal=" + accountBal + "]";
	}
	
	
}//End Transactions class
