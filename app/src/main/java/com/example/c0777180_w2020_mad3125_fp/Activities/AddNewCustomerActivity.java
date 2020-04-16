package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0777180_w2020_mad3125_fp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewCustomerActivity extends AppCompatActivity {

    @InjectView(R.id.id)
    EditText id;
    @InjectView(R.id.fname)
    EditText fname;
    @InjectView(R.id.lname)
    EditText lname;
    @InjectView(R.id.gender)
    EditText gender;
    @InjectView(R.id.email)
    EditText email;
    @InjectView(R.id.dob)
    EditText dob;
    @InjectView(R.id.submit)
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        ButterKnife.inject(this);

    }
}
