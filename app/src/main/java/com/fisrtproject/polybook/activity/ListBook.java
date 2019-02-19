package com.fisrtproject.polybook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.adapter.BookAdapter;
import com.fisrtproject.polybook.dao.BookDAO;
import com.fisrtproject.polybook.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListBook extends AppCompatActivity {
    private LinearLayoutManager linearLayoutManager;
    private BookAdapter bookAdapter;
    private List<Book> books;
    private Book book;
    private BookDAO bookDAO;
    private RecyclerView lvBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        bookDAO = new BookDAO(this);
        books = new ArrayList<>();

//        for (int i = 0;i<10;i++){
//            Book book = new Book();
//            book.BOOK_TEN_SACH = "Đắc Nhân Tâm";
//            book.BOOK_SO_LUONG = new Random().nextInt(10) + "";
//            bookDAO.insertBook(book);
//
//        }

        lvBook = findViewById(R.id.lvBook);
        books = bookDAO.getAllBooks();
        bookAdapter = new BookAdapter(this,books);
        linearLayoutManager = new LinearLayoutManager(this);
        lvBook.setAdapter(bookAdapter);
        bookAdapter.notifyDataSetChanged();
        lvBook.setLayoutManager(linearLayoutManager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh Sách Cuốn Sách");
    }
}
