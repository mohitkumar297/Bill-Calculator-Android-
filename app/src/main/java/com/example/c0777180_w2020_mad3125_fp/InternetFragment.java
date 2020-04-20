package com.example.c0777180_w2020_mad3125_fp;

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

import com.example.c0777180_w2020_mad3125_fp.Activities.ShowBillDetailsActivity;
import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.Models.Internet;
import com.example.c0777180_w2020_mad3125_fp.Models.Mobile;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class InternetFragment extends Fragment {
    View view;
    AlertDialog.Builder builder;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    @InjectView(R.id.internetID)
    TextInputEditText internetID;
    @InjectView(R.id.internetBillDate)
    TextInputEditText internetBillDate;
    @InjectView(R.id.internetAgencyName)
    TextInputEditText internetAgencyName;
    @InjectView(R.id.internetUnitsConsumed)
    TextInputEditText internetUnitsConsumed;
    @InjectView(R.id.internetBillAmount)
    TextInputEditText internetBillAmount;
    @InjectView(R.id.internetSave)
    Button internetSave;
    @InjectView(R.id.inputID)
    TextInputLayout inputID;

    public InternetFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.internet_fragment, container, false);
        ButterKnife.inject(this, view);
        builder = new AlertDialog.Builder(getActivity());
        final Intent i = getActivity().getIntent();
        final Customer customer = i.getParcelableExtra("CurrentCustomer");

        internetBillDate.setOnClickListener(new View.OnClickListener() {
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

        internetSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double bill = Double.parseDouble(internetBillAmount.getText().toString());
                Integer internetgb = Integer.parseInt(internetUnitsConsumed.getText().toString());
                if (internetID.getText().toString().isEmpty() || internetBillDate.getText().toString().isEmpty() || internetAgencyName.getText().toString().isEmpty() || internetUnitsConsumed.getText().toString().isEmpty() || internetBillAmount.getText().toString().isEmpty()) {
                    builder.setMessage("INCOMPLETE FORM")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
//

                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("ERROR");
                    alert.show();
                    alert.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                } else if (!internetID.getText().toString().contains("INT")) {
                    inputID.setError("MUST START WITH MOB");
                }
                else {

                    Internet internet = new Internet(internetID.getText().toString(),internetBillDate.getText().toString(), Bill.BillType.Internet,bill,internetAgencyName.getText().toString(),internetgb);
                    customer.addBilltoCustomer(internet);
                    Intent intent = new Intent(getActivity(), ShowBillDetailsActivity.class);
                    intent.putExtra("CUSTOMERINFO",customer);
                    startActivity(intent);
                    getActivity().finish();
                }
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
            internetBillDate.setText(format);
            //FOR AGE DISPLAY txtTaxFilingDate.setText(Integer.toString(calculateAge(c.getTimeInMillis())));
        }


    };
}
