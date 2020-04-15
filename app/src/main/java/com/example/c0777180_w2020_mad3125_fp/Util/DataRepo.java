package com.example.c0777180_w2020_mad3125_fp.Util;

import com.example.c0777180_w2020_mad3125_fp.Models.Customer;

import java.util.ArrayList;

public class DataRepo {
    private static DataRepo instance = new DataRepo();
    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    private DataRepo() {
        loadData();
    }
    public static DataRepo getInstance(){
        return instance;
    }

    public ArrayList<Customer> getAllCustomers(){
        return this.customerArrayList;
    }

    public void loadData(){
        Customer C1 = new Customer("C001","Mohit","Kumar","mohit@gmail.com","10/05/1995","Male");
        customerArrayList.add(C1);
    }
}
