package com.example.c0777180_w2020_mad3125_fp.Models;

import java.time.LocalDate;

public class Hydro extends Bill {

    private String agencyName;
    private int unitsConsumed;

    public Hydro(String billID, LocalDate billDate, BillType billType, double totalBill, String agencyName, Integer unitsConsumed) {
        super(billID, billDate, billType, totalBill);
        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    @Override
    public void display() {

    }
}
