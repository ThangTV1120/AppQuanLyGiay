package com.example.appquanlygiay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.R;

public class activity_list_sanpham_xuat extends AppCompatActivity {
    Button btnXuat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sanpham_xuat);
        btnXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_list_sanpham_xuat.this, activity_xuathang.class);
            }
        });
    }
    public void getView(){
        btnXuat = findViewById(R.id.btnXuat);

    }
}
