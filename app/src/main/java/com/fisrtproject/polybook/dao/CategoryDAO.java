package com.fisrtproject.polybook.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fisrtproject.polybook.database.Database;
import com.fisrtproject.polybook.model.Category;

import java.util.ArrayList;
import java.util.List;

import static com.fisrtproject.polybook.Constants.CATEGORY_MA_THE_LOAI;
import static com.fisrtproject.polybook.Constants.CATEGORY_MO_TA;
import static com.fisrtproject.polybook.Constants.CATEGORY_TABLE;
import static com.fisrtproject.polybook.Constants.CATEGORY_TEN_THE_LOAI;
import static com.fisrtproject.polybook.Constants.CATEGORY_VI_TRI;
import static com.fisrtproject.polybook.Constants.USER_NAME;
import static com.fisrtproject.polybook.Constants.USER_TABLE;

public class CategoryDAO {

    private Database database;

    public CategoryDAO(Context context) {
        this.database = new Database(context);
    }

    //CATEGORY//
    public long insertCategory(Category category) {
        long result = -1;

        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_MA_THE_LOAI, category.CATEGORY_MA_THE_LOAI);
        contentValues.put(CATEGORY_TEN_THE_LOAI, category.CATEGORY_TEN_THE_LOAI);
        contentValues.put(CATEGORY_MO_TA, category.CATEGORY_MO_TA);
        contentValues.put(CATEGORY_VI_TRI, category.CATEGORY_VI_TRI);

        //Xin quyen ghi vào bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.insert(CATEGORY_TABLE, null, contentValues);
        sqLiteDatabase.close();

        return result;
    }

    public long updateCategory(Category category) {
        long result = -1;

        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_MA_THE_LOAI, category.CATEGORY_MA_THE_LOAI);
        contentValues.put(CATEGORY_TEN_THE_LOAI, category.CATEGORY_TEN_THE_LOAI);
        contentValues.put(CATEGORY_MO_TA, category.CATEGORY_MO_TA);
        contentValues.put(CATEGORY_VI_TRI, category.CATEGORY_VI_TRI);

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.update(CATEGORY_TABLE, contentValues, CATEGORY_MA_THE_LOAI + "=?",
                new String[]{category.CATEGORY_MA_THE_LOAI});

        return result;
    }

    public long deleteCategory(String category_ma_the_loai) {
        long result = -1;

        //xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        result = sqLiteDatabase.delete(USER_TABLE, USER_NAME + "=?",
                new String[]{category_ma_the_loai});

        return result;
    }
 /// get
    public List<Category> getAllCategorys() {
        List<Category> categories = new ArrayList<>();

        String QUERY = "SELECT * FROM " + CATEGORY_TABLE;
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                //di chuyen toi vi tri dau tien cua con tro
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String CATEGORY_MA_THE_LOAI_ = cursor.getString(cursor.getColumnIndex(CATEGORY_MA_THE_LOAI));
                    String CATEGORY_TEN_THE_LOAI_ = cursor.getString(cursor.getColumnIndex(CATEGORY_TEN_THE_LOAI));
                    String CATEGORY_MO_TA_ = cursor.getString(cursor.getColumnIndex(CATEGORY_MO_TA));
                    int CATEGORY_VI_TRI_ = cursor.getInt(cursor.getColumnIndex(CATEGORY_VI_TRI));

                    Category category = new Category(CATEGORY_MA_THE_LOAI_,CATEGORY_TEN_THE_LOAI_,CATEGORY_MO_TA_,CATEGORY_VI_TRI_);

                    //add category vao array
                    categories.add(category);
                    cursor.moveToNext();
                }
                cursor.close();
                sqLiteDatabase.close();
            }
        }
        return categories;
    }

    public List<String> getCategoryID(){
        List<String> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        String query = "select * from "+CATEGORY_TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor != null){
            if(cursor.getCount() > 0){
                while (cursor.moveToNext()){
                    String matheloai = cursor.getString(cursor.getColumnIndex(CATEGORY_MA_THE_LOAI));
                    list.add(matheloai);
                }
            }
        }

        return list;
    }

}
