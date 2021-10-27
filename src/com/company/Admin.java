package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<GoodItem> goodItems = getGoodItemList();
        while (true) {
            System.out.println("PRESS [1] TO ADD GOOD");
            System.out.println("PRESS [2] TO LIST GOODS");
            System.out.println("PRESS [3] TO DELETE GOODS");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();
            if (choice.equals("1")) {
                System.out.println("Insert Name of Item");
                String name = in.next();

                System.out.println("Insert Price of Item");
                int price = in.nextInt();
                goodItems = getGoodItemList();
                goodItems.add(new GoodItem(name,price));
                saveGoodItems(goodItems);
            }else if(choice.equals("2")){
                goodItems = getGoodItemList();
                for(GoodItem g : goodItems){
                    System.out.println(g.toString());
                }
            }else if(choice.equals("3")){
                System.out.println("Choose item to delete:");
                goodItems = getGoodItemList();
                for(int i = 0; i<goodItems.size();i++){
                    System.out.println(i+1+" "+goodItems.get(i).toString());
                }
                int choiceDelete = in.nextInt();
                goodItems.remove(choiceDelete-1);
                saveGoodItems(goodItems);
            }else{
                break;
            }
        }
    }

    public static void saveGoodItems(ArrayList<GoodItem> goodItems) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("goodItems.txt"));
            for (GoodItem g : goodItems) {
                bw.write(g.getName() + "\n");
                bw.write(g.getPrice() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<GoodItem> getGoodItemList() {
        ArrayList<GoodItem> goodItems = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("goodItems.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String name = line;
                int price = Integer.parseInt(br.readLine());
                goodItems.add(new GoodItem(name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodItems;
    }
}

