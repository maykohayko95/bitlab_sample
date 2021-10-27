package com.company;

public class GoodItem {
    String name;
    int price;

    public GoodItem() {
        this.name = "name";
        this.price = 0;
    }

    public GoodItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
