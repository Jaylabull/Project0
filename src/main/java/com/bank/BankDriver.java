package com.bank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoDB;
import com.bank.dao.TransactionsDao;
import com.bank.dao.TransactionsDaoDB;
import com.bank.dao.UserDao;
import com.bank.dao.UserDaoDB;
import com.bank.models.Account;
import com.bank.models.Transactions;
import com.bank.models.User;
import com.bank.services.AccountServices;
import com.bank.services.TransactionServices;
import com.bank.services.UserService;


public class BankDriver {

	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static AccountDao aDao = new AccountDaoDB();
	private static AccountServices aServ = new AccountServices(aDao);
	static Account a;
	static User u;
	static Transactions t;
	
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
				System.out.println("\n");
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
						//View balance
						System.out.println("Your current balance for your account is: $ " + aDao.getAccountByUser(u).getCurrentBal());
						break;
					case 2:
						//Create an account 
						System.out.println("Please enter your Customer ID");
						System.out.println("Your Customer ID is: " + u.getId() + ".");
						int id = Integer.parseInt(in.nextLine());
						
						System.out.println("Please enter the type of account you would like to create:\nCHECKINGS"
								+ " or\n SAVINGS");
							String acctType = in.nextLine().toUpperCase();
							
								if(!"CHECKINGS".equals(acctType) && !"SAVINGS".equals(acctType)) {
									
								System.out.println("This is not a valid input, please enter checkings or savings");
								continue;
								
							}
						System.out.println("The minimium balance to start an account is $50. "
									+ "Please enter a balance of at least $50.");
							int balance = Integer.parseInt(in.nextLine());
				
							
							if (balance < 50) {
								System.out.println("You need at least $50 to make a new account."
										+ "Please enter a new amount.");
							}else {
								
								try {
									
									a = aServ.createAccount(id, balance, acctType);
									System.out.println("Your " + a.getAccountType().toLowerCase() + " account has been created! Your account number is "
											 + a.getAccountNum());	
									
								}catch (Exception e) {
							
								System.out.println("Sorry, we could not process you request.");
								System.out.println("Please try again later.");
								done = true;
								}
							}
						break;
					case 3:
						//Make a deposit
						System.out.println("Please enter your Account Number for Deposit: ");
						
						System.out.println("Accounts: " + aDao.getAccountByUser(u).getAccountNum());
						System.out.println("Please enter an amount you would like to deposit: ");
						int deposit = Integer.parseInt(in.nextLine());
						
						System.out.println("Deposit amount: $" + deposit);
						aDao.makeDeposit(u, deposit);
						
						System.out.println("Your new account balance is: $" + aDao.getAccountByUser(u).getCurrentBal() + "\n");
						break;
					case 4:
						//make withdrawal method
						System.out.println("Please enter your Account Number for Deposit: ");
//						System.out.println("Accounts: " + aDao.getAccountByUser(u).getAccountNum());
						
						System.out.println("Please enter an amount you would like to deposit: ");
						int withdrawal = Integer.parseInt(in.nextLine());
						
						System.out.println("Deposit amount: $" + withdrawal);
						aDao.makeDeposit(u, withdrawal);
						
						System.out.println("Your new account balance is: $" + aDao.getAccountByUser(u).getCurrentBal() + "\n");
						break;
					case 5:
//						//make transfer method
						aDao.transfer();
						break;
					case 6:
						//logout
						done = true;
						break;
					default:
						System.out.println("Sorry, this is not a valid choice.");
				}//End switch statement
				
					}
					
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

//TESTING createAccount() in aServ
//Account ac = new Account();
//
//aServ.createAccount(4497, 50, "SAVINGS");

