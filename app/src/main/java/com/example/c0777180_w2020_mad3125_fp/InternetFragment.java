package com.example.c0777180_w2020_mad3125_fp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class InternetFragment extends Fragment {
    View view;
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

    public InternetFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.internet_fragment, container, false);
        ButterKnife.inject(this, view);


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
