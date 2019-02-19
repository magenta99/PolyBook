package com.fisrtproject.polybook;

public class Constants {
    public static final boolean isDEBUG = true;


    //khai bao bang nguoiDung
    public static final String USER_TABLE = "nguoiDung";

    //khai bao ten cot trong bang nguoiDung
    public static final String USER_NAME = "userNAME";
    public static final String USER_PASSWORD = "Password";
    public static final String USER_PHONE = "Phone";
    public static final String USER_FULL_NAME = "hoTen";

    //cau lenh tao bang nguoi dung

    //CREATE TABLE nguoiDung (userName NVARCHAR(50) , Password NVARCHAR(50) , Phone NCHAR(10) , hoTen NVARCHAR(50));

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "(" +
            "" + USER_NAME + " NVARCHAR(50)," +
            "" + USER_PASSWORD + " NVARCHAR(50)," +
            "" + USER_PHONE + " NCHAR(10)," +
            "" + USER_FULL_NAME + " NVARCHAR(50)" +
            ")";


    //khai bao bang nguoiDung
    public static final String CATEGORY_TABLE = "theLoai";

    //khai bao ten cot trong bang nguoiDung
    public static final String CATEGORY_MA_THE_LOAI = "MaTheLoai";
    public static final String CATEGORY_TEN_THE_LOAI = "TenTheLoai";
    public static final String CATEGORY_MO_TA = "MoTa";
    public static final String CATEGORY_VI_TRI = "ViTri";

    //cau lenh tao bang nguoi dung

    //CREATE TABLE nguoiDung (userName NVARCHAR(50) , Password NVARCHAR(50) , Phone NCHAR(10) , hoTen NVARCHAR(50));

    public static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + CATEGORY_TABLE + "(" +
            "" + CATEGORY_MA_THE_LOAI + " NVARCHAR(5) NOT NULL PRIMARY KEY," +
            "" + CATEGORY_TEN_THE_LOAI + " NVARCHAR(50)," +
            "" + CATEGORY_MO_TA + " NVARCHAR(255)," +
            "" + CATEGORY_VI_TRI + " INTEGER" +
            ")";


    //khai bao bang HoaDon
    public static final String BILL_TABLE = "HoaDon";

    //khai bao ten cot trong bang nguoiDung
    public static final String BILL_ID = "MaHoaDon";
    public static final String BILL_DATE = "NgayMua";


    //cau lenh tao bang nguoi dung

    //CREATE TABLE nguoiDung (userName NVARCHAR(50) , Password NVARCHAR(50) , Phone NCHAR(10) , hoTen NVARCHAR(50));

    public static final String CREATE_BILL_TABLE = "CREATE TABLE " + BILL_TABLE + "(" +
            "" + BILL_ID + " NCHAR(7) PRIMARY KEY," +
            "" + BILL_DATE + " DATE" +
            ")";

    //khai bao bang Sach
    public static final String BOOK_TABLE = "Sach";

    //khai bao ten cot trong bang Sach
    public static final String BOOK_MA_SACH = "MaSach";
    public static final String BOOK_MA_THE_LOAI = "MaTheLoai";
    public static final String BOOK_TAC_GIA = "TacGia";
    public static final String BOOK_NXB = "NXB";
    public static final String BOOK_GIA_BIA = "GiaBia";
    public static final String BOOK_SO_LUONG = "SoLuong";
    public static final String BOOK_TEN_SACH = "TenSach";


    //cau lenh tao bang nguoi dung

    //CREATE TABLE nguoiDung (userName NVARCHAR(50) , Password NVARCHAR(50) , Phone NCHAR(10) , hoTen NVARCHAR(50));

    public static final String CREATE_BOOK_TABLE = "CREATE TABLE " + BOOK_TABLE + "(" +
            "" + BOOK_MA_SACH + " NCHAR(7) PRIMARY KEY," +
            "" + BOOK_MA_THE_LOAI + " NCHAR(50)," +
            "" + BOOK_TEN_SACH + " NVARCHAR(50)," +
            "" + BOOK_TAC_GIA + " NVARCHAR(50)," +
            "" + BOOK_NXB + " NVARCHAR(50)," +
            "" + BOOK_GIA_BIA + " INT," +
            "" + BOOK_SO_LUONG + " INT" +
            ")";

    //khai bao bang HoaDonChiTiet
    public static final String BILL_DETAIL_TABLE = "HoaDonChiTiet";

    //khai bao ten cot trong bang Sach
    public static final String BILL_DETAIL_MAHDCT = "MaHoaDonChiTiet";
    public static final String BILL_DETAIL_ID = "MaHoaDon";
    public static final String BILL_DETAIL_MA_SACH = "MaSach";
    public static final String BILL_DETAIL_SO_LUONG = "SoLuong";

    public static final String CREATE_BILL_DETAIL_TABLE = "CREATE TABLE " + BILL_DETAIL_TABLE + "(" +
            "" + BILL_DETAIL_MAHDCT + " INT PRIMARY KEY AUTOINCREMENT," +
            "" + BILL_DETAIL_ID + " NCHAR(7)," +
            "" + BILL_DETAIL_MA_SACH + " NCHAR(5)," +
            "" + BILL_DETAIL_SO_LUONG + " INT" +
            ")";
}




