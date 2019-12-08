package FileOutputStream;

import java.util.ArrayList;
import java.util.HashMap;

public class Register {
	double TotalSalesAmount;
	final int RegisterID = 1;
	public Transaction Register;
	
	ArrayList<Transaction> TransactionList;
	
	public class transaction{
		
		
	}
	
	public void addTransaction(Transaction transaction) {
		TransactionList.add(transaction);
		updateAmount(transaction);
		updateCashierReport(transaction);
		
	}
	
	public void updateAmount(Transaction toBeUpdated) {
		if (toBeUpdated instanceof Sale) {
			TotalSalesAmount = TotalSalesAmount + toBeUpdated.total;
		} else {
			TotalSalesAmount = TotalSalesAmount - toBeUpdated.total;

		}
	}

	public void updateCashierReport (Transaction trans) {
		HashMap <String, Integer > trans1 = new HashMap<>();
		// joe to add cashier class here 
	}
}
