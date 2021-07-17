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
	private List<Account> account;
	
	public User() {
		account = new ArrayList<Account>(); 
	}
	

	public User(int id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.email = email;
		this.password = password;
		account = new ArrayList<Account>(); 
	}


	public User(String firstName, String lastName, String email, String password) {
		this.setId(new Random().nextInt(9000) + 1000);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.email = email;
		this.password = password;
		account = new ArrayList<Account>(); 
	}

	public User(int id, String firstName, String lastName,String userName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.userName = firstName +lastName + (new Random().nextInt(9000)+1000);
		this.email = email;
		this.password = password;
		this.account = new ArrayList<Account>();
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
		return account;
	}
	
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", email=" + email + ", password=" + password + ", account number=" + account + "]";
	}
}//End User Class
