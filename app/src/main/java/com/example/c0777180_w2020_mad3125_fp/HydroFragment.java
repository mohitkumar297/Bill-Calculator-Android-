package com.example.c0777180_w2020_mad3125_fp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Hydro;

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


    public HydroFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hydro_fragment, container, false);
        ButterKnife.inject(this, view);

        Double bill = Double.parseDouble(hydroBillAmount.getText().toString());
        Integer units = Integer.parseInt(hydroUnitsConsumed.getText().toString());
        Hydro hydro = new Hydro(hydroID.getText().toString(),hydroBillDate.getText().toString(), Bill.BillType.Hydro,bill,hydroAgencyName.getText().toString(),units);
        return view;
    }
}
