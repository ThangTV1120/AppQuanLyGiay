package com.example.appquanlygiay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.R;

public class activity_xuathang extends AppCompatActivity {
    EditText txtMaXuat, txtTen, txtSize, txtGia, txtSoLuong;
    Button btnXuatHang;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themhoadon_xuat);
        getView();

        btnXuatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_xuathang.this, activity_list_sanpham_xuat.class);
                startActivity(intent);
            }
        });
    }

    public void getView(){
        txtMaXuat = findViewById(R.id.txtMaSP);
        txtTen = findViewById(R.id.txtTenSP);
        txtSize = findViewById(R.id.txtSize);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        txtGia = findViewById(R.id.txtGia);
        btnXuatHang = findViewById(R.id.btnXuatHang);
    }

}
