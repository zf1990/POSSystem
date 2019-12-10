
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public abstract class Transaction {

	public User handler;
	private LocalDateTime time;
	public ArrayList<Item> items;
	protected int transactionID;
	static int transactionCounter = 0;
	protected double total;
	protected double subTotal;
	protected ArrayList<Payment> payments; // for when we need to do returns
	public Register register;
	protected double taxRate = 0.0625;
	protected TransactionType transType;

	public Transaction(Register register) {
		this.register = register;
		this.handler = register.getCurrentUser();
		time = LocalDateTime.now();
		items = new ArrayList<Item>();
		transactionID = transactionCounter++;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void addPayment(Payment payment) {
		payments.add(payment);
	}
	
	public double getTotal() {
		return total;
	}


	public ArrayList<Item> getItems() {
		return items;
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public int getId() {
		return transactionID;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	public User getUser() {
		return handler;
	}

	public void setUser(User person) {
		this.handler = person;
	}

	public String printTotals() {
		String output = "";
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd\tHH:mm:ss");
		String formattedDateTime = myFormatObj.format(time);


		// Calculate tax and total


		// Set up ability to format print statements right so everything aligns
		int digits = Double.toString(total).length();
		String format = "%" + digits + ".2f";
		output += (toString() + "\n");
		output += String.format("Subtotal: $" + format + "\n", subTotal);
		output += String.format("Tax:      $" + format + "\n", taxRate*100 + "%");
		output += String.format("Total:    $" + format + "\n", total);

		return output;
	}

	@Override
	public abstract String toString();

	public abstract void updateInventory();
	public void updateRegister() {
		register.addTransaction(this);

	}

	public void FinishTransaction() {
		updateRegister();
		updateInventory();
		printReceipts();
	}

	protected abstract void processPayment();

	public abstract void printReceipts();

}
