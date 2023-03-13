package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangtrongkho);
        arrayShoes = new ArrayList<>();
        databaseShoes = new Database(activity_hangtrongkho.this,"Shoes.sqlite",null,1);

        databaseShoes.QueryData("CREATE TABLE IF NOT EXISTS Shoes (idShoe VARCHAR(30) primary key, NameShoe NVARCHAR(30),"
                +"Size INTERGER "+ "Price INTERGER ");

        idShoe = getIntent().getStringExtra("idShoe");
        nameShoe = getIntent().getStringExtra("NameShoe");
        size = getIntent().getIntExtra(size);
        price =getIntent().getIntExtra(price);
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
}