package com.fisrtproject.polybook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.model.Bill;
import com.fisrtproject.polybook.model.BillDetail;

import java.util.List;

public class BillDetailAdapter extends RecyclerView.Adapter<BillDetailAdapter.BillDetailHolder> {
    public Context context;

    public BillDetailAdapter(Context context, List<BillDetail> billDetails) {
        this.context = context;
        this.billDetails = billDetails;
    }

    List<BillDetail> billDetails;


    @NonNull
    @Override
    public BillDetailAdapter.BillDetailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.bill_detail_item,viewGroup,false);
        return new BillDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillDetailAdapter.BillDetailHolder billDetailHolder, int i) {

    }

    @Override
    public int getItemCount() {
        if (billDetails == null) return 0;
        else
            return billDetails.size();
    }

    public class BillDetailHolder extends RecyclerView.ViewHolder {
        private TextView tvMaSach;
        private TextView tvSoLuong;
        private TextView tvGiaBia;
        private TextView tvThanhTien;
        private Button btnDel;

        public BillDetailHolder(@NonNull View itemView) {
            super(itemView);
            btnDel = itemView.findViewById(R.id.btnDel);
            tvMaSach =  itemView.findViewById(R.id.tvMaSach);
            tvSoLuong =  itemView.findViewById(R.id.tvSoLuong);
            tvGiaBia =  itemView.findViewById(R.id.tvGiaBia);
            tvThanhTien = itemView.findViewById(R.id.tvThanhTien);
        }
    }
}
