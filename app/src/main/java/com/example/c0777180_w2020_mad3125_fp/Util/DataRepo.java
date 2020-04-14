package com.example.c0777180_w2020_mad3125_fp.Util;

import com.example.c0777180_w2020_mad3125_fp.Models.Customer;

public class DataRepo {
    private static DataRepo instance = new DataRepo();

    private DataRepo() {
    }
    public static DataRepo getInstance(){
        return instance;
    }

    public void populateCustomers(){
        Customer C1 = new Customer("C001","Mohit","Kumar","mohit@gmail.com","10/05/1995","Male");
        
    }
}
