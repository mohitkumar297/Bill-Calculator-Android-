package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0777180_w2020_mad3125_fp.Adapters.CustomerListAdapter;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;
import com.example.c0777180_w2020_mad3125_fp.Util.DataRepo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CustomerListActivity extends AppCompatActivity {


    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.customerAdd)
    FloatingActionButton customerAdd;

    private CustomerListAdapter customerListAdapter;
    private ArrayList<Customer> customerArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.inject(this);

       customerAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(CustomerListActivity.this,AddNewCustomerActivity.class);
               startActivity(i);
           }
       });

        populateCustomers();
        customerListAdapter = new CustomerListAdapter(customerArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customerListAdapter);

    }

    public void populateCustomers() {
        customerArrayList = new ArrayList<>();
        customerArrayList = DataRepo.getInstance().getAllCustomers();
    }
}
