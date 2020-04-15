package com.example.c0777180_w2020_mad3125_fp.Util;

import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.Models.Hydro;

import java.util.ArrayList;
import java.util.HashMap;

public class DataRepo {
    private static DataRepo instance = new DataRepo();
    private ArrayList<Customer> customerArrayList = new ArrayList<>();
    private HashMap<String, Bill> customerBills = new HashMap<>();
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
        Customer C1 = new Customer("C001","Steven","Gerrard","steven@gmail.com","10/05/1995","Male");

        Customer C2 = new Customer("C002","Sadio","Mane","sadiom@yahoo.com","10/05/1995","Male");

        Customer C3 = new Customer("C003","Jordan","Henderson","jorhen@gmail.com","10/05/1995","Male");

        Customer C4 = new Customer("C004","James","Milner","jamilner@gmail.com","10/05/1995","Male");

        Hydro H1 = new Hydro("HYD001","12/05/2020", Bill.BillType.Hydro,203.4,"Liquid flow",345);

        customerArrayList.add(C1);
        C1.addBill(H1);
        customerArrayList.add(C2);
        customerArrayList.add(C3);
        customerArrayList.add(C4);



    }
}
