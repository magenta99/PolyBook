package com.fisrtproject.polybook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.adapter.CategoryAdapter;
import com.fisrtproject.polybook.dao.CategoryDAO;
import com.fisrtproject.polybook.database.Database;
import com.fisrtproject.polybook.model.Category;

import java.util.List;
import java.util.Random;

public class ListCategory extends AppCompatActivity {
    private RecyclerView lvCategory;
    private List<Category> categoryList;
    private Database database;
    private CategoryAdapter categoryAdapter;
    private LinearLayoutManager linearLayoutManager;
    private CategoryDAO categoryDAO;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);

        categoryDAO = new CategoryDAO(this);
//        for (int i = 0; i < 10; i++) {
//            Category category = new Category();
//            category.CATEGORY_TEN_THE_LOAI = "Công nghệ thông tin";
//            category.CATEGORY_MA_THE_LOAI = "TL" + new Random().nextInt(10);
//            categoryDAO.insertCategory(category);
//        }



        lvCategory = findViewById(R.id.lvCategory);
        categoryList = categoryDAO.getAllCategorys();
        categoryAdapter = new CategoryAdapter(this,categoryList);
        linearLayoutManager = new LinearLayoutManager(this);
        lvCategory.setLayoutManager(linearLayoutManager);
        lvCategory.setAdapter(categoryAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh Sách Thể Loại Sách");
    }
}
