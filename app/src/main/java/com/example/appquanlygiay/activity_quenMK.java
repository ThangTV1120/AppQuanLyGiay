package com.example.appquanlygiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class activity_quenMK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mk);
        Button Login=findViewById(R.id.btnQuayLaiQuenMK);

    }
    public void onclickQuayLaiMain(){
        Intent intent=new Intent(activity_quenMK.this,Login.class);
        startActivity(intent);
    }
}