package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowBillDetailsActivity extends AppCompatActivity {

    @InjectView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        Customer customer = intent.getParcelableExtra("CUSTOMERINFO");
        textView.setText(customer.getFirstName().toUpperCase()+" "+customer.getEmailID().toUpperCase()+" "+ customer.getDateOfBirth());

    }

}
