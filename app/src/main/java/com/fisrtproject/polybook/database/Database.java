package com.fisrtproject.polybook.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fisrtproject.polybook.Constants;

import static com.fisrtproject.polybook.Constants.BILL_DETAIL_TABLE;
import static com.fisrtproject.polybook.Constants.BILL_TABLE;
import static com.fisrtproject.polybook.Constants.BOOK_TABLE;
import static com.fisrtproject.polybook.Constants.CATEGORY_TABLE;
import static com.fisrtproject.polybook.Constants.CREATE_BILL_DETAIL_TABLE;
import static com.fisrtproject.polybook.Constants.CREATE_BILL_TABLE;
import static com.fisrtproject.polybook.Constants.CREATE_BOOK_TABLE;
import static com.fisrtproject.polybook.Constants.CREATE_CATEGORY_TABLE;
import static com.fisrtproject.polybook.Constants.CREATE_USER_TABLE;
import static com.fisrtproject.polybook.Constants.USER_TABLE;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {

        super(context, "quanlisach20.sql", null, 1);
        if (Constants.isDEBUG) Log.e("CREATE_USER_TABLE", CREATE_USER_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_BILL_TABLE", CREATE_BILL_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_CATEGORY_TABLE", CREATE_CATEGORY_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_BOOK_TABLE", CREATE_BOOK_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_BILL_DETA_TABLE", CREATE_BILL_DETAIL_TABLE);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_BILL_TABLE);
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_BOOK_TABLE);
        db.execSQL(CREATE_BILL_DETAIL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BILL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BILL_DETAIL_TABLE);
    }

}
