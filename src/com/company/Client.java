package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;

public class Client {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        ArrayList<GoodItem> goodItems = getGoodItemList();
        ArrayList<BuyHistory> buyHistoryItems = getBuyHistory();
        while (true) {
            System.out.println("PRESS [1] TO LIST GOODS");
            System.out.println("PRESS [2] TO BUY GOOD");
            System.out.println("PRESS [3] TO LIST BUY HISTORY");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();
            if(choice.equals("1")){
                goodItems = getGoodItemList();
                for(GoodItem g : goodItems){
                    System.out.println(g.toString());
                }
            }else if(choice.equals("2")){
                System.out.println("Choose item to buy:");
                goodItems = getGoodItemList();
                for(int i = 0; i<goodItems.size();i++){
                    System.out.println(i+1+" "+goodItems.get(i).toString());
                }
                int choice1= in.nextInt();
                String goodName = goodItems.get(choice1-1).getName();
                int goodPrice = goodItems.get(choice1-1).getPrice();
                buyHistoryItems.add(new BuyHistory(goodName, goodPrice, new Date()));
                saveBuyHistory(buyHistoryItems);
            }else if(choice.equals("3")){
                buyHistoryItems = getBuyHistory();
                for(BuyHistory b : buyHistoryItems){
                    System.out.println(b.toString());
                }
            }else{
                break;
            }
        }
    }

    public static ArrayList<GoodItem> getGoodItemList(){
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

    public static ArrayList<BuyHistory> getBuyHistory(){
        ArrayList<BuyHistory> buyHistoryItems = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("buyHistory.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String goodName = line;
                int goodPrice = Integer.parseInt(br.readLine());
                String strDate = br.readLine();
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy");
                Date buyTime = sdf.parse(strDate);
                buyHistoryItems.add(new BuyHistory(goodName, goodPrice, buyTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buyHistoryItems;
    }

    public static void saveBuyHistory(ArrayList<BuyHistory> buyHistory){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("buyHistory.txt"));
            for (BuyHistory b : buyHistory) {
                bw.write(b.getGoodName() + "\n");
                bw.write(b.getGoodPrice() + "\n");
                bw.write(b.getBuyTime() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
