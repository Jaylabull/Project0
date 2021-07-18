package com.bank;

import java.util.List;
import java.util.Scanner;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoDB;
import com.bank.dao.UserDao;
import com.bank.dao.UserDaoDB;
import com.bank.models.Account;
import com.bank.models.User;
import com.bank.services.AccountServices;
import com.bank.services.UserService;


public class BankDriver {

	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static AccountDao aDao = new AccountDaoDB();
	private static AccountServices aServ = new AccountServices(aDao);
	Account a;
	
	public static void main(String[] args) {
	

		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to J&B Bank!");
		//Boolean used to control loop
		boolean done = false;
		
		User u = null;
		
		while (!done) {
			//To Sign up or sign in
			if (u == null) {
				
				System.out.println("To Login Press 1. ");
				System.out.println("To Signup: Press 2.");
			
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					
					System.out.println("Please enter your username: ");
					String username = in.nextLine();
					System.out.println("Please enter your password: ");
					String password = in.nextLine();
					
					try {
						u = uServ.signIn(username, password);
						System.out.println("Welcome " + u.getFirstName());
						//Add switch for customer options: ie. view balance, create account
						
					} catch (Exception e) {
						System.out.println("Username or password was incorrect. Goodbye");
						done = true;
					}
				}else {
						System.out.print("Please enter your first name: ");
						String first = in.nextLine();
						System.out.print("Please enter your last name: ");
						String last = in.nextLine();
						System.out.print("Please enter your email: ");
						String email = in.nextLine();
						System.out.print("Please enter a password: ");
						String password = in.nextLine();
						try {
							u = uServ.signUp(first, last, email, password);
							System.out.println("You man now login with the username:  " + u.getUserName());
						} catch (Exception e) {
							System.out.println("Sorry, we could not process you request.");
							System.out.println("Please try again later.");
							done = true;
						}
					}
			}
		
			//Create checking or savings account (with accountType)
			else {
				System.out.println("To logout press 1, to create an savings or checking account press 2");
				
				int choice = Integer.parseInt(in.nextLine());
				//If user chooses 1, we will show them the list of post
				if(choice == 1) {
					
					List<Account> accountList = null;
					
					for(Account account: accountList) {
						System.out.println(account.getAccountNum() + ":");
						System.out.println(account.getAccountType());
						System.out.println();
					}
					System.out.println("Are you finished? Press 1 for yes, press 2 for no.");
					choice = Integer.parseInt(in.nextLine());
					done = (choice ==1) ? true : false;
					
			}
				else {
//					 System.out.println("Please enter your content below: ");
//					 String content = in.nextLine();
//					 pServ.addPost(u.getId(), u.getId(), content);
//					 System.out.println("Post was received, are you finished? Press 1 for yes,"
//					 		+ " press 2 for no.");
//					 choice = Integer.parseInt(in.nextLine());
//					 done = (choice == 1) ? true : false;
					
				}
			

		}//End While loop
		System.out.println("Goodbye.");
		in.close();
		}
		
	}//End BankDriver Method

}//End BankDriver Class



//TESTING DATABASE CONNECTION, UserDao, and UserService methods

//uServ.signIn("JaylaBull7427", "password");
//uServ.signUp("Jayla", "Bull", "jb@mail.com", "password");
//System.out.println(uDao.getUserByUsername("JaylaBull7427"));
//User u = uDao.getUserByUsername("JaylaBull5536");
//
//uDao.deleteUser(u);


//UserDao uDao = new UserDaoDB();

//uServ.signUp("Jayla", "Bull", "jb@mail.com", "password");

//a = aServ.createAccount(4497, 50, "CHECKING");