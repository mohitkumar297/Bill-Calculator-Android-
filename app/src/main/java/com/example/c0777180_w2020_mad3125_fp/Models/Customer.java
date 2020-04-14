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

    public Customer(String customerID, String firstName, String lastName, String emailID, String dateOfBirth, String gender) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public void display() {

    }
}
