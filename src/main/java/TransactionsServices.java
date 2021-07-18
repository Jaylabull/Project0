import java.sql.SQLException;

import com.bank.dao.TransactionsDao;
import com.bank.exceptions.TransactionNotFoundException;
import com.bank.logging.Logging;
import com.bank.models.Transactions;


public class TransactionsServices {
	
	Transactions trans = new Transactions();
	
private TransactionsDao tDao;
	
	public TransactionsServices(TransactionsDao t) {
		this.tDao = t;
	}
	
	public Transactions logTransaction( int accountNum, double balance, String acctType) throws TransactionNotFoundException {
		Transactions t = new Transactions();
		
		try {
			tDao.logTransaction(t);
			Logging.logger.info("Your transaction has been listed.");
			
		} catch (SQLException e) {
			Logging.logger.warn("Your transaction already exists in the database");
			throw new TransactionNotFoundException();
		}
		 
		return t;
	}
	

	
}
