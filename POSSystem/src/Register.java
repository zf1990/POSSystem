
import java.util.ArrayList;
import java.util.HashMap;

public class Register {
	private double registerTransactionAmount;
	private final int RegisterID;
	ArrayList<Transaction> registerTransactions;
	static ArrayList<Transaction> overallTransactions = new ArrayList<Transaction>();
	private User currentUser;
	private double cashAmount;
	private Login loginModule;
	
	
	public Register(int RegisterID) {
		this.RegisterID = RegisterID;
		registerTransactions = new ArrayList<Transaction>();
		registerTransactionAmount = 0.00;
		cashAmount = 0.00;
		
	}
	
	public Register(int RegisterID, double existingCash) {
		this.RegisterID = RegisterID;
		registerTransactions = new ArrayList<Transaction>();
		registerTransactionAmount = 0.00;
		cashAmount = existingCash;
	}
	
	public void initiateLogin(String userName, String password) {
		loginModule = new Login();
		loginModule.checkLogin(userName, password);
		currentUser = loginModule.getLoggedInUser();
	}
	
	public void addTransaction(Transaction transaction) {
		registerTransactions.add(transaction);
		overallTransactions.add(transaction);
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
			registerTransactionAmount = registerTransactionAmount + toBeUpdated.total;
		} else {
			registerTransactionAmount = registerTransactionAmount - toBeUpdated.total;
		}
	}

	public void updateCashierReport (Transaction trans) {
		HashMap <String, Integer > trans1 = new HashMap<>();
		// Zhou to add cashier class here 
	}
	
	public Transaction findTransaction(int TransactionID) {
		int index = 0;
		int actualIndex=999999999;
		for (Transaction x : overallTransactions) {
			if(x.getTransactionID() == TransactionID) {
				actualIndex=index;
				break;
			} else {
				index++;
			}
		}
		if (actualIndex != 999999999)
			return overallTransactions.get(actualIndex);
		else
			return null;
		
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public double getRegisterTransactionAmount() {
		return registerTransactionAmount;
	}

	public int getRegisterID() {
		return RegisterID;
	}

	public ArrayList<Transaction> getRegisterTransactions() {
		return registerTransactions;
	}

	public static ArrayList<Transaction> getOverallTransactions() {
		return overallTransactions;
	}

	public double getCashAmount() {
		return cashAmount;
	}

	
	
}
