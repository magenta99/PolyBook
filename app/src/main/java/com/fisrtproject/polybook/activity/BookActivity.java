package com.fisrtproject.polybook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.base.BaseActivity;
import com.fisrtproject.polybook.dao.BookDAO;
import com.fisrtproject.polybook.dao.CategoryDAO;
import com.fisrtproject.polybook.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends BaseActivity {
    private EditText edtMaSach;
    private Spinner spnLoaiSach;
    private EditText edtTenSach;
    private EditText edtTacGia;
    private EditText edtDơnGia;
    private EditText edtSoLuong;
    private EditText edtNhaXuatBan;
    private Button btnAddBook;
    private ArrayAdapter<String> spAdapter;
    private List<String> spList;
    private CategoryDAO categoryDAO;
    private Button btnCancelBook;
    private Button btnShowBook;
    private BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thêm Sách");
        btnAddBook = findViewById(R.id.btnAdđBook);
        btnShowBook = findViewById(R.id.btnShowBook);
        btnCancelBook = findViewById(R.id.btnCancelBook);
        edtMaSach = (EditText) findViewById(R.id.edtMaSach);
        edtNhaXuatBan = (EditText) findViewById(R.id.edtNhaXuatBan);
        spnLoaiSach = (Spinner) findViewById(R.id.spnLoaiSach);
        edtTenSach = (EditText) findViewById(R.id.edtTenSach);
        edtTacGia = (EditText) findViewById(R.id.edtTacGia);
        edtDơnGia = (EditText) findViewById(R.id.edtDơnGia);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);
        bookDAO = new BookDAO(this);
        categoryDAO = new CategoryDAO(this);
        spList = new ArrayList<>();
        spList = categoryDAO.getCategoryID();
        spAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spList);
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnLoaiSach.setAdapter(spAdapter);

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        btnShowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(ListBook.class);
            }
        });

        btnCancelBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllEdt();
            }
        });
    }

    private void clearAllEdt() {
        edtMaSach.setText("");
        edtTacGia.setText("");
        edtTenSach.setText("");
        edtNhaXuatBan.setText("");
        edtSoLuong.setText("");
        edtDơnGia.setText("");

    }

    public void validate() {
        try {
            String masach = edtMaSach.getText().toString();
            String tensach = edtTenSach.getText().toString();
            String tacgia = edtTacGia.getText().toString();
            String nxb = edtNhaXuatBan.getText().toString();
            String matheloai = spList.get(spnLoaiSach.getSelectedItemPosition());
            int soluong = Integer.parseInt(edtSoLuong.getText().toString());
            int dongia = Integer.parseInt(edtDơnGia.getText().toString());

            if (masach.isEmpty()) {
                showMessage("Vui lòng nhập mã sách");
            } else if (tensach.isEmpty()) {
                showMessage("Vui lòng nhập tên sách");
            } else if (tacgia.isEmpty()) {
                showMessage("Vui lòng nhập tên tác giả");
            } else if (soluong < 0) {
                showMessage("Số lượng phải lớn hơn 0");
            } else if (dongia < 0) {
                showMessage("Đơn giá phải lớn hơn 0");
            } else if (bookDAO.insertBook(new Book(masach, matheloai, tacgia, nxb, dongia, soluong, tensach)) > 0) {
                clearAllEdt();
                showMessage("Thêm thành công");
            } else if (bookDAO.insertBook(new Book(masach, matheloai, tacgia, nxb, dongia, soluong, tensach)) <= 0) {
                showMessage("Thêm sách thất bại");
            }
        } catch (NumberFormatException e) {
            showMessage("Số lượng và đơn giá phải nhập số");
        } catch (ArrayIndexOutOfBoundsException e1) {
            showMessage("Vui lòng chọn mã thể loại");
        }
    }
}
