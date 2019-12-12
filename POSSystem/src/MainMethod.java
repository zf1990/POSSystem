import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/* 
 * POS System
 * Zhou Fang, Anh Nguyen, Fadi Bchara
 * 12/13/2019
 */
public class MainMethod {
	public static void main(String[] args) {
		Inventory myStore = new Inventory("mystore");
		ArrayList<Item> list1 = new ArrayList<Item>();
		Item apple = new Item("Fuji apple", "mySupplier", 50.9, 20.0, 3.99, 1, 100.0);
		
		list1.add(apple);
		apple.setThreshhold(15.0);
		
		System.out.println(list1.get(0).getThreshhold());
	}
}
