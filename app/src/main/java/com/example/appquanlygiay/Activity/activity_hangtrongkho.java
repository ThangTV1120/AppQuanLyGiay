package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.Models.Shoes;
import com.example.appquanlygiay.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class activity_hangtrongkho extends AppCompatActivity {
    String idShoe, nameShoe;
    int size,price;
    ArrayList<Shoes> arrayShoes;
    Database databaseShoes;
    ImageView Out;
    TextView TenNguoiSD;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangtrongkho);
        arrayShoes = new ArrayList<>();
        databaseShoes = new Database(activity_hangtrongkho.this,"QuanLyGiay.sqlite",null,1);

        getView();
        idShoe = getIntent().getStringExtra("idShoe");
        nameShoe = getIntent().getStringExtra("NameShoe");
        //size = getIntent().getIntExtra(size);
       // price =getIntent().getIntExtra(price);
        String name =getIntent().getStringExtra("TenNguoiSuDung");
        TenNguoiSD.setText(name);
        String tkdn=getIntent().getStringExtra("TKDN");



        Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_hangtrongkho.this, MainActivity.class);
                intent.putExtra("TKDN",tkdn);
                intent.putExtra("TenNguoiSuDung",name);
                startActivity(intent);
            }
        });
    }
    public void getData() throws ParseException {
        Cursor dataShoes= databaseShoes.GetData("Select * from Shoes");
        arrayShoes.clear();
        while (dataShoes.moveToNext()){
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            String idShoe = dataShoes.getString(0);
            String name = dataShoes.getString(1);
            int size  = Integer.parseInt(dataShoes.getString(2));
            int price = Integer.parseInt(dataShoes.getString(3));

            arrayShoes.add(new Shoes(idShoe,name,size,price));
        }
        dataShoes.close();
    }

    public void getView(){
        lv=findViewById(R.id.listGiayTrongKho);
        Out=findViewById(R.id.btt_Out);
        TenNguoiSD=findViewById(R.id.TenNguoiSD);
    }
}