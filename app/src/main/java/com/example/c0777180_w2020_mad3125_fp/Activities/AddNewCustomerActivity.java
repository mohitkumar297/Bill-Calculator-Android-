package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;
import com.example.c0777180_w2020_mad3125_fp.Util.DataRepo;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewCustomerActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    @InjectView(R.id.submit)
    Button submit;
    @InjectView(R.id.radioMale)
    RadioButton radioMale;
    @InjectView(R.id.radioFemale)
    RadioButton radioFemale;
    @InjectView(R.id.radioOther)
    RadioButton radioOther;
    @InjectView(R.id.radio)
    RadioGroup radio;

    String checkedBox = "";

    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    @InjectView(R.id.id)
    TextInputEditText id;
    @InjectView(R.id.fname)
    TextInputEditText fname;
    @InjectView(R.id.lname)
    TextInputEditText lname;
    @InjectView(R.id.email)
    TextInputEditText email;
    @InjectView(R.id.dob)
    TextInputEditText dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        ButterKnife.inject(this);
        builder = new AlertDialog.Builder(this);

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadio = radio.getCheckedRadioButtonId();
                RadioButton checkedRadioButton = findViewById(checkedRadio);
                checkedBox = checkedRadioButton.getText().toString();
            }
        });



        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(AddNewCustomerActivity.this,R.style.DialogTheme, datePickerListener, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id.getText().toString().isEmpty() || fname.getText().toString().isEmpty() || lname.getText().toString().isEmpty() || checkedBox.isEmpty() || email.getText().toString().isEmpty() || dob.getText().toString().isEmpty()){
                    builder.setMessage("INCOMPLETE FORM")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
//                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    //  Action for 'NO' Button
//                                    dialog.cancel();
//
//                                }
//                            });

                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("ERROR");
                    alert.show();
                    alert.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                }

                else{
                Customer customer = new Customer(id.getText().toString(), fname.getText().toString(), lname.getText().toString(), email.getText().toString(), dob.getText().toString(), checkedBox);
                DataRepo.getInstance().getAllCustomers().add(customer);


                Intent mIntent = new Intent();
                setResult(RESULT_OK, mIntent);
                finish();

            }}
        });
    }

    DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String format = new SimpleDateFormat("dd-MM-YYYY").format(c.getTime());
            dob.setText(format);
            //FOR AGE DISPLAY txtTaxFilingDate.setText(Integer.toString(calculateAge(c.getTimeInMillis())));
        }


    };

    public void maleClick(View view) {

        radioMale.setTextColor(Color.WHITE);
        radioFemale.setTextColor(Color.BLACK);
        radioOther.setTextColor(Color.BLACK);
    }

    public void femaleClick(View view) {
        radioFemale.setTextColor(Color.WHITE);
        radioMale.setTextColor(Color.BLACK);
        radioOther.setTextColor(Color.BLACK);
    }

    public void other(View view) {
        radioMale.setTextColor(Color.BLACK);
        radioFemale.setTextColor(Color.BLACK);
        radioOther.setTextColor(Color.WHITE);
    }

}
