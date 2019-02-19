package com.fisrtproject.polybook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.base.BaseActivity;
import com.fisrtproject.polybook.database.Database;

public class HomeActivity extends BaseActivity {
    private Button btnUser;
    private Button btnCategory;
    private Button btnBook;
    private Button btnReceipt;
    private Button btnBestSeller;
    private Button btnStatistic;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new Database(this);
        btnUser = (Button) findViewById(R.id.btnUser);
        btnCategory = (Button) findViewById(R.id.btnCategory);
        btnBook = (Button) findViewById(R.id.btnBook);
        btnReceipt = (Button) findViewById(R.id.btnReceipt);
        btnBestSeller = (Button) findViewById(R.id.btnBestSeller);
        btnStatistic = (Button) findViewById(R.id.btnStatistic);


        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(UserActivity.class);
            }
        });

        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(CategoryActivity.class);
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(BookActivity.class);
            }
        });

        btnBestSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(BestSellerActivity.class);
            }
        });

        btnStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(StatisticActivity.class);
            }
        });

        btnReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(BillActivity.class);
            }
        });
    }
}
