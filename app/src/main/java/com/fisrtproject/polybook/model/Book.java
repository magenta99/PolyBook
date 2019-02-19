package com.fisrtproject.polybook.model;

public class Book {
    public String BOOK_MA_SACH ;
    public String BOOK_MA_THE_LOAI ;
    public String BOOK_TAC_GIA ;
    public String BOOK_NXB ;
    public int BOOK_GIA_BIA ;
    public int BOOK_SO_LUONG ;
    public String BOOK_TEN_SACH ;

    public Book(String BOOK_MA_SACH, String BOOK_MA_THE_LOAI, String BOOK_TAC_GIA, String BOOK_NXB, int BOOK_GIA_BIA, int BOOK_SO_LUONG, String BOOK_TEN_SACH) {
        this.BOOK_MA_SACH = BOOK_MA_SACH;
        this.BOOK_MA_THE_LOAI = BOOK_MA_THE_LOAI;
        this.BOOK_TAC_GIA = BOOK_TAC_GIA;
        this.BOOK_NXB = BOOK_NXB;
        this.BOOK_GIA_BIA = BOOK_GIA_BIA;
        this.BOOK_SO_LUONG = BOOK_SO_LUONG;
        this.BOOK_TEN_SACH = BOOK_TEN_SACH;
    }
}
