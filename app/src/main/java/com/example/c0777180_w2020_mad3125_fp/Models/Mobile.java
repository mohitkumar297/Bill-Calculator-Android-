package com.example.c0777180_w2020_mad3125_fp.Models;

public class Mobile extends Bill{

    private String mobileNumber;
    private int internetUsed;
    private int minuteUsed;
    private String manufacturerName;
    private String planName;

    public Mobile(String billID, String billDate, BillType billType, double billAmount, String mobileNumber, int internetUsed, int minuteUsed, String manufacturerName, String planName) {
        super(billID, billDate, billType, billAmount);
        this.mobileNumber = mobileNumber;
        this.internetUsed = internetUsed;
        this.minuteUsed = minuteUsed;
        this.manufacturerName = manufacturerName;
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getInternetUsed() {
        return internetUsed;
    }

    public void setInternetUsed(int internetUsed) {
        this.internetUsed = internetUsed;
    }

    public int getMinuteUsed() {
        return minuteUsed;
    }

    public void setMinuteUsed(int minuteUsed) {
        this.minuteUsed = minuteUsed;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Override
    public void display() {

    }
}
