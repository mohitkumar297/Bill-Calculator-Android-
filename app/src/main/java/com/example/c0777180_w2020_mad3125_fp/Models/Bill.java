package com.example.c0777180_w2020_mad3125_fp.Models;

import java.time.LocalDate;
import java.util.Date;



public abstract class Bill implements IDisplay {

   public enum BillType {
        Mobile,
        Hydro,
        Internet
    }
        private String billID;
        private String billDate;
        private BillType billType;
        private double totalBill;

    public Bill(String billID, String billDate, BillType billType, double totalBill) {
        this.billID = billID;
        this.billDate = billDate;
        this.billType = billType;
        this.totalBill = totalBill;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
