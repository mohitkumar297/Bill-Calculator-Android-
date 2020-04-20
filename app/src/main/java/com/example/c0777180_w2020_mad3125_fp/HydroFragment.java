package com.example.c0777180_w2020_mad3125_fp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.c0777180_w2020_mad3125_fp.Activities.ShowBillDetailsActivity;
import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.Models.Hydro;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HydroFragment extends Fragment {

    View view;
    @InjectView(R.id.hydroID)
    EditText hydroID;
    @InjectView(R.id.hydroBillDate)
    EditText hydroBillDate;
    @InjectView(R.id.hydroBillAmount)
    EditText hydroBillAmount;
    @InjectView(R.id.hydroAgencyName)
    EditText hydroAgencyName;
    @InjectView(R.id.hydroUnitsConsumed)
    EditText hydroUnitsConsumed;
    @InjectView(R.id.hydroSave)
    Button hydroSave;

    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    AlertDialog.Builder builder;
    @InjectView(R.id.hydroinputID)
    TextInputLayout hydroinputID;

    public HydroFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hydro_fragment, container, false);
        ButterKnife.inject(this, view);
        final Intent i = getActivity().getIntent();
        final Customer customer = i.getParcelableExtra("CurrentCustomer");
        builder = new AlertDialog.Builder(getActivity());


        hydroBillDate.setOnClickListener(new View.OnClickListener() {
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

        hydroSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = hydroID.getText().toString();
                String date = hydroBillDate.getText().toString();
                String agency = hydroAgencyName.getText().toString();



                if (id.isEmpty() || date.isEmpty() || agency.isEmpty() || hydroBillAmount.getText().toString().isEmpty() || hydroUnitsConsumed.getText().toString().isEmpty()) {
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
                }
                else if (!hydroID.getText().toString().contains("HYD")) {
                    hydroinputID.setError("MUST START WITH HYD");
                }
                else{
                    Double bill = Double.parseDouble(hydroBillAmount.getText().toString());
                    Integer units = Integer.parseInt(hydroUnitsConsumed.getText().toString());
                Hydro hydro = new Hydro(hydroID.getText().toString(), hydroBillDate.getText().toString(), Bill.BillType.Hydro, bill, hydroAgencyName.getText().toString(), units);
                customer.addBilltoCustomer(hydro);
                Intent intent = new Intent();
                intent.putExtra("CUSTOMERINFO", customer);
                 getActivity().setResult(Activity.RESULT_OK,intent);
                     getActivity().finish();
            }}
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
            hydroBillDate.setText(format);
        }


    };
}
