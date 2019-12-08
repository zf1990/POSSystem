/* 
 * POS System
 * Zhou Fang, Anh Nguyen, Fadi Bchara
 * 12/13/2019
 */

import java.util.ArrayList;

public class Inventory {
	private String name;
	private static ArrayList<Item> inventoryList;
	
	public Inventory(String name) {
		this.name = name;
		inventoryList = new ArrayList<Item>();
	}
	
	public static void addToInventory(Item item) {
		inventoryList.add(item);
	}
	
	public static void removeItem(Item item) {
		inventoryList.remove(item);
	}
	
	public void orderItems(Item item) {
		Item tobeChanged = inventoryList.get(findIndex(item));
		tobeChanged.setOrderingQuantity(tobeChanged.getOrderQuantity());
	}
	
	public void orderReceived(Item item) {
		Item tobeChanged = inventoryList.get(findIndex(item));
		tobeChanged.addQuantity(tobeChanged.getOrderingQuantity());
		tobeChanged.setOrderingQuantity(0);
	}
	
	public int findIndex(Item item) {
		int index = inventoryList.indexOf(item);
		
		return index;
	}

}
