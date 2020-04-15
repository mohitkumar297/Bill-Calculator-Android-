package com.example.c0777180_w2020_mad3125_fp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Customer implements IDisplay, Parcelable {

    private String customerID;
    private String firstName;
    private String lastName;
    private String emailID;
    private HashMap<String, Bill> customerBills = new HashMap<String, Bill>();
    private String dateOfBirth;
    private String gender;

    public Customer(String customerID, String firstName, String lastName, String emailID, String dateOfBirth, String gender) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.customerBills = getCustomerBills();
    }

    protected Customer(Parcel in) {
        customerID = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        emailID = in.readString();
        dateOfBirth = in.readString();
        gender = in.readString();
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
    }
}
