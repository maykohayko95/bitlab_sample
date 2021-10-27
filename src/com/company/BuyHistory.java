package com.company;

import java.util.Date;

public class BuyHistory {
    String goodName;
    int goodPrice;
    Date buyTime;

    public BuyHistory() {

    }

    public BuyHistory(String goodName, int goodPrice, Date buyTime) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.buyTime = buyTime;
    }

    public BuyHistory(String goodName, int goodPrice) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(int goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public String toString() {
        return "BuyHistory{" +
                "goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", buyTime=" + buyTime +
                '}';
    }
}
