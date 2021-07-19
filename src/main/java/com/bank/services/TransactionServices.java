package com.bank.services;

import com.bank.dao.AccountDaoDB;
import com.bank.dao.TransactionsDao;
import com.bank.logging.Logging;
import com.bank.models.Transactions;
import com.bank.models.User;

public class TransactionServices {

	private TransactionsDao tDao;

	public TransactionServices(TransactionsDao t)  {
		
		this.tDao = t;
		
	}
	
	public Transactions makeDeposit(int accountNum, double deposit) {
	
			
			Logging.logger.info("Your deposit had been made!");
	
		return null;
	}
	
	
}//End TransactionServices Class
