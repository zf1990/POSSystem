/* 
 * POS System
 * Zhou Fang, Anh Nguyen, Fadi Bchara
 * 12/13/2019
 */
public class Item {
	private String name;
	private Number Quantity; //Using a number property to indicate it can be either 
	private Number Threshhold; 
	private double pricePerUnit;
	private int ItemID;
	private Number orderQuantity; //The number to be ordered should the quantity falls below threshold
	private Number orderingQuantity;
	private String supplier;
	private boolean isInt; //Determines weather the quantity is in the unit of weight or per unit.
	
	public Item(String name, String supplier, Number Quantity, Number Threshhold, double pricePerUnit, int ItemID, Number orderQuantity) {
		this.name = name;
		this.supplier = supplier;
		this.Threshhold = Threshhold;
		this.pricePerUnit = pricePerUnit;
		this.ItemID = ItemID;
		this.orderQuantity = orderQuantity;
		addItems(this);
		
		if (Quantity instanceof Integer)
			isInt = true;
		else
			isInt = false;
		
	}	
	
	private void addItems(Item item) {
		Inventory.addToInventory(item);
	}
	
	public void deleteItem() {
		Inventory.removeItem(this);
	}

	public String getName() {
		return name;
	}

	public int getItemID() {
		return ItemID;
	}

	public Number getQuantity() {
		return Quantity;
	}

	public void setQuantity(Number quantity) {
		Quantity = quantity;
	}
	
	public void addQuantity(Number addingquantity) {
		if (isInt = true) {
			Quantity = (int)Quantity + (int)addingquantity;
		} else {
			Quantity = (double)Quantity + (double)addingquantity;
		}
	}
	
	public void removeQuantity(Number removeQuantity) {
		if (isInt = true) {
			Quantity = (int)Quantity - (int)removeQuantity;
		} else {
			Quantity = (double)Quantity - (double)removeQuantity;
		}
	}


	public Number getThreshhold() {
		return Threshhold;
	}

	public void setThreshhold(Number threshhold) {
		Threshhold = threshhold;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Number getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Number orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Number getOrderingQuantity() {
		return orderingQuantity;
	}

	public void setOrderingQuantity(Number orderingQuantity) {
		this.orderingQuantity = orderingQuantity;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public void getInventoryReport() {
		// Inputs and outputs to be displayed into file or csv.
		
		
	}

	public void setOrderingQuantity(int orderingQuantity2) {
		this.orderingQuantity = orderingQuantity2;
		
	}

}
