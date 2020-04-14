package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0777180_w2020_mad3125_fp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CustomerListActivity extends AppCompatActivity {


    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.inject(this);

    }
}
