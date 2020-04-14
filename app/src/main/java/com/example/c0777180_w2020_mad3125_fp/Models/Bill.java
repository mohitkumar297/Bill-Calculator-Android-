package com.example.c0777180_w2020_mad3125_fp.Models;

import java.time.LocalDate;
import java.util.Date;



public abstract class Bill {

    enum BillType {
        Mobile,
        Hydro,
        Internet
    }
        private String billID;
        private LocalDate billDate;
        private BillType billType;
        private double totalBill;

    public Bill(String billID, LocalDate billDate, BillType billType, double totalBill) {
        this.billID = billID;
        this.billDate = billDate;
        this.billType = billType;
        this.totalBill = totalBill;
    }

}
