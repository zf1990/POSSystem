//
//import jdk.internal.module.Resources;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class ProductCatalog {
//    private static ProductCatalog cat;
//    private ArrayList<Item> items;
//
//    private ProductCatalog(){
//        items = new ArrayList<>();
//        try{
//            Scanner read = new Scanner(new File(Resources.getPath("Product_description.txt")));
//            read.useDelimiter("\\|");
//            while(read.hasNext()){
////                while(read.hasNext()){
////                System.out.println(read.nextLine());
////                }
//
//                int id = Integer.parseInt(read.next());
//                String itemName = read.next();
//                int quantity = Integer.parseInt( read.next() );
//                int thresholdForOrder = Integer.parseInt( read.next() );
//                float price = Float.parseFloat(read.next());
//                String supplier = read.next();
//                Item product = new Item(id,itemName, quantity, thresholdForOrder, price, supplier);
//                items.add(product);
//                read.nextLine();
//            }
//        }
//        catch(FileNotFoundException | NumberFormatException e){
//            System.out.println(e.toString());
//        }
//    }
//
//
//    public static synchronized ProductCatalog getCatalog(){
//        if (cat==null){
//            cat=new ProductCatalog();
//        }
//        return cat;
//    }
//
//    public void addItem(Item desc){
//        items.add(desc);
//    }
//
//    public static Item findProductByCode(int code){
//        for (Item item : items) {
//            if (code == item.getItemID()) {
//                return item;
//            }
//        }
//        return null;
//    }
//    
//    public synchronized void updateFile(){
//        File catalog = new File(Resources.getPath("Product_description.txt"));
//        try{
//            FileOutputStream fos = new FileOutputStream(catalog);
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//            for (Item item : items) {
//                bw.write(item.getItemID()+"|"+item.getItemName()+"|"+item.getPrice()+"|"+item.getQuantity()+"|");
//                bw.newLine();
//            }
//            bw.close();
//        } catch(Exception e){
//            System.out.println(e.toString());
//        }
//    }
//}