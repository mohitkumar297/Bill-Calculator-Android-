package com.example.c0777180_w2020_mad3125_fp.Models;

import java.time.LocalDate;
import java.util.Date;

enum BillType {
    Mobile,
    Hydro,
    Internet
}

public abstract class Bill {
        private String billID;
        private LocalDate billDate;
        private BillType billType;
        private double totalBill;

}
