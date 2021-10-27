package JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class DBmain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DBmanager db = new DBmanager();
        db.connect();
        while(true) {

            System.out.println("[1] ADD ITEMS");
            System.out.println("[2] LIST ITEMS");
            System.out.println("[3] DELETE ITEMS");
            System.out.println("[0] EXIT");

            int choice = in.nextInt();
            if(choice==1){
                System.out.println("Insert Name: ");
                String name = in.next();
                System.out.println("Insert Price: ");
                double price = in.nextDouble();
                Items item = new Items(null, name, price);
                db.addItem(item);
            }else if(choice==2){
                ArrayList<Items> items = db.getAllItems();
                for (Items i : items) {
                    System.out.println(i);
                }
            }else if(choice==3){
                System.out.println("Insert ID: ");
                Long id = in.nextLong();
                db.deleteItem(id);
            }else{
                System.exit(0);
            }
        }
    }
}
