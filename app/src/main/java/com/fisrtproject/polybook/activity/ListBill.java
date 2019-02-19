package com.fisrtproject.polybook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.adapter.BillAdapter;
import com.fisrtproject.polybook.dao.BillDAO;
import com.fisrtproject.polybook.model.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListBill extends AppCompatActivity {
    private LinearLayoutManager linearLayoutManager;
    private BillAdapter billAdapter;
    private List<Bill> billList;
    private BillDAO billDAO;

    private Bill bill;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bill);
        billDAO = new BillDAO(this);
        billList = new ArrayList<>();
//        for(int i =0;i<10;i++){
//            bill = new Bill();
//            bill.BILL_DATE = new Random().nextInt(30) + "/" + new Random().nextInt(12) + "/" + new Random().nextInt(2000);
//            bill.BILL_ID = "HD" + new Random().nextInt(10);
//            billDAO.insertBill(bill);
//        }

        linearLayoutManager = new LinearLayoutManager(this);
        billList = billDAO.getAllBills();
        billAdapter = new BillAdapter(this,billList);
        recyclerView = findViewById(R.id.lvBill);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(billAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh Sách Hóa Đơn");
    }
}
