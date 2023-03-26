package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appquanlygiay.Models.User;
import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.R;

import java.util.ArrayList;

public class activity_dangky extends AppCompatActivity {
    EditText tenDK,mkDK,nhaplaimkDK,hotenDK;
    Button dangky,quaylai;
    Database database;
    ArrayList<User> arrayUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        getView();

        database =new Database(activity_dangky.this,"QuanLyGiay.sqlite",null,1);
        arrayUser=new ArrayList<>();
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(activity_dangky.this, Login.class);
//                startActivity(intent);
                finish();
            }
        });
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tentkDk, mktkDK, nhaplaimk, name;
                tentkDk=tenDK.getText().toString();
                mktkDK=mkDK.getText().toString();
                nhaplaimk=nhaplaimkDK.getText().toString();
                name=hotenDK.getText().toString();
                if(tentkDk.equals("")|| mktkDK.equals("") || nhaplaimk.equals("")){
                    Toast.makeText(activity_dangky.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    Cursor Account=database.GetData_Condition("SELECT TKDN from User where TKDN=?",new String[]{tentkDk});
                    if(Account!=null && Account.moveToNext()){
                        Toast.makeText(activity_dangky.this,"Tên đăng nhập đã tồn tại",Toast.LENGTH_SHORT).show();
                        Account.close();
                    }
                    else{
                        if(mktkDK.equals(nhaplaimk)){
                            ContentValues values=new ContentValues();
                            values.put("TKDN",tentkDk);
                            values.put("MatKhau",mktkDK);
                            values.put("Name",name);
                           // values.put("TrangThai",0);

                            database.insertData("User",values);
                            values.clear();
                            Intent intent=new Intent(activity_dangky.this,Login.class);
                            Toast.makeText(activity_dangky.this, "Đăng Ký Thành Công ", Toast.LENGTH_SHORT).show();
                            intent.putExtra("TK",tentkDk);
                            intent.putExtra("MK",mktkDK);
                            startActivity(intent);
//                            Cursor c = database.GetData("SELECT * from User");
//                           // hotenDK.setText("fasdf");
//                            c.moveToFirst();
//                            Toast.makeText(activity_dangky.this, c.getString(0)+" TK: "+c.getString(1)+" MK: "+c.getString(2)+" Name: "+c.getString(3), Toast.LENGTH_LONG).show();

                        }
                        else Toast.makeText(activity_dangky.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                    Account.close();
                }
//                User s=new User(0,"1456","123","thang");
//                Toast.makeText(activity_dangky.this, "you "+s.getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void getView(){
        tenDK=findViewById(R.id.editTextTenDK);
        mkDK=findViewById(R.id.editTextMatKhauDK);
        nhaplaimkDK=findViewById(R.id.editTextNhapLaiMatKhauDk);
        hotenDK=findViewById(R.id.editTextHoTenDK);
       quaylai=findViewById(R.id.btnQuayLaiDK);
       dangky=findViewById(R.id.btnDangKyTK);

    }
}