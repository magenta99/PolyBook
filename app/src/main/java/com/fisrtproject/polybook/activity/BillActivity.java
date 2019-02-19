package com.fisrtproject.polybook.activity;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.base.BaseActivity;
import com.fisrtproject.polybook.dao.BillDAO;
import com.fisrtproject.polybook.model.Bill;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BillActivity extends BaseActivity {
    private TextInputLayout input;
    private EditText edtBillID;
    private Button btnDate;
    private Button btnThem;
    private EditText edtDate;
    private BillDAO billDAO;
    private Button btnShowBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thêm Hóa Đơn");
        input = (TextInputLayout) findViewById(R.id.input);
        edtBillID = (EditText) findViewById(R.id.edtBillID);
        btnDate = (Button) findViewById(R.id.btnDate);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnShowBill = (Button) findViewById(R.id.btnShowBill);
        edtDate = (EditText) findViewById(R.id.edtDate);

        billDAO = new BillDAO(this);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        btnShowBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(ListBill.class);
            }
        });


    }

    private void clearEdt() {
        edtBillID.setText("");
        edtDate.setText("");
    }

    private void pickDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(BillActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int month1 = month + 1;
                String date = dayOfMonth + "-" + month1 + "-" + year;
                edtDate.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void validate() {
        try {
            String billid = edtBillID.getText().toString();
            String date = edtDate.getText().toString();

            if (billid.length() != 4) {
                showMessage("Mã hóa đơn phải có 4 kí tự");
            } else if (date.isEmpty()) {
                showMessage("Vui lòng chọn ngày");
            } else if (billDAO.insertBill(new Bill(billid, date)) > 0) {
                clearEdt();
                showMessage("Thêm hóa đơn thành công");
            } else if (billDAO.insertBill(new Bill(billid, date)) <= 0) {
                showMessage("Thêm thất bại");
            }
        } catch (Exception e) {
            Log.d("Lỗi", " " + e);
        }
    }
}
