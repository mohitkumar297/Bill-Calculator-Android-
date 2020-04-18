package com.example.c0777180_w2020_mad3125_fp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Hydro;
import com.example.c0777180_w2020_mad3125_fp.Models.Internet;
import com.example.c0777180_w2020_mad3125_fp.Models.Mobile;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BillDetailsDisplayActivity extends AppCompatActivity {

    @InjectView(R.id.alltext)
    TextView alltext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_details_display);
        ButterKnife.inject(this);

        Intent intent = getIntent();

        Bill bill = (Bill) intent.getSerializableExtra("BILLSELECT");

        if (bill.getBillID().contains("HYD")){
            Hydro hydro = (Hydro) intent.getSerializableExtra("BILLSELECT");
            alltext.setText(hydro.getUnitsConsumed()+hydro.getBillID());
        }
        else if (bill.getBillID().contains("MOB")){
            Mobile mobile = (Mobile) intent.getSerializableExtra("BILLSELECT");
            alltext.setText(mobile.getInternetUsed()+mobile.getBillID());
        }
        else {
            Internet internet = (Internet) intent.getSerializableExtra("BILLSELECT");
            alltext.setText(internet.getInternetGBUsed()+internet.getBillID());
        }
    }
}
