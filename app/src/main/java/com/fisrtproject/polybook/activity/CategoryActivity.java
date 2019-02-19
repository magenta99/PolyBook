package com.fisrtproject.polybook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fisrtproject.polybook.R;
import com.fisrtproject.polybook.base.BaseActivity;
import com.fisrtproject.polybook.dao.CategoryDAO;
import com.fisrtproject.polybook.model.Category;

public class CategoryActivity extends BaseActivity {
    private Button btnAddCategory;
    private Button btnCancelCategory;
    private Button btnShowCategory;
    private EditText edtMaTheLoai;
    private EditText edtTenTheLoai;
    private EditText edtViTri;
    private EditText edtMota;
    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thêm Thể Loại");
        btnAddCategory = (Button) findViewById(R.id.btnAddCategory);
        btnCancelCategory = (Button) findViewById(R.id.btnCancelCategory);
        btnShowCategory = (Button) findViewById(R.id.btnShowCategory);

        edtMaTheLoai = (EditText) findViewById(R.id.edtMaTheLoai);
        edtTenTheLoai = (EditText) findViewById(R.id.edtTenTheLoai);
        edtViTri = (EditText) findViewById(R.id.edtViTri);
        edtMota = (EditText) findViewById(R.id.edtMota);
        categoryDAO = new CategoryDAO(this);


        btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        btnShowCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(ListCategory.class);
            }
        });

        btnCancelCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllEdt();
            }
        });
    }

    private void clearAllEdt(){
        edtMaTheLoai.setText("");
        edtTenTheLoai.setText("");
        edtViTri.setText("");
        edtMota.setText("");
    }

    private void validate(){
                try{
                    String matheloai = edtMaTheLoai.getText().toString();
                    String tentheloai = edtTenTheLoai.getText().toString();
                    int vitri = Integer.parseInt(edtViTri.getText().toString());
                    String mota = edtMota.getText().toString();
                    if(matheloai.length() != 4){
                        showMessage("Mã thể loại bắt buộc phải 4 ký tự");
                    }
                    else if(tentheloai.length() < 0){
                        showMessage("Vui lòng nhập đúng tên thể loại");
                    }
                    else if(vitri < 0){
                        showMessage("Vui lòng nhập vị trí");
                    }
                    else if(categoryDAO.insertCategory(new Category(matheloai,tentheloai,mota,vitri)) > 0){
                        showMessage("Thêm thể loại thành công");
                        clearAllEdt();
                    }else if(categoryDAO.insertCategory(new Category(matheloai,tentheloai,mota,vitri)) <= 0){
                        showMessage("Thêm thể loại thất bại");
                    }
                }catch (NumberFormatException e){
                    showMessage("Vui lòng nhập vị trí là số");
                }
   }
}
