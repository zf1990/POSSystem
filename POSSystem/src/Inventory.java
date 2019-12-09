/* 
 * POS System
 * Zhou Fang, Anh Nguyen, Fadi Bchara
 * 12/13/2019
 */

import java.io.*;
import java.util.ArrayList;

public class Inventory {
	private String name;
	private static ArrayList<Item> inventoryList;
	private static int itemCount;
	private String path;
	
	public Inventory(String name) {
		this.name = name;
		inventoryList = new ArrayList<Item>();
		itemCount=0;
		path = "inventoryReport.csv";
	}
	
	public static void addToInventory(Item item) {
		inventoryList.add(item);
		itemCount++;
	}
	
	public static void removeItem(Item item) {
		inventoryList.remove(item);
		itemCount--;
	}
	
	public void orderItems(Item item) {
		item.setOrderingQuantity(item.getOrderQuantity());
	}
	
	public void orderReceived(Item item) {
		item.addQuantity(item.getOrderingQuantity());
		item.setOrderingQuantity(0);
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
			
			
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception occured.  File not saved.");
		}
		
	}
	

}
