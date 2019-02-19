package com.fisrtproject.polybook.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fisrtproject.polybook.database.Database;
import com.fisrtproject.polybook.model.Bill;

import java.util.ArrayList;
import java.util.List;

import static com.fisrtproject.polybook.Constants.BILL_DATE;
import static com.fisrtproject.polybook.Constants.BILL_ID;
import static com.fisrtproject.polybook.Constants.BILL_TABLE;

public class BillDAO {
    private Database database;

    public BillDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertBill(Bill bill) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(BILL_ID, bill.BILL_ID);
        contentValues.put(BILL_DATE, bill.BILL_DATE);


        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.insert(BILL_TABLE, null, contentValues);
        sqLiteDatabase.close();

        return result;
    }

    public long updateBill(Bill bill) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(BILL_ID, bill.BILL_ID);
        contentValues.put(BILL_DATE, bill.BILL_DATE);

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.update(BILL_TABLE, contentValues, BILL_ID + "=?",
                new String[]{bill.BILL_ID});

        return result;
    }

    public long deleteBill(String bill_id) {
        long result = -1;

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.delete(BILL_TABLE, BILL_ID + "=?",
                new String[]{bill_id});

        return result;
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();

        String QUERY = "SELECT * FROM " + BILL_TABLE;
        //xin quyen doc ghi
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                //di chuyen toi vi tri dau tien cua con tro
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String BILL_ID_ = cursor.getString(cursor.getColumnIndex(BILL_ID));
                    String BILL_DATE_ = cursor.getString(cursor.getColumnIndex(BILL_DATE));


                    Bill bill = new Bill(BILL_ID_,BILL_DATE_);

                    //add user vao array users;
                    bills.add(bill);
                    //di chuyen toi vi tri tiep theo
                    cursor.moveToNext();
                }
                cursor.close();
                sqLiteDatabase.close();
            }
        }
        return bills;
    }
}
