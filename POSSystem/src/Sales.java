import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.*;


public class Sales extends Transaction {
	
	public HashMap<Item, Number> saleList;

    public Sales(Register register){
    	super(register);
        double total = 0;
        double subTotal= 0;
        this.transactionID = transactionID;
        payments = new ArrayList<>();
        items = new ArrayList<>();
        saleList = new HashMap<Item, Number>();
        transType = TransactionType.Sales;
    }

    public void addItem(int productID, Number quantity){
    	String message;
    	ArrayList<Item> copyList = Inventory.getInventoryList();
    	
    	for (Item x : copyList) {
    		if (x.getItemID()==productID && (double) x.getQuantity()> (double) quantity) {
    			saleList.put(x, quantity);
    			message = "Successfully Added";
    		} else {
    			message = "Product not found/Insufficient quantity.";
    		}
    	}
    }

    public void removeItem(Item itemRemoved, Number toBeRemoved){
    	String message;
    	if ((double) toBeRemoved> (double) saleList.get(itemRemoved)) {
    		message = "You can't remove more items than you have checked out!";
    	} else if (toBeRemoved == saleList.get(itemRemoved)) {
    		saleList.remove(itemRemoved);
    		message = "Item removed";
    	} else {
    		if (toBeRemoved instanceof Integer) {
    			int newQuan = (int) saleList.get(itemRemoved) - (int) toBeRemoved;
    			saleList.replace(itemRemoved, newQuan);
    			message = "Quantity decreased to " + newQuan + ".";
    		} else {
    			double newQuan = (double) saleList.get(itemRemoved) - (double) toBeRemoved;
    			saleList.replace(itemRemoved, newQuan);
    			message = "Quantity decreased to " + newQuan + ".";
    		}
    	}
    	
    	
//        boolean found = false;
//        for(int i = 0; i < items.size(); i++){
//            if(items.get(i).getItem().getItemID() == product.getItemID()){
//                if(affectQuantity)
//                    product.increaseQuantity();
//                if(items.get(i).getQuantity() == 1){
//                    items.remove(i);
//                }
//                else{
//                    items.get(i).decreaseQuantity();
//                }
////                subTotal-=product.getPrice();
////                found = true;
//                break;
//    		}
//        }
//        if(!found){//item not in Sale
//            JOptionPane.showMessageDialog (null, "Item not found", "Invalid Input", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//        return true;
//    }
//
//
//    public LineItem getLineItemByCode(int code){
//        for(int i = 0; i< items.size(); i++){
//            if(items.get(i).getItem().getItemID() == code)
//                return items.get(i);
//        }
//        return null;
    }
    
    public void calculateSubtotal() {
    	double itemCost;
    	int intItemCost;
    	double roundedCost;
    	for (Entry<Item, Number> pair : saleList.entrySet()) {
    		itemCost = pair.getKey().getPricePerUnit()*((double) pair.getValue());
    		intItemCost = (int) itemCost*100;
    		roundedCost = intItemCost/100.0;
    		subTotal += roundedCost;
    	}
    }
    
    public void calculateTotal() {
    	int totalInt;
    	total = subTotal*taxRate;
    	totalInt = (int) Math.ceil(total*100);
    	total = totalInt/100;
    }
	public void processPayment() {
		calculateSubtotal();
		calculateTotal();
		collectPayment();
		FinishTransaction();
	}
	private void collectPayment() {
		register.addCash(total);
	}
	
	public void updateInventory() {
		for (Entry<Item,Number> x : saleList.entrySet()) {
			x.getKey().removeQuantity(x.getValue());
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printReceipts() {
		
		
		String purchases = String.format("%20s %20s %20s \r\n", "Item Name", "Quantity", "Unit Price");
		for (Entry<Item,Number> x : saleList.entrySet()) {
			purchases += String.format("%20s %20s %20s \r\n", x.getKey().getName(), x.getValue(), x.getKey().getPricePerUnit());
		}
		
		
		
	}

}
