/* 
 * POS System
 * Zhou Fang, Anh Nguyen, Fadi Bchara
 * 12/13/2019
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
	private static String name;
	private static ArrayList<Item> inventoryList;
	private static HashMap<Integer, Item> itemMap;
	private static int itemCount;
	private String path;
	
	public Inventory(String storeName) {
		this.name = name;
		inventoryList = new ArrayList<Item>();
		itemCount=0;
		path = "inventoryReport.csv";
		itemMap = new HashMap<Integer, Item>();
		
	}
	
	public static void addToInventory(Item item) {
		inventoryList.add(item);
		itemMap.put(item.getItemID(), item);
		itemCount++;
	}
	
	public static void removeItem(Item item) {
		inventoryList.remove(item);
		itemMap.remove(item.getItemID());
		itemCount--;
	}
	
	public void orderItems(Item item) {
		item.setOrderingQuantity(item.getOrderQuantity());
	}
	
	public void orderReceived(Item item) {
		item.addQuantity(item.getOrderingQuantity());
		item.setOrderingQuantity(0);
	}
	
	public static ArrayList<Item> getInventoryList() {
		return inventoryList;
	}
	
	public static HashMap<Integer, Item> getItemMap() {
		return itemMap;
	}
	
//	private int findIndex(Item item) {
//		int index = inventoryList.indexOf(item);
//		return index;
//	}
	
	public void printReports() {
		try {
			FileWriter csvWriter = new FileWriter(path, false);
			BufferedWriter buffWriter = new BufferedWriter(csvWriter);
			PrintWriter pw = new PrintWriter(buffWriter);
			
			pw.println("Item Name" + "," + "Current Item Quantity" + "," + "Threshhold" + "," + "Supplier" + "," + "Pending Item Quantity");
			
			for (int i = 0; i<itemCount; i++) {
				pw.println(inventoryList.get(i).getName() + "," +
						inventoryList.get(i).getQuantity().toString() + "," +
						inventoryList.get(i).getThreshhold().toString() + "," +
						inventoryList.get(i).getSupplier() + "," +
						inventoryList.get(i).getOrderingQuantity().toString()
						);
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			System.out.println("Exception occured.  File not saved.");
		}
	}

}
