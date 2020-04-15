package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowBillDetailsActivity extends AppCompatActivity {


    

    private ArrayList bills;
//    private ArrayList<Bill> Bills;
//    private ArrayList<Bill> internetBill;
//    private ArrayList<Bill> hydroBill;
//    private ArrayList<Bill> mobileBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        Customer customer = (Customer) intent.getParcelableExtra("CUSTOMERINFO");

        bills = customer.getCustomerBills();

        customerDetail.setText(customer.getFirstName()+" "+customer.getLastName()+"\n"+customer.getEmailID()+"\n"+customer.getGender());
//        textView.setText(""+bills.size());
//
//
//        for (Bill i : customer.getCustomerBills()){
//            textView.setText(customer.getFirstName().toUpperCase() + "          " + customer.calculateBill() + " ");
//            //textView.setText(i.getBillID()+"   "+i.billAmount+"   "+i.getBillType()+""+customer.getLastName());
//        }
    }
}
