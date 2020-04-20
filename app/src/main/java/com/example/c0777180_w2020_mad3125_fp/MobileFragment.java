package com.example.c0777180_w2020_mad3125_fp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.Models.Mobile;
import com.example.c0777180_w2020_mad3125_fp.Util.DataFormatting;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MobileFragment extends Fragment {
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    View view;
    @InjectView(R.id.mobileID)
    TextInputEditText mobileID;
    @InjectView(R.id.mobileBillDate)
    TextInputEditText mobileBillDate;
    @InjectView(R.id.mobileManufacturer)
    TextInputEditText mobileManufacturer;
    @InjectView(R.id.mobileMobile)
    TextInputEditText mobileMobile;
    @InjectView(R.id.mobileInternet)
    TextInputEditText mobileInternet;
    @InjectView(R.id.mobileMinutes)
    TextInputEditText mobileMinutes;
    @InjectView(R.id.mobilePlan)
    TextInputEditText mobilePlan;
    @InjectView(R.id.mobileBillAmount)
    TextInputEditText mobileBillAmount;
    @InjectView(R.id.mobileSave)
    Button mobileSave;

    AlertDialog.Builder builder;
    @InjectView(R.id.mobileinputLayout)
    TextInputLayout mobileinputLayout;
    @InjectView(R.id.mobilelength)
    TextInputLayout mobilelength;

    public MobileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.mobile_fragment, container, false);
        ButterKnife.inject(this, view);
        builder = new AlertDialog.Builder(getActivity());
        final Intent i = getActivity().getIntent();
        final Customer customer = i.getParcelableExtra("CurrentCustomer");

        mobileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mobileID.getText().toString();
                String date = mobileBillDate.getText().toString();
                String manufacturer = mobileManufacturer.getText().toString();
                String plan = mobilePlan.getText().toString();
                String mob = mobileMobile.getText().toString();


                if (id.isEmpty() || date.isEmpty() || manufacturer.isEmpty() || plan.isEmpty() || mob.isEmpty() || mobileBillAmount.getText().toString().isEmpty() || mobileInternet.getText().toString().isEmpty() || mobileMinutes.getText().toString().isEmpty()) {
                    builder.setMessage("INCOMPLETE FORM")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("ERROR");
                    alert.show();
                    alert.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                } else if (!mobileID.getText().toString().contains("MOB")) {
                    mobileinputLayout.setError("MUST START WITH MOB");
                }

                else if (!DataFormatting.mobileValidate(mobileMobile.getText().toString())){
                    mobilelength.setError("Invalid Mobile");
                    builder.setMessage("Enter Valid Mobile Number")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("ERROR");
                    alert.show();
                    alert.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                }
                else{
                    Double bill = Double.parseDouble(mobileBillAmount.getText().toString());
                    Integer internetused = Integer.parseInt(mobileInternet.getText().toString());
                    Integer minutes = Integer.parseInt(mobileMinutes.getText().toString());
                    Mobile mobile = new Mobile(id, date, Bill.BillType.Mobile, bill, mob, internetused, minutes, manufacturer, plan);
                    customer.addBilltoCustomer(mobile);

                    Intent intent = new Intent();
                    intent.putExtra("CUSTOMERINFO", customer);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    getActivity().finish();
                }

            }
        });


        mobileBillDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getActivity(), R.style.DialogTheme, datePickerListener, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
            }
        });

        return view;
    }

    DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String format = new SimpleDateFormat("dd-MM-YYYY").format(c.getTime());
            mobileBillDate.setText(format);
        }


    };
}
