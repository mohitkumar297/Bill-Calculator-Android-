package com.example.c0777180_w2020_mad3125_fp.Models;

import java.time.LocalDate;

public class Hydro extends Bill {

    private String agencyName;
    private int unitsConsumed;

    public Hydro(String billID, LocalDate billDate, BillType billType, double totalBill, ) {
        super(billID, billDate, billType, totalBill);
    }


//    public Hydro(String billId, LocalDate billDate, BillType billType, Double totalBill, String agencyName,)
}
