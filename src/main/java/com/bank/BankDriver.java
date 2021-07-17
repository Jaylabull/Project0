package com.bank;

import com.bank.dao.UserDao;
import com.bank.dao.UserDaoDB;
import com.bank.models.User;
import com.bank.services.UserService;

public class BankDriver {

	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	
	public static void main(String[] args) {
	
		UserDao uDao = new UserDaoDB();
		UserService uServ = new UserService(uDao);
	
	  uServ.signUp("Jay", "Bull", "jb@mail.com", "password");
		
	}//End BankDriver Method

}//End BankDriver Class
