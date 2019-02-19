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

import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillHolder> {
    public Context context;

    public BillAdapter(Context context, List<Bill> billList) {
        this.context = context;
        this.billList = billList;
    }

    List<Bill> billList;

    @NonNull
    @Override
    public BillHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.bill_item,viewGroup,false);
        return new BillHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillHolder billHolder, int i) {
            billHolder.bill = billList.get(i);
            billHolder.tvMaHoaDon.setText(billHolder.bill.BILL_ID);
            billHolder.tvNgayMua.setText(billHolder.bill.BILL_DATE);
    }

    @Override
    public int getItemCount() {
        if(billList == null)return 0;
        else
        return billList.size();
    }

    class BillHolder extends RecyclerView.ViewHolder {
        private Bill bill;
        private TextView tvMaHoaDon;
        private TextView tvNgayMua;
        private Button btnDelBook;
        public BillHolder(@NonNull View itemView) {
            super(itemView);
            tvMaHoaDon = (TextView) itemView.findViewById(R.id.tvMaHoaDon);
            tvNgayMua = (TextView) itemView.findViewById(R.id.tvNgayMua);
            btnDelBook = (Button) itemView.findViewById(R.id.btnDelBook);

        }
    }
}
