import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.*;
import java.time.format.DateTimeFormatter;


public class Sales extends Transaction {
	
	public HashMap<Item, Number> saleList;

    public Sales(Register register){
    	super(register);
        this.transactionID = transactionID;
        //payments = new ArrayList<>();
        items = new ArrayList<>();
        saleList = new HashMap<Item, Number>();
        transType = TransactionType.Sales;
    }

    public void addItem(int productID, Number quantity){
    	String message;
    	ArrayList<Item> copyList = Inventory.getInventoryList();
    	
    	
    	for (Item x : copyList) {
    		if (x.getItemID()==productID && x.getQuantity().doubleValue() >= quantity.doubleValue()) {
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
    

	public void processPayment() {
		subTotal = calculateSubtotal(saleList);
		total = calculateTotal(subTotal);
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
	
	public HashMap<Item, Number> getSaleList() {
		return saleList;
	}

	@Override
	public String printReceipts() {
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd\tHH:mm:ss");
		String formattedDateTime = myFormatObj.format(time);

		
		String purchases = String.format("%20s %20s %20s \r\n", "Item Name", "Quantity", "Unit Price");
		for (Entry<Item,Number> x : saleList.entrySet()) {
			purchases += String.format("%20s %20s %20s \r\n", x.getKey().getName(), x.getValue(), x.getKey().getPricePerUnit());
		}
		
		receipt = "\t\t\t****** Sale ******* \nTime: " + formattedDateTime + "\nSale ID: "  +transactionID + "\n" + "\n" + purchases + "\n\n" + printTotals();
		
		return receipt;
	}

}
