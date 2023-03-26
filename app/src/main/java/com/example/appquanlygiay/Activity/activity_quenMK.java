package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.User;
import com.example.appquanlygiay.R;

import java.util.ArrayList;

public class activity_quenMK extends AppCompatActivity {
    Button QuayLai,DoiMK;
    EditText TenDN,MK,xacnhanMK;
    public Database database;
    ArrayList<User> arrayUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mk);
        getView();
        database=new Database(activity_quenMK.this,"QuanLyGiay.sqlite",null,1);
        DoiMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tkDkquenMK, mkTKquenMK, xacnhanmk;
                tkDkquenMK = TenDN.getText().toString();
                mkTKquenMK = MK.getText().toString();
               xacnhanmk = xacnhanMK.getText().toString();
               if(tkDkquenMK.equals("")||mkTKquenMK.equals("")||xacnhanmk.equals("")){
                   Toast.makeText(activity_quenMK.this, "Vui lòng điền tất cả thông tin", Toast.LENGTH_LONG).show();
               }
               else{
                   if(mkTKquenMK.equals(xacnhanmk)){
                       ContentValues contentValues = new ContentValues();
                       contentValues.put("Matkhau", mkTKquenMK);
                       int sussessful = database.updateData("User", contentValues, "TKDN=?", new String[]{tkDkquenMK});
                       if(sussessful>0){
                           Intent intent=new Intent(activity_quenMK.this,Login.class);
                           Toast.makeText(activity_quenMK.this, "Thay đổi thành công", Toast.LENGTH_SHORT).show();
                           intent.putExtra("TK",tkDkquenMK);
                           intent.putExtra("MK",mkTKquenMK);
                           startActivity(intent);
                       }
                       else Toast.makeText(activity_quenMK.this, "Sai tên đăng nhập", Toast.LENGTH_SHORT).show();

                   }
                   else  Toast.makeText(activity_quenMK.this, "Nhập mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();

               }
            }
        });

    }
    public void onclickQuayLaiMain(View v){
//        Intent intent=new Intent(activity_quenMK.this, Login.class);
//        startActivity(intent);
        finish();
    }
    public void getView(){
        QuayLai=findViewById(R.id.btnQuayLaiQuenMK);
        DoiMK=findViewById(R.id.btnThayDoi);
        TenDN=findViewById(R.id.editTextTenDKQuenMK);
        MK=findViewById(R.id.editTextMatKhauDKQuenMK);
        xacnhanMK=findViewById(R.id.editTextNhapLaiMatKhauDkQuenMK);
    }
}