package com.fisrtproject.polybook.model;

public class BillDetail {
    public String BILL_DETAIL_MAHDCT ;
    public String BILL_DETAIL_ID ;
    public String BILL_DETAIL_MA_SACH ;
    public String BILL_DETAIL_SO_LUONG ;
    public Bill bill;

    public BillDetail(String BILL_DETAIL_MAHDCT, String BILL_DETAIL_ID, String BILL_DETAIL_MA_SACH, String BILL_DETAIL_SO_LUONG, Bill bill) {
        this.BILL_DETAIL_MAHDCT = BILL_DETAIL_MAHDCT;
        this.BILL_DETAIL_ID = BILL_DETAIL_ID;
        this.BILL_DETAIL_MA_SACH = BILL_DETAIL_MA_SACH;
        this.BILL_DETAIL_SO_LUONG = BILL_DETAIL_SO_LUONG;
        this.bill = bill;
    }
}
