
import java.util.ArrayList;
import java.util.HashMap;

public class Register {
	private double TotalSalesAmount;
	private final int RegisterID;
	private ArrayList<Transaction> TransactionList;
	private User currentUser;
	private double cashAmount;
	
	public Register(int RegisterID) {
		this.RegisterID = RegisterID;
	}
	
	public Register(int RegisterID, double existingCash) {
		this.RegisterID = RegisterID;
		cashAmount = existingCash;
	}
	
	public void addTransaction(Transaction transaction) {
		TransactionList.add(transaction);
		updateAmount(transaction);
		updateCashierReport(transaction);		
	}
	
	public void addCash(double amount) {
		cashAmount += amount;
	}
	
	public void removeCash(double amount) {
		cashAmount -= amount;
	}
	
	public void updateAmount(Transaction toBeUpdated) {
		if (toBeUpdated instanceof Sales) {
			TotalSalesAmount = TotalSalesAmount + toBeUpdated.total;
		} else {
			TotalSalesAmount = TotalSalesAmount - toBeUpdated.total;
		}
	}

	public void updateCashierReport (Transaction trans) {
		HashMap <String, Integer > trans1 = new HashMap<>();
		// Zhou to add cashier class here 
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
