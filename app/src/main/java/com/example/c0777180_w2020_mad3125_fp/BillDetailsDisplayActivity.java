package com.example.c0777180_w2020_mad3125_fp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
    @InjectView(R.id.billImg)
    ImageView billImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_details_display);
        ButterKnife.inject(this);

        Intent intent = getIntent();

        Bill bill = (Bill) intent.getSerializableExtra("BILLSELECT");

        if (bill.getBillID().contains("HYD")) {
            Hydro hydro = (Hydro) intent.getSerializableExtra("BILLSELECT");
            billImg.setImageResource(R.drawable.icons8water);
            alltext.setText("BILL ID : " + hydro.getBillID().toUpperCase()+"\n\n"+
                            "BILL DATE : "+hydro.getBillDate()+"\n\n"+
                            "BILL TYPE : "+hydro.getBillType()+"\n\n"+
                            "AGENCY NAME : "+hydro.getAgencyName().toUpperCase()+"\n\n"+
                            "UNITS CONSUMED : "+hydro.getUnitsConsumed()+"\n\n"+
                            "TOTAL AMOUNT : $"+hydro.getBillAmount()+"\n\n");
        } else if (bill.getBillID().contains("MOB")) {
            Mobile mobile = (Mobile) intent.getSerializableExtra("BILLSELECT");
            billImg.setImageResource(R.drawable.icons_phone);
            alltext.setText("BILL ID : " + mobile.getBillID().toUpperCase()+"\n\n"+
                            "BILL DATE : "+mobile.getBillDate()+"\n\n"+
                            "BILL TYPE : "+mobile.getBillType()+"\n\n"+
                            "MANUFACTURER NAME : "+mobile.getManufacturerName().toUpperCase()+"\n\n"+
                            "MOBILE NUMBER : "+mobile.getMobileNumber()+"\n\n"+
                            "PLAN NAME : "+mobile.getPlanName().toUpperCase()+"\n\n"+
                            "INTERNET USED : "+mobile.getInternetUsed()+" GB"+"\n\n"+
                            "MINUTES USED : "+mobile.getMinuteUsed()+ " minutes"+"\n\n"+
                            "TOTAL AMOUNT : $"+mobile.getBillAmount()+"\n\n");
        } else {
            Internet internet = (Internet) intent.getSerializableExtra("BILLSELECT");
            billImg.setImageResource(R.drawable.icons8internet);

            alltext.setText("BILL ID : " + internet.getBillID().toUpperCase()+"\n\n"+
                            "BILL DATE : "+internet.getBillDate()+"\n\n"+
                            "BILL TYPE : "+internet.getBillType()+"\n\n"+
                            "PROVIDER NAME : "+internet.getProviderName().toUpperCase()+"\n\n"+
                            "INTERNET USED : "+internet.getInternetGBUsed()+" GB"+"\n\n"+
                            "TOTAL AMOUNT : $"+internet.getBillAmount()+"\n\n");
        }
    }
}
