package com.example.appquanlygiay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.R;

public class activity_nhaphang extends AppCompatActivity {
    EditText txtMa,txtTen,txtSize,txtGia,txtSoLuong;
    Button btnThemHang;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themhoadon_nhap);
        getView();

        btnThemHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_nhaphang.this, activity_themhoadon_nhap.class);
                startActivity(intent);
            }
        });
    }

    public void getView()
    {
        txtMa=findViewById(R.id.txtMaSP);
        txtTen=findViewById(R.id.txtTenSP);
        txtSize=findViewById(R.id.txtSize);
        txtGia=findViewById(R.id.txtGia);
        txtSoLuong=findViewById(R.id.txtSoLuong);
        btnThemHang=findViewById(R.id.btnThemHang);
    }

}
