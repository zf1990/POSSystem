
public class LineItem {

    protected int quantity;
    protected Item item;
    protected float price;

    public LineItem(Item item){
        quantity = 1;
        this.item = item;
        price = (float) item.getPricePerUnit();
    }

    public Item getItem(){
        return item;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

    public void decreaseQuantity(){
        quantity--;
        if(quantity < 0)
            quantity = 0;
    }

    public void setPrice(float newPrice) {
        price = newPrice;
    }

    @Override
    public String toString(){
        String output = item.toString() + "\n";
        if (price != item.getPricePerUnit())
            output += "*** Price overridden to " + price + "\n";
        if(quantity > 1)
            output += String.format("%2s %-15.15s\t%7.2f\n", "", "X" + quantity, quantity * price);
        return output;
    }
}