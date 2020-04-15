package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0777180_w2020_mad3125_fp.Adapters.CustomerListAdapter;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;
import com.example.c0777180_w2020_mad3125_fp.Util.DataRepo;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CustomerListActivity extends AppCompatActivity {


    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CustomerListAdapter customerListAdapter;
    private ArrayList<Customer> customerArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.inject(this);

        populateCustomers();
        customerListAdapter = new CustomerListAdapter(customerArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customerListAdapter);
    }

    public void populateCustomers(){
        customerArrayList = new ArrayList<>();
        customerArrayList = DataRepo.getInstance().getAllCustomers();
    }
}
