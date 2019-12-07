
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> Inventory_List = new ArrayList<Item>();
    public Inventory(){}


    public void orderItem() {

    }

    public void orderReceived(Item items){
    }

    public ArrayList<Item> getAllItem(){
        for (int i = 0; i <Inventory_List.size(); i ++){
            Item list = Inventory_List.get( i );
            list.toString();
        }
        return Inventory_List;
    }

    public ArrayList<Item> getInventoryReport(){
        return this.Inventory_List;
    }
}
