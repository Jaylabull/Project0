package com.bank.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private List<Account> accountNum;
	
	public User() {
		//Creates a number in string form for account
		accountNum = new ArrayList<Account>(new Random().nextInt(10000)+1000); 
	}
	

	public User(int id, String firstName, String lastName, String userName, String email, String password,
			List<Account> accountNum) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.accountNum = new ArrayList<Account>(new Random().nextInt(10000)+1000);
	}



	public User(int id, String firstName, String lastName, String userName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}


	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Account> getAccount() {
		return accountNum;
	}
	
	public void setAccount(List<Account> accountNum) {
		this.accountNum = accountNum;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", email=" + email + ", password=" + password + ", account number=" + accountNum + "]";
	}
}//End User Class
