
import javax.swing.*;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class Return extends Transaction {
    private int saleId;

    public Return(int saleId) {
        total = 0;
        subTotal = 0;
        this.saleId = saleId;
        payments = new ArrayList<>();
        items = new ArrayList<>();
    }

    public int getSaleId() {
        return saleId;
    }


    public boolean addItem(Item product) {
        LineItem item = user.getInstance().getSaleById( saleId ).getLineItemByCode( product.getItemID() );

        if (item == null) {
            return false; //means can't return item because not found
        }

        LineItem retItem = getLineItemByCode( product.getItemID() );
        if (retItem == null) {
            retItem = (new LineItem( product ));
        } else {
            subTotal += product.getPrice();
        }
        product.increaseQuantity();
        items.add( retItem );
        return true;

        if(retItem.getQuantity() < item.getQuantity())
            {
            retItem.increaseQuantity();
            } else{
                subTotal += product.getPrice();
            } return true;

        return false; //already returned all of that item
    }


    public boolean removeItem(Item product){
        boolean found = false;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getItem().getItemID() == product.getItemID()){
                if(items.get(i).getQuantity() == 1){
                    items.remove(i);
                }
                else{
                    items.get(i).decreaseQuantity();
                }
                subTotal-= product.getPrice();
                product.decreaseQuantity();
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

    @Override
    public String toString(){
        String output = "****** Return ******* \nSale ID: " + saleId + "\n Return ID: " + transactionID + "\n";
        for(int i = 0; i < items.size(); i++){
            output += items.get(i).toString();
        }
        return output;
    }
}