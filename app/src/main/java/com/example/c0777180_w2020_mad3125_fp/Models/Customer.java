package com.example.c0777180_w2020_mad3125_fp.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Customer implements IDisplay, Parcelable {

    private String customerID;
    private String firstName;
    private String lastName;
    private String emailID;
    private String dateOfBirth;
    private String gender;
    private Double totalBill;
   public ArrayList<Bill> customerBills = new ArrayList<Bill>();
   //private HashMap<String, Bill> customerBills = new HashMap<String, Bill>();

    public Customer(String customerID, String firstName, String lastName, String emailID, String dateOfBirth, String gender) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
       // this.customerBills =
        this.totalBill = calculateBill();
    }



    protected Customer(Parcel in) {
        customerID = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        emailID = in.readString();
        dateOfBirth = in.readString();
        gender = in.readString();
        totalBill = in.readDouble();
        //customerBills = in.readHashMap(Bill.class.getClassLoader());
        customerBills = in.readArrayList(Bill.class.getClassLoader());
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

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



//    public void addBilltoCustomer(String billId, Bill bill)
//    {
//        this.customerBills.put(billId, bill);
//    }

    public void addBilltoCustomer(Bill bill)
    {
        this.customerBills.add(bill);
    }

//    public HashMap<String, Bill> getCustomerBills() {
//        return customerBills;
//    }
//
//    public void setCustomerBills(HashMap<String, Bill> customerBills) {
//        this.customerBills = customerBills;
//    }

    public ArrayList<Bill> getCustomerBills() {
        return customerBills;
    }

    public void setCustomerBills(ArrayList<Bill> customerBills) {
        this.customerBills = customerBills;
    }


//    public ArrayList<Bill> getBills()
//    {
//        Collection<Bill> v = customerBills.values();
//        ArrayList<Bill> allBills = new ArrayList<>(v);
//        return allBills;
//    }


    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }


    public double calculateBill() {
        double total = 0.0d;
        for (Bill i : customerBills) {
            total = total + i.getBillAmount();
        }
        return total;
    }

    @Override
    public void display() {

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerID);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(emailID);
        dest.writeString(dateOfBirth);
        dest.writeString(gender);
        dest.writeDouble(totalBill);
        //dest.writeMap(customerBills);
        dest.writeList(customerBills);
    }
}
