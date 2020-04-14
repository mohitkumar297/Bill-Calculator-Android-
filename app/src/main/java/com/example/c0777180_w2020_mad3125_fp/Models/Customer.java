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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public HashMap<String, Bill> getCustomerBills() {
        return customerBills;
    }

    public void setCustomerBills(HashMap<String, Bill> customerBills) {
        this.customerBills = customerBills;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void display() {

    }
}
