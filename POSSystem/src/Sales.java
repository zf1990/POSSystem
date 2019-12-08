package FileOutputStream;


import javax.swing.*;
import java.util.ArrayList;

public class Sale extends Transaction {
    public Sale(){
        total = 0;
        subTotal= 0;
        payments = new ArrayList<>();
        items = new ArrayList<>();
    }
    public Sale(int transactionID){
        total = 0;
        subTotal= 0;
        this.transactionID = transactionID;
        payments = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void addItem(Item product, boolean quantity){
        if(product.itemLeft()){
            LineItem item = getLineItemByCode(product.getItemID());
            if(true)
                ProductCatalog.findProductByCode(product.getItemID()).decreaseQuantity();
            if(item == null){
                items.add(new LineItem(product));
                subTotal += product.getPrice();
                return;
            }
            item.increaseQuantity();
            subTotal += item.getPrice();
        }
    }

    public boolean removeItem(Item product, boolean affectQuantity){
        boolean found = false;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getItem().getItemID() == product.getItemID()){
                if(affectQuantity)
                    product.increaseQuantity();
                if(items.get(i).getQuantity() == 1){
                    items.remove(i);
                }
                else{
                    items.get(i).decreaseQuantity();
                }
                subTotal-=product.getPrice();
                found = true;
                break;
            }
        }
        if(!found){//item not in Sale
            JOptionPane.showMessageDialog (null, "Item not found", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    public LineItem getLineItemByCode(int code){
        for(int i = 0; i< items.size(); i++){
            if(items.get(i).getItem().getItemID() == code)
                return items.get(i);
        }
        return null;
    }


    public String toString(){
        String output = "****** Sale ******* \n Sale ID: " + transactionID + "\n";
        for(int i = 0; i < items.size(); i++){
            output += items.get(i).toString();
        }
        return output;
    }

}
