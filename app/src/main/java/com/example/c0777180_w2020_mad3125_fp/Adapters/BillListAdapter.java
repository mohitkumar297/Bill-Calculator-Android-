package com.example.c0777180_w2020_mad3125_fp.Adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0777180_w2020_mad3125_fp.Models.Bill;
import com.example.c0777180_w2020_mad3125_fp.Models.Customer;
import com.example.c0777180_w2020_mad3125_fp.R;

import java.util.ArrayList;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillListViewHolder> {

    private ArrayList<Bill> billArrayList;

    public BillListAdapter(ArrayList<Bill> billArrayList) {
        this.billArrayList = billArrayList;
    }

    @NonNull
    @Override
    public BillListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_list_items,parent,false);
        BillListViewHolder billListViewHolder = new BillListViewHolder(v);
        return billListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillListViewHolder holder, int position) {
        Bill bill = billArrayList.get(position);
        holder.imgBill.setImageResource(R.drawable.ic_launcher_background);
        holder.txtDetail.setText(bill.getBillID()+"\n"+bill.getBillAmount()+"\n"+bill.getBillType());
    }

    @Override
    public int getItemCount() {
        return billArrayList.size();
    }

    public class BillListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBill;
        TextView txtDetail;
        TextView txt2;
        public BillListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBill = itemView.findViewById(R.id.img);
            txtDetail = itemView.findViewById(R.id.tv1);
            txt2 = itemView.findViewById(R.id.tv2);
        }
    }
}
