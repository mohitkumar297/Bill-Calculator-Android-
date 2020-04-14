package com.example.c0777180_w2020_mad3125_fp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;

import java.util.ArrayList;
import java.util.List;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.CustomerListViewHolder> {

    ArrayList<Customer> customerArrayList;

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
    public void onBindViewHolder(@NonNull CustomerListViewHolder holder, int position) {
        Customer customer = this.customerArrayList.get(position);
        holder.customerName.setText(customer.getFirstName()+" "+customer.getLastName());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomerListViewHolder extends RecyclerView.ViewHolder{

        TextView customerName;
        public CustomerListViewHolder(@NonNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.customerName);
        }
    }
}
