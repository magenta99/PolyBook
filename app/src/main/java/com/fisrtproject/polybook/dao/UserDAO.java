package com.fisrtproject.polybook.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fisrtproject.polybook.database.Database;
import com.fisrtproject.polybook.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.fisrtproject.polybook.Constants.USER_FULL_NAME;
import static com.fisrtproject.polybook.Constants.USER_NAME;
import static com.fisrtproject.polybook.Constants.USER_PASSWORD;
import static com.fisrtproject.polybook.Constants.USER_PHONE;
import static com.fisrtproject.polybook.Constants.USER_TABLE;

public class UserDAO {

    private Database database;

    public UserDAO(Context context) {
        this.database = new Database(context);
    }




    //USER
    public long insertUser(User user) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME, user.USER_NAME);
        contentValues.put(USER_PASSWORD, user.USER_PASSWORD);
        contentValues.put(USER_PHONE, user.USER_PHONE);
        contentValues.put(USER_FULL_NAME, user.USER_FULL_NAME);

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
        sqLiteDatabase.close();

        return result;
    }

    public long updateUser(User user) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME, user.USER_NAME);
        contentValues.put(USER_PASSWORD, user.USER_PASSWORD);
        contentValues.put(USER_PHONE, user.USER_PHONE);
        contentValues.put(USER_FULL_NAME, user.USER_FULL_NAME);

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.update(USER_TABLE, contentValues, USER_NAME + "=?",
                new String[]{user.USER_NAME});

        return result;
    }

    public long deleteUser(String user_name) {
        long result = -1;

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.delete(USER_TABLE, USER_NAME + "=?",
                new String[]{user_name});

        return result;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String QUERY = "SELECT * FROM " + USER_TABLE;
        //xin quyen doc ghi
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                //di chuyen toi vi tri dau tien cua con tro
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String USER_NAME_ = cursor.getString(cursor.getColumnIndex(USER_NAME));
                    String USER_PASSWORD_ = cursor.getString(cursor.getColumnIndex(USER_PASSWORD));
                    String USER_PHONE_ = cursor.getString(cursor.getColumnIndex(USER_PHONE));
                    String USER_FULL_NAME_ = cursor.getString(cursor.getColumnIndex(USER_FULL_NAME));

                    User user = new User(USER_NAME_,USER_PASSWORD_,USER_PHONE_,USER_FULL_NAME_);


                    //add user vao array users;
                    users.add(user);
                    //di chuyen toi vi tri tiep theo
                    cursor.moveToNext();
                }
                cursor.close();
                sqLiteDatabase.close();
            }
        }
        return users;
    }
}
