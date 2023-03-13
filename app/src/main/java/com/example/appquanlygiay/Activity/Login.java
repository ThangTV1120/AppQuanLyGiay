package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appquanlygiay.Models.User;
import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.R;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    Button login,singup;
    TextView quenMK;
    Database databaseUser;
    EditText TenDN,MatKhau;
    String TK,MK;
    ArrayList<User> arrayUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getView();
        arrayUser=new ArrayList<>();

        databaseUser =new Database(Login.this,"QuanLyGiay.sqlite",null,1);
        databaseUser.QueryData("CREATE TABLE IF NOT EXISTS User (ID INTEGER  AUTOINCREMENT," +
                "TKDN VARCHAR(30) PRIMARY KEY, MatKhau VARCHAR(30),Name NVARCHAR(50))");

        TK=getIntent().getStringExtra("TK");
        MK=getIntent().getStringExtra("MK");
        TenDN.setText(TK);
        MatKhau.setText(MK);
        getData();
    }

    public void getData(){
        Cursor dataUser=databaseUser.GetData("SELECT * FROM User");
        arrayUser.clear();
        while(dataUser.moveToNext()){
            int id=dataUser.getInt(0);
            String TKDN=dataUser.getString(1);
            String MatKhauDN=dataUser.getString(2);
            String Name = dataUser.getString(3);
            arrayUser.add(new User(id,TKDN,MatKhauDN,Name));

        }
    dataUser.close();
    }


    public void onclickDN(View v){
        String tenDN=TenDN.getText().toString();
        String mkDN=MatKhau.getText().toString();
        if(tenDN.equals("")||mkDN.equals("")){
            Toast.makeText(this, "Vui lòng điền đủ thông tin đăng nhập", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean trangthai=false;
            String name;
            for(int i=0;i<arrayUser.size();i++){
                if(tenDN.equals(arrayUser.get(i).getUsername())&&mkDN.equals(arrayUser.get(i).getPassword())){
                   // database.QueryData("UPDATE SET TrangThai=1");
                    name=arrayUser.get(i).getName();
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    trangthai=true;
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    intent.putExtra("TenNguoiSuDung",name);

                   // R.string.TKKH = "Tuấn";

                    startActivity(intent);
                    break;
                }

            }
            if(!trangthai){
                Toast.makeText(Login.this,"Chưa có tài khoản này hoặc sai mật khẩu",Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void onclickDK(View v){
        Intent intent=new Intent(Login.this, activity_dangky.class);
        startActivity(intent);
    }
    public void onclickquenMK(View v){
        Intent intent=new Intent(Login.this, activity_quenMK.class);
        startActivity(intent);
    }
    public void getView(){
        login=findViewById(R.id.btnDangNhap);
        singup=findViewById(R.id.btnDangKy);
        quenMK=findViewById(R.id.tvquenmk);
        TenDN=findViewById(R.id.editTextTenDN);
        MatKhau=findViewById(R.id.editTextMatKhauDN);

    }
}