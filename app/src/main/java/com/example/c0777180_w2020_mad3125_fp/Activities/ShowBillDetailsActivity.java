package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0777180_w2020_mad3125_fp.Adapters.BillListAdapter;
import com.example.c0777180_w2020_mad3125_fp.Adapters.CustomerListAdapter;
import com.example.c0777180_w2020_mad3125_fp.HydroFragment;
import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowBillDetailsActivity extends AppCompatActivity {


    @InjectView(R.id.customerID)
    TextView customerID;
    @InjectView(R.id.customerFullName)
    TextView customerFullName;
    @InjectView(R.id.customerEmail)
    TextView customerEmail;
    @InjectView(R.id.customerGender)
    TextView customerGender;
    @InjectView(R.id.customerDateOfBirth)
    TextView customerDateOfBirth;
    @InjectView(R.id.customerTotalBill)
    TextView customerTotalBill;


    @InjectView(R.id.rvBillList)
    RecyclerView rvBillList;
    private BillListAdapter billListAdapter;
    private ArrayList<Bill> billArrayList;


//    private ArrayList<Bill> Bills;
//    private ArrayList<Bill> internetBill;
//    private ArrayList<Bill> hydroBill;
//    private ArrayList<Bill> mobileBill;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent in = new Intent(ShowBillDetailsActivity.this,AddNewBillActivity.class);
                Customer customer = getCustomer();
                in.putExtra("CurrentCustomer",customer);
                startActivityForResult(in,1);
                return true;
            case R.id.item2:
                Toast.makeText(this,"LOGGED OUT",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        ButterKnife.inject(this);
        rvBillList.setHasFixedSize(true);

        Customer customer = getCustomer();


        billArrayList = populateBills();
        customerID.setText(customer.getCustomerID());
        customerFullName.setText(customer.getFirstName() + " " + customer.getLastName());
        customerDateOfBirth.setText(customer.getDateOfBirth());
        customerGender.setText(customer.getGender());
        customerEmail.setText(customer.getEmailID());
        customerTotalBill.setText("" + customer.calculateBill());

        billListAdapter = new BillListAdapter(billArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvBillList.setLayoutManager(layoutManager);
        rvBillList.setAdapter(billListAdapter);

//
//        for (Bill i : customer.getCustomerBills()){
//            textView.setText(customer.getFirstName().toUpperCase() + "          " + customer.calculateBill() + " ");
//            //textView.setText(i.getBillID()+"   "+i.billAmount+"   "+i.getBillType()+""+customer.getLastName());
//        }
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//       // billArrayList.clear();
//        billArrayList.addAll(populateBills());
//        billArrayList = populateBills(); //reload the items from database
//        billListAdapter.notifyDataSetChanged();
//    }

    public Customer getCustomer(){
        Intent intent = getIntent();
        Customer customer = (Customer) intent.getParcelableExtra("CUSTOMERINFO");
        return customer;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == -1) {
            billListAdapter.onActivityResult(requestCode, 1);
        }
    }

    public ArrayList<Bill> populateBills() {
        billArrayList = new ArrayList<>();
        billArrayList = getCustomer().getCustomerBills();
        Log.i(" MOHIT"+ getCustomer().getCustomerBills().size()+":/<>MOHIT","size is here populate");
        return billArrayList;
    }

}
