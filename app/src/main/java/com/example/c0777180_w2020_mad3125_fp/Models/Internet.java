package com.example.c0777180_w2020_mad3125_fp.Models;

public class Internet extends Bill {
    private String providerName;
    private int internetGBUsed;

    public Internet(String billID, String billDate, BillType billType, double billAmount, String providerName, int internetGBUsed) {
        super(billID, billDate, billType, billAmount);
        this.providerName = providerName;
        this.internetGBUsed = internetGBUsed;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getInternetGBUsed() {
        return internetGBUsed;
    }

    public void setInternetGBUsed(int internetGBUsed) {
        this.internetGBUsed = internetGBUsed;
    }

    @Override
    public void display() {

    }
}
