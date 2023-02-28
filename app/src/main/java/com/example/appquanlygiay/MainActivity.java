package com.example.appquanlygiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
//    Button ;
    ImageView dangxuat, btt_hangTrongkho,btt_nhapHang,btt_xuatHang,btt_hoadonNhap,btt_hoadonXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
        btt_hangTrongkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_hangtrongkho.class);
                startActivity(intent);
            }
        });
       btt_nhapHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NhapHang.class);
                startActivity(intent);
            }
        });
        btt_xuatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,XuatHang.class);
                startActivity(intent);
            }
        });

    }
    public void getView(){
        dangxuat=findViewById(R.id.btt_DangXuat);
        btt_hangTrongkho=findViewById(R.id.btt_hangtrongkho);
        btt_nhapHang=findViewById(R.id.btt_nhaphang);
        btt_xuatHang=findViewById(R.id.btt_xuathang);
        btt_hoadonNhap=findViewById(R.id.btt_hoadonnhap);
        btt_hoadonXuat=findViewById(R.id.btt_hoadonxuat);

    }
}