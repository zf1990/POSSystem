import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* 
 * POS System
 * Zhou Fang, Anh Nguyen, Fadi Bchara
 * 12/13/2019
 */
public class MainMethod {
	public static void main(String[] args) {
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd\tHH:mm:ss");
		//String formattedDateTime = myFormatObj.format(time);
		
		String fomat = String.format("%20s %20s %20s \r\n", "Item Name", "Quantity", "Unit Price");
	    fomat += String.format("%20s %20s %20s \r\n", "Apple", "4234242", "565464564645");
		
		System.out.println(fomat);
	}
}
