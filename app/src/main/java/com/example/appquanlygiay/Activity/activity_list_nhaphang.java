package com.example.appquanlygiay.Activity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appquanlygiay.R;

public class activity_list_nhaphang extends AppCompatActivity {
    Button btnThem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nhaphang);
        getView();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void getView()
    {
        btnThem=findViewById(R.id.btnThem);
    }
}
