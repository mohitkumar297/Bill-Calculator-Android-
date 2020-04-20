package com.example.c0777180_w2020_mad3125_fp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.c0777180_w2020_mad3125_fp.Adapters.BillViewAddPagerAdapter;
import com.example.c0777180_w2020_mad3125_fp.HydroFragment;
import com.example.c0777180_w2020_mad3125_fp.InternetFragment;
import com.example.c0777180_w2020_mad3125_fp.MobileFragment;
import com.example.c0777180_w2020_mad3125_fp.R;
import com.google.android.material.tabs.TabLayout;

public class AddNewBillActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);


        BillViewAddPagerAdapter adapter = new BillViewAddPagerAdapter(getSupportFragmentManager(), 0);
        adapter.AddFragment(new MobileFragment(), "MOBILE ");
        adapter.AddFragment(new HydroFragment(), "HYDRO ");
        adapter.AddFragment(new InternetFragment(), "INTERNET ");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}