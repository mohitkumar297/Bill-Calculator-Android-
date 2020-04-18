package com.example.c0777180_w2020_mad3125_fp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.c0777180_w2020_mad3125_fp.Activities.AddNewBillActivity;
import com.example.c0777180_w2020_mad3125_fp.Activities.ShowBillDetailsActivity;
import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
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
    @InjectView(R.id.hydroSave)
    Button hydroSave;


    public HydroFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hydro_fragment, container, false);
        ButterKnife.inject(this, view);
        final Intent i = getActivity().getIntent();
        final Customer customer = i.getParcelableExtra("CurrentCustomer");


        hydroSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double bill = Double.parseDouble(hydroBillAmount.getText().toString());
                Integer units = Integer.parseInt(hydroUnitsConsumed.getText().toString());

                Hydro hydro = new Hydro(hydroID.getText().toString(), hydroBillDate.getText().toString(), Bill.BillType.Hydro, bill, hydroAgencyName.getText().toString(), units);
                customer.addBilltoCustomer(hydro);

                Log.i("MOHIT"+ customer.getCustomerBills().size()+":/<>MOHIT","size is here");
                Intent intent = new Intent();
                getActivity().setResult(getActivity().RESULT_OK,intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
