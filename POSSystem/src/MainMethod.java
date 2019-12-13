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
		
		Inventory.orderItems(3,20);
		Inventory.orderReceived(3);

		Inventory.printReports();
		
		

	}
}
