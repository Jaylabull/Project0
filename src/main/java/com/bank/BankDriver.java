package com.bank;

import java.sql.SQLException;
import java.util.ArrayList;
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
	static Account a;
	
	public static void main(String[] args) throws SQLException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("********************");
		System.out.println();
		System.out.println("Welcome to J&B Bank!");
		System.out.println();
		System.out.println("********************");
		
		//Boolean used to control loop
		boolean done = false;
		
		User u = null;
		
		while (!done) {
			//To Sign up or sign in
			if (u == null) {
				System.out.println("What would you like to do?\n"
						+ "1. LOGIN\n"
						+ "2. SIGNUP");
			
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {//1. LOGIN
					
					System.out.println("Please enter your username: ");
					String username = in.nextLine();
					System.out.println("Please enter your password: ");
					String password = in.nextLine();
					
					try {
						u = uServ.signIn(username, password);
						System.out.println("\n");
						System.out.println("Welcome " + u.getFirstName() + "!");
						//Add switch for customer options: ie. view balance, create account
						
					} catch (Exception e) {
						System.out.println("Username or password was incorrect. Goodbye");
						done = true;
					}
				}else {//2. SIGNUP
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
			}//End SignIn or SignUp
	
			//Customer options
			else {
				System.out.println("What would you like to do?\n");
				System.out.println("1. View Account Balance\n"
						+ "2. Create Account\n"
						+ "3. Make A Deposit\n"
						+ "4. Make A withdrawal\n"
						+ "5. Make A Transfer\n"
						+ "6. Logout");
				int choice = Integer.parseInt(in.nextLine());
				//Switch statement for customer options
				switch(choice) {
				
					case 1:
						
						System.out.println("Your current balance for your account is: $ " + aDao.getAccountByUser(u).getCurrentBal());
						break;
					case 2:
						//create account method
						break;
					case 3:
						//make deposit method
						break;
					case 4:
						//make withdrawal method
						break;
					case 5:
						//make transfer method
						break;
					case 6:
						//logout
					default:
						System.out.println("Sorry, this is not a valid choice.");
				}//End switch statement
				
//				if(choice == 1) {
//					
//					List<Account> accountList = null;
//					
//					for(Account account: accountList) {
//						System.out.println(account.getAccountNum() + ":");
//						System.out.println(account.getAccountType());
//						System.out.println();
					}
//					System.out.println("Are you finished? Press 1 for yes, press 2 for no.");
					
					
			}//End While loop
				
		System.out.println("Goodbye.");
		in.close();
		}//End Main Method
		
	
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



//TESTING getAccountByUser() from aDao -> returns null
//		Account ac = new Account();
//		
//		aDao.getAccountByUser(ac);
//	
//		System.out.println(aDao.getAllAccounts());


