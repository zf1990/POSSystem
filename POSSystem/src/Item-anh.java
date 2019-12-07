
public class Item {

    //Item variables
    private String itemName;
    private int quantity;
    private int threshold;
    private float pricePerUnit;
    private int unit;
    private double weight; // depend
    private int itemID;
    private String supplier;
    private int orderQuantity;
    private int currentQuantity;

    //Default construction
    public Item (){ }

    public Item (int itemID,String itemName, int currentQuantity, int thresholdForOrder, float price, String supplier){
        this.itemID = itemID;
        this. itemName = itemName;
        this. currentQuantity = currentQuantity;
        this.threshold = thresholdForOrder;
        this.pricePerUnit = price;
        this.supplier = supplier;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getPrice(){
        return getPrice();
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getItemID() {
        return this.itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplierName) {
        this.supplier = supplierName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public synchronized void increaseQuantity(){
        quantity++;
    }

    public synchronized void decreaseQuantity(){
        quantity--;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public synchronized boolean itemLeft(){
        if(quantity>0)
            return true;
        return false;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}
