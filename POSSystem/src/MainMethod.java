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
		String path = "salesReportByCashier.csv";
		FileWriter csvWriter = new FileWriter(path, false);
		BufferedWriter buffWriter = new BufferedWriter(csvWriter);
		PrintWriter pw = new PrintWriter(buffWriter);
		DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		LocalDateTime time = LocalDateTime.now();
		
		pw.println("Cashier Name" + "," + "Trsansaction Type" + "," + "Transaction Amount" + "," + "Date" + "," + "Time\n");
		pw.println(time.format(dayFormatter) + "," + time.format(timeFormatter));
		
		pw.flush();
		pw.close();

	}
}
