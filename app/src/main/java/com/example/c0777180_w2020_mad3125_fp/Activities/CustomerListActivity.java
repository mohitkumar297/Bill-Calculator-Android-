package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
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
    @InjectView(R.id.logoutFloat)
    FloatingActionButton logoutFloat;

    private CustomerListAdapter customerListAdapter;
    private ArrayList<Customer> customerArrayList;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.inject(this);
        builder = new AlertDialog.Builder(this);
        customerAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomerListActivity.this, AddNewCustomerActivity.class);
                startActivity(i);
            }
        });

        logoutFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("Are you sure you want to End Session?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent mIntent = new Intent(CustomerListActivity.this,LoginActivity.class);
                                startActivity(mIntent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("LOGOUT");
                alert.show();
                alert.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                alert.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });

        populateCustomers();
        customerListAdapter = new CustomerListAdapter(customerArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customerListAdapter);
        customerListAdapter.setOnItemClickListener(new CustomerListAdapter.OnItemClickListener() {
            @Override
            public void OnItemDelete(int position) {
                removeItem(position);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        customerListAdapter.notifyDataSetChanged();
    }

    public void removeItem(int position) {
        customerArrayList.remove(position);
        customerListAdapter.notifyItemRemoved(position);
    }

    public void populateCustomers() {
        customerArrayList = new ArrayList<>();
        customerArrayList = DataRepo.getInstance().getAllCustomers();
    }
}
