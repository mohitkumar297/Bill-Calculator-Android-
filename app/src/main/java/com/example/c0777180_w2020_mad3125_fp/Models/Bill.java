package com.example.c0777180_w2020_mad3125_fp.Models;

import android.os.Parcelable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;



public abstract class Bill implements IDisplay , Serializable {

   public enum BillType {
        Mobile,
        Hydro,
        Internet
    }
        private String billID;
        private String billDate;
        private BillType billType;
        public double billAmount=1.0;

    public Bill(String billID, String billDate, BillType billType, double billAmount) {
        this.billID = billID;
        this.billDate = billDate;
        this.billType = billType;
        this.billAmount = billAmount;
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

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}
