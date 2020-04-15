package com.example.c0777180_w2020_mad3125_fp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0777180_w2020_mad3125_fp.Activities.ShowBillDetailsActivity;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;
import com.example.c0777180_w2020_mad3125_fp.Util.DataRepo;

import java.util.ArrayList;
import java.util.List;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.CustomerListViewHolder> {

    private ArrayList<Customer> customerArrayList;

    public CustomerListAdapter(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_list_items,parent,false);
         CustomerListViewHolder customerListViewHolder = new CustomerListViewHolder(view);
        return customerListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerListViewHolder holder, int position) {

        final Customer customer = customerArrayList.get(position);
        holder.customerName.setText(customer.getFirstName()+" "+customer.getLastName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
                i.putExtra("CUSTOMERINFO",customer);
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customerArrayList.size();
    }

    public class CustomerListViewHolder extends RecyclerView.ViewHolder{

        TextView customerName;
        public CustomerListViewHolder(@NonNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.customerName);
        }
    }
}
