package com.example.appquanlygiay.Activity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appquanlygiay.R;

public class activity_list_sanpham_nhap extends AppCompatActivity {
    Button btnThem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sanpham_nhap);
        getView();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_list_sanpham_nhap.this, activity_nhaphang.class);
                intent.putExtra("idHoaDon",getIntent().getStringExtra("idHoaDon"));
                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
                startActivity(intent);
            }
        });

    }

    public void getView()
    {
        btnThem=findViewById(R.id.btnThem);
    }
}
