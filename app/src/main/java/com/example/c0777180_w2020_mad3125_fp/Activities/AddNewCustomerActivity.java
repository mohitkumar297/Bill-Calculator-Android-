package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;
import com.example.c0777180_w2020_mad3125_fp.Util.DataRepo;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewCustomerActivity extends AppCompatActivity {

    @InjectView(R.id.id)
    EditText id;
    @InjectView(R.id.fname)
    EditText fname;
    @InjectView(R.id.lname)
    EditText lname;
    
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer customer = new Customer(id.getText().toString(),fname.getText().toString(),lname.getText().toString(),gender.getText().toString(),email.getText().toString(),dob.getText().toString());
                DataRepo.getInstance().getAllCustomers().add(customer);
               // Intent mIntent = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
                Intent mIntent = new Intent();
               // mIntent.putExtra("CustomerBills", customer);
                setResult(RESULT_OK,mIntent);
                finish();
            }
        });
    }
}
