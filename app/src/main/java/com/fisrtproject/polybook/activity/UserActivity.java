package com.fisrtproject.polybook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.activity.ListUser;
import com.fisrtproject.polybook.base.BaseActivity;
import com.fisrtproject.polybook.dao.UserDAO;
import com.fisrtproject.polybook.model.User;

public class UserActivity extends BaseActivity {
    private EditText edtUser;
    private EditText edtPassword;
    private EditText edtRepassword;
    private EditText edtSDT;
    private EditText edtHoTen;
    private Button btnAddUser;
    private Button btnCancelUser;
    private Button btnShowUser;
    private UserDAO userDAO;
    private Button btnDelUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        userDAO = new UserDAO(this);

        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtRepassword = (EditText) findViewById(R.id.edtRepassword);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
        edtHoTen = (EditText) findViewById(R.id.edtHoTen);
        btnAddUser = (Button) findViewById(R.id.btnAddUser);
        btnCancelUser = (Button) findViewById(R.id.btnCancelUser);
        btnShowUser = (Button) findViewById(R.id.btnShowUser);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thêm Người Dùng");
        btnShowUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(ListUser.class);
            }
        });

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        btnCancelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllEdt();
            }
        });
    }

    private void validate() {
        try {
            String user = edtUser.getText().toString();
            String password = edtPassword.getText().toString();
            String repassword = edtRepassword.getText().toString();
            String hoten = edtHoTen.getText().toString();
            String sdt = edtSDT.getText().toString();

            if (user.isEmpty()) {
                showMessage("Vui lòng nhập tên đăng nhập");
            } else if (password.length() < 8) {
                showMessage("Mật khẩu phải trên 8 ký tự");
            } else if (!repassword.equals(password)) {
                showMessage("Mật khẩu không trùng");
            } else if (sdt.length() < 10) {
                showMessage("Số điện thoại phải có 10 ký tự");
            } else if (hoten.isEmpty()) {
                showMessage("Vui lòng nhập họ tên");
            } else if (userDAO.insertUser(new User(user, password, sdt, hoten)) > 0) {
                clearAllEdt();
                showMessage("Thêm người dùng thành công");
            } else if (userDAO.insertUser(new User(user, password, sdt, hoten)) <= 0) {
                showMessage("Thêm người dùng thất bại");
            }
        } catch (NumberFormatException e) {
            showMessage("Vui lòng nhập SĐT là số");
        }
    }

    private void clearAllEdt() {
        edtUser.setText("");
        edtRepassword.setText("");
        edtPassword.setText("");
        edtHoTen.setText("");
        edtSDT.setText("");
    }
}
