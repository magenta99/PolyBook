package com.fisrtproject.polybook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fisrtproject.polybook.model.Book;
import com.fisrtproject.polybook.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<com.fisrtproject.polybook.adapter.BookAdapter.BookHolder> {

    public Context context;


    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    public List<Book> books;

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_item,viewGroup,false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder bookHolder, int i) {
        bookHolder.book = books.get(i);
        bookHolder.tvTenSach.setText(bookHolder.book.BOOK_TEN_SACH);
        bookHolder.tvSoLuong.setText(String.valueOf(bookHolder.book.BOOK_SO_LUONG));
    }


    @Override
    public int getItemCount() {
        if(books == null)return 0;
        else
            return books.size();
    }

    class BookHolder extends RecyclerView.ViewHolder {

        private Book book;
        private TextView tvSoLuong;
        private TextView tvTenSach;
        public BookHolder(@NonNull View itemView) {
            super(itemView);
            tvTenSach = itemView.findViewById(R.id.tvTenSach);
            tvSoLuong = itemView.findViewById(R.id.tvSoLuong);
        }
    }
}