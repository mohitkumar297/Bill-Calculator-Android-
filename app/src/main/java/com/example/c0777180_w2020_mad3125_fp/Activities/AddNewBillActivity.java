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
    // private AppBarLayout appBarLayout;
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

//        Intent mIntent = getIntent();
//        Customer customer = (Customer) mIntent.getParcelableExtra("CurrentCustomer");
//
//        Bundle bundle = new Bundle();
//
//        if(customer == null){
//            Toast.makeText(this,"nonononooooo",Toast.LENGTH_SHORT).show();
//            Log.i("asdfghjkl", "nonononononononoon");
//        }
//        else{
//            Log.i("asdfghjkl", "yessssssssssss");
//        }
//        bundle.putParcelable("Current",customer);
//
//        if(bundle == null){
//            Toast.makeText(this,"nonononooooo",Toast.LENGTH_SHORT).show();
//            Log.i("zxcvbnm", "nonononononononoon");
//        }
//        else{
//            Log.i("zxcvbnm", "yessssssssssss");
//        }
//        HydroFragment hydroFragment = new HydroFragment();
////        getSupportFragmentManager().beginTransaction().replace(R.id.viewPager,hydroFragment).commit();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//
//
//        hydroFragment.setArguments(bundle);
//        transaction.add(R.id.viewPager,hydroFragment);
//        transaction.commit();

       // Intent i = getIntent();
        //Hydro hydro = i.getParcelableExtra("hy");

//          Intent mIntent = getIntent();
//          Customer customer = (Customer) mIntent.getParcelableExtra("CurrentCustomer");
          //customer.addBilltoCustomer(hydro);

    }
}