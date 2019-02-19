package com.fisrtproject.polybook.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fisrtproject.polybook.database.Database;
import com.fisrtproject.polybook.model.Book;

import java.util.ArrayList;
import java.util.List;

import static com.fisrtproject.polybook.Constants.BOOK_GIA_BIA;
import static com.fisrtproject.polybook.Constants.BOOK_MA_SACH;
import static com.fisrtproject.polybook.Constants.BOOK_MA_THE_LOAI;
import static com.fisrtproject.polybook.Constants.BOOK_NXB;
import static com.fisrtproject.polybook.Constants.BOOK_SO_LUONG;
import static com.fisrtproject.polybook.Constants.BOOK_TABLE;
import static com.fisrtproject.polybook.Constants.BOOK_TAC_GIA;
import static com.fisrtproject.polybook.Constants.BOOK_TEN_SACH;

public class BookDAO {
    private Database database;

    public BookDAO(Context context) {
        this.database = new Database(context);
    }

    //BOOK
    public long insertBook(Book book) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOK_MA_SACH, book.BOOK_MA_SACH);
        contentValues.put(BOOK_MA_THE_LOAI, book.BOOK_MA_THE_LOAI);
        contentValues.put(BOOK_TEN_SACH, book.BOOK_TEN_SACH);
        contentValues.put(BOOK_TAC_GIA, book.BOOK_TAC_GIA);
        contentValues.put(BOOK_NXB, book.BOOK_NXB);
        contentValues.put(BOOK_SO_LUONG, book.BOOK_SO_LUONG);
        contentValues.put(BOOK_GIA_BIA, book.BOOK_GIA_BIA);

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.insert(BOOK_TABLE, null, contentValues);
        sqLiteDatabase.close();

        return result;
    }

    public long updateBook(Book book) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOK_MA_SACH, book.BOOK_MA_SACH);
        contentValues.put(BOOK_MA_THE_LOAI, book.BOOK_MA_THE_LOAI);
        contentValues.put(BOOK_TEN_SACH, book.BOOK_TEN_SACH);
        contentValues.put(BOOK_TAC_GIA, book.BOOK_TAC_GIA);
        contentValues.put(BOOK_NXB, book.BOOK_NXB);
        contentValues.put(BOOK_SO_LUONG, book.BOOK_SO_LUONG);
        contentValues.put(BOOK_GIA_BIA, book.BOOK_GIA_BIA);

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.update(BOOK_TABLE, contentValues, BOOK_MA_SACH + "=?",
                new String[]{book.BOOK_MA_SACH});

        return result;
    }

    public long deleteBook(String book_ma_sach) {
        long result = -1;

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.delete(BOOK_TABLE, BOOK_MA_SACH + "=?",
                new String[]{book_ma_sach});

        return result;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        String QUERY = "SELECT * FROM " + BOOK_TABLE;
        //xin quyen doc ghi
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                //di chuyen toi vi tri dau tien cua con tro
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String BOOK_MA_SACH_ = cursor.getString(cursor.getColumnIndex(BOOK_MA_SACH));
                    String BOOK_MA_THE_LOAI_ = cursor.getString(cursor.getColumnIndex(BOOK_MA_THE_LOAI));
                    String BOOK_TAC_GIA_ = cursor.getString(cursor.getColumnIndex(BOOK_TAC_GIA));
                    String BOOK_NXB_ = cursor.getString(cursor.getColumnIndex(BOOK_NXB));
                    int BOOK_GIA_BIA_ = cursor.getInt(cursor.getColumnIndex(BOOK_GIA_BIA));
                    int BOOK_SO_LUONG_ = cursor.getInt(cursor.getColumnIndex(BOOK_SO_LUONG));
                    String BOOK_TEN_SACH_ = cursor.getString(cursor.getColumnIndex(BOOK_TEN_SACH));

                    Book book = new Book(BOOK_MA_SACH_,BOOK_MA_THE_LOAI_,BOOK_TAC_GIA_,BOOK_NXB_,BOOK_GIA_BIA_,BOOK_SO_LUONG_,BOOK_TEN_SACH_);


                    //add user vao array users;
                    books.add(book);
                    //di chuyen toi vi tri tiep theo
                    cursor.moveToNext();
                }
                cursor.close();
                sqLiteDatabase.close();
            }
        }
        return books;
    }
}
