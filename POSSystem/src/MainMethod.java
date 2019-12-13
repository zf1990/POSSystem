package POSSystem.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/* 
 * POS System
 * Zhou Fang, Anh Nguyen, Fadi Bchara
 * 12/13/2019
 */
public class MainMethod {
	public static void main(String[] args) throws IOException {
		Inventory myStore = new Inventory("MyStore");
		
		Item apple = new Item("Apple", "Riven", 50.6, 20.0, 2.99, 1, 100.0);
		Item pear = new Item("Pear", "Fiora", 20.5, 10.0, 1.99, 2, 50.0);
		Item Lotion = new Item("Hand Lotion", "Irelia", 50, 20, 2.99, 3, 50);
		Item RP = new Item("Riot Points", "Zed", 7000, 1000, 0.05, 4, 100000);
		
		Inventory.orderItems(3,20);
		Inventory.orderReceived(3);

		//Inventory.printReports();
		
		Register myRegister = new Register(1,200.0);
		User Zhou = new User("zf1216", "JavaLife", "Zhou", "Fang", "zhou.fan@sthomas.edu",
				"(507)995-4450", "Cashier", 1);
		
		User Anh = new User("AnhNguyuen0208", "RivenIsOp", "Anh", "Nguyen", "afa",
				"(507)995-4450", "Cashier", 2);
		
		User Jiaxin = new User("zhen3813", "expertGamer", "Anh", "Nguyen", "afa",
				"(507)995-4450", "Cashier", 2);
		
		myRegister.initiateLogin("zf1216", "JavaLife");
		
		Sales sale1 = new Sales(myRegister);
		sale1.addItem(4,2000);
		sale1.addItem(3, 70);
		sale1.addItem(1, 4.5);
		
		sale1.processPayment();
		
		System.out.println(sale1.receipt);
		
		
	}
}
