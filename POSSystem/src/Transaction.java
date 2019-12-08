
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public abstract class Transaction {

	public Cashier cashier;
	public LocalDateTime time = LocalDateTime.now();
	public ArrayList<LineItem> items;
	protected int transactionID;
	protected float total;
	protected float subTotal;
	protected ArrayList<Payment> payments; // for when we need to do returns
	public Register register;
	public Cashier cashier;

	public float getTotal() {
		return total;
	}

	public Transaction(Cashier cashier, Register register) {
		this.register = register;
		this.cashier = cashier;

	}

	public float getSubTotal() {
		return subTotal;
	}

	public void addPayment(Payment payment) {
		payments.add(payment);
	}

	public ArrayList<LineItem> getItems() {
		return items;
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public int getId() {
		return transactionID;
	}

	public void setItems(ArrayList<LineItem> items) {
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

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String printTotals() {
		String output = " ";
		// Calculate tax and total
		float tax = TaxCalculator.getTax(subTotal);
		total = subTotal + tax;

		// Set up ability to format print statements right so everything aligns
		int digits = ((Float) total).toString().length();
		String format = "%" + digits + ".2f";
		output += (toString() + "\n");
		output += String.format("Subtotal: $" + format + "\n", subTotal);
		output += String.format("Tax:      $" + format + "\n", tax);
		output += String.format("Total:    $" + format + "\n", total);

		return output;
	}

	@Override
	public abstract String toString();

	public void updateInventory(HashMap Item) {

	}

	public void updateRegister() {
		register.addTransaction(this);
		register.updateCashierReport(trans);
		register.updateAmount(toBeUpdated);

	}

	public class FinishingTransaction {

	}

}
