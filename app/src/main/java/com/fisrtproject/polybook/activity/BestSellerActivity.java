package com.fisrtproject.polybook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fisrtproject.polybook.R;

public class BestSellerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_seller);
        getSupportActionBar().setTitle("Top Sách Bán Chạy");
    }
}
