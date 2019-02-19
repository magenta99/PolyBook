//package com.fisrtproject.polybook.dao;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.fisrtproject.polybook.Constants;
//import com.fisrtproject.polybook.database.Database;
//import com.fisrtproject.polybook.model.Bill;
//import com.fisrtproject.polybook.model.BillDetail;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.fisrtproject.polybook.Constants.BILL_DATE;
//import static com.fisrtproject.polybook.Constants.BILL_DETAIL_ID;
//import static com.fisrtproject.polybook.Constants.BILL_DETAIL_MAHDCT;
//import static com.fisrtproject.polybook.Constants.BILL_DETAIL_MA_SACH;
//import static com.fisrtproject.polybook.Constants.BILL_DETAIL_SO_LUONG;
//import static com.fisrtproject.polybook.Constants.BILL_DETAIL_TABLE;
//import static com.fisrtproject.polybook.Constants.BILL_ID;
//import static com.fisrtproject.polybook.Constants.BILL_TABLE;
//
//public class BillDetailDAO {
//    private Database database;
//
//    public BillDetailDAO(Context context) {
//        this.database = new Database(context);
//    }
//
//    public long insertBillDetail(BillDetail billDetail) {
//        long result = -1;
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(BILL_DETAIL_MAHDCT, billDetail.BILL_DETAIL_MAHDCT);
//        contentValues.put(BILL_DETAIL_ID, billDetail.BILL_DETAIL_ID);
//        contentValues.put(BILL_DETAIL_MA_SACH, billDetail.BILL_DETAIL_MA_SACH);
//        contentValues.put(BILL_DETAIL_SO_LUONG, billDetail.BILL_DETAIL_SO_LUONG);
//
//        //xin quyen ghi vao bang
//        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
//
//        result = sqLiteDatabase.insert(BILL_DETAIL_TABLE, null, contentValues);
//        sqLiteDatabase.close();
//
//        return result;
//    }
//
//    public long updateBillDetail(BillDetail billDetail) {
//        long result = -1;
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(BILL_DETAIL_MAHDCT, billDetail.BILL_DETAIL_MAHDCT);
//        contentValues.put(BILL_DETAIL_ID, billDetail.BILL_DETAIL_ID);
//        contentValues.put(BILL_DETAIL_MA_SACH, billDetail.BILL_DETAIL_MA_SACH);
//        contentValues.put(BILL_DETAIL_SO_LUONG, billDetail.BILL_DETAIL_SO_LUONG);
//
//        //xin quyen ghi vao bang
//        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
//
//        result = sqLiteDatabase.update(BILL_TABLE, contentValues, BILL_DETAIL_MAHDCT + "=?",
//                new String[]{billDetail.BILL_DETAIL_MAHDCT});
//
//        return result;
//    }
//
//    public long deleteBillDetail(String bill_detail_mahdct) {
//        long result = -1;
//
//        //xin quyen ghi vao bang
//        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
//
//        result = sqLiteDatabase.delete(BILL_DETAIL_TABLE, BILL_DETAIL_MAHDCT + "=?",
//                new String[]{bill_detail_mahdct});
//
//        return result;
//    }
//
////    public List<BillDetail> getAllBillDetails() {
////        List<BillDetail> billDetails = new ArrayList<>();
////
////        String QUERY = "SELECT * FROM " + BILL_TABLE;
////        //xin quyen doc ghi
////        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
////        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);
////        if (cursor != null) {
////            if (cursor.getCount() > 0) {
////                //di chuyen toi vi tri dau tien cua con tro
////                cursor.moveToFirst();
////                while (!cursor.isAfterLast()) {
////                    String BILL_DETAIL_MAHDCT_ = cursor.getString(cursor.getColumnIndex(BILL_DETAIL_MAHDCT));
////                    String BILL_DETAIL_ID_ = cursor.getString(cursor.getColumnIndex(BILL_DETAIL_ID));
////                    String BILL_DETAIL_MA_SACH_ = cursor.getString(cursor.getColumnIndex(BILL_DETAIL_MA_SACH));
////                    String BILL_DETAIL_SO_LUONG_ = cursor.getString(cursor.getColumnIndex(BILL_DETAIL_SO_LUONG));
////
//////                    BillDetail billDetail = new BillDetail(BILL_DETAIL_MAHDCT_,BILL_DETAIL_ID_,BILL_DETAIL_MA_SACH_,BILL_DETAIL_SO_LUONG_);
////
////                    //add user vao array users;
////                    billDetails.add(billDetail);
////                    //di chuyen toi vi tri tiep theo
////                    cursor.moveToNext();
////                }
////                cursor.close();
////                sqLiteDatabase.close();
////            }
////        }
////        return billDetails;
//    }
//}
