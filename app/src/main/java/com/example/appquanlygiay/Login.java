package com.example.appquanlygiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button login,singup;
    TextView quenMK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getView();

    }
    public void onclickDK(View v){
        Intent intent=new Intent(Login.this,activity_dangky.class);
        startActivity(intent);
    }
    public void onclickquenMK(View v){
        Intent intent=new Intent(Login.this,activity_quenMK.class);
        startActivity(intent);
    }
    public void getView(){
        login=findViewById(R.id.btnDangNhap);
        singup=findViewById(R.id.btnDangKy);
        quenMK=findViewById(R.id.tvquenmk);
    }
}