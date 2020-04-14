package com.example.c0777180_w2020_mad3125_fp.Models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Customer implements IDisplay {

    private String customerID;
    private String firstName;
    private String lastName;
    private String emailID;
    HashMap<String, Bill> customerBills = new HashMap<String, Bill>();
    private String dateOfBirth;
    private String gender;


    @Override
    public void display() {

    }
}
