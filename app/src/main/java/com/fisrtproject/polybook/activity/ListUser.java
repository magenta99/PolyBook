package com.fisrtproject.polybook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fisrtproject.polybook.model.User;
import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.adapter.UserAdapter;
import com.fisrtproject.polybook.dao.UserDAO;

import java.util.List;
import java.util.Random;

public class ListUser extends AppCompatActivity {

    private RecyclerView lvList;
    private UserAdapter userAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<User> users;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        userDAO = new UserDAO(this);
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.USER_NAME = "Huy " + i;
//            user.USER_FULL_NAME = "Nguyễn Huy Hoàng " + new Random().nextInt(100);
//            user.USER_PHONE = new Random().nextInt(1000000000) + "";
//            user.USER_PASSWORD = "123456";
//            userDAO.insertUser(user);
//        }

        lvList = findViewById(R.id.lvList);
        users = userDAO.getAllUsers();
        userAdapter = new UserAdapter(this, users);
        linearLayoutManager = new LinearLayoutManager(this);
        lvList.setLayoutManager(linearLayoutManager);
        lvList.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh Sách Người Dùng");


    }
}
