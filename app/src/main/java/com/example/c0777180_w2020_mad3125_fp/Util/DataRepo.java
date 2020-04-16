package com.example.c0777180_w2020_mad3125_fp.Util;

import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.Models.Hydro;
import com.example.c0777180_w2020_mad3125_fp.Models.Mobile;

import java.util.ArrayList;
import java.util.HashMap;

public class DataRepo {
    private static DataRepo instance = new DataRepo();
    private ArrayList<Customer> customerArrayList = new ArrayList<>();
    //private HashMap<String, Bill> customerBills = new HashMap<>();
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
        Hydro H1 = new Hydro("HYD001","12/02/2020", Bill.BillType.Hydro,203.4,"Liquid flow",345);

        Hydro H2 = new Hydro("HYD002","31/03/2020", Bill.BillType.Hydro,53.1,"H2O World",100);

        Hydro H3 = new Hydro("HYD003","12/05/2020", Bill.BillType.Hydro,77.2,"Liquid flow",127);

        Mobile M1 = new Mobile("MOB101","19/04/2020", Bill.BillType.Mobile,98,"6475406638",36,312,"Rogers","Mega Deal");

        Mobile M2 = new Mobile("MOB102","10/04/2020", Bill.BillType.Mobile,54,"8054626109",41,452,"Bell","All Time ");

        Customer C1 = new Customer("C001","Steven","Gerrard","steven@gmail.com","24/08/1998","Male");

        Customer C2 = new Customer("C002","Sadio","Mane","sadiom@yahoo.com","21/01/2000","  Female");

        Customer C3 = new Customer("C003","Jordan","Henderson","jorhen@gmail.com","08/04/1999","Male");

        Customer C4 = new Customer("C004","James","Milner","jamilner@gmail.com","13/08/1981","Male");

        C1.addBilltoCustomer(H1);
        C1.addBilltoCustomer(M1);
        C2.addBilltoCustomer(H2);
        C3.addBilltoCustomer(H3);
        C4.addBilltoCustomer(M2);

//        C4.addBilltoCustomer("HYD001",H1);

        customerArrayList.add(C1);
        customerArrayList.add(C2);
        customerArrayList.add(C3);
        customerArrayList.add(C4);



    }
}
