package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.appquanlygiay.Adapter.Hang_Trong_Kho_Adapter;
import com.example.appquanlygiay.Adapter.List_HoaDon_Nhap_Adapter;
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
    Hang_Trong_Kho_Adapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangtrongkho);
        getView();
        databaseShoes = new Database(activity_hangtrongkho.this,"QuanLyGiay.sqlite",null,1);
        arrayShoes = new ArrayList<>();
        adapter = new Hang_Trong_Kho_Adapter(this, R.layout.activity_hangtrongkho, arrayShoes);
        lv.setAdapter(adapter);

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
//                Intent intent=new Intent(activity_hangtrongkho.this, MainActivity.class);
//                intent.putExtra("TKDN",tkdn);
//                intent.putExtra("TenNguoiSuDung",name);
//                startActivity(intent);
                finish();
            }
        });

        try {
            hienthiDL();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void getView(){
        lv=findViewById(R.id.listGiayTrongKho);
        Out=findViewById(R.id.btt_Out);
        TenNguoiSD=findViewById(R.id.TenNguoiSD);
    }

    public void hienthiDL() throws ParseException {
        String username=getIntent().getStringExtra("TKDN");
        Cursor Shoe= databaseShoes.GetData_Condition("Select * from Shoe",new String[]{});
        arrayShoes.clear();
        String maShoe, nameShoee;
        int sizee,soluongg;
        double prizee;
        while (Shoe.moveToNext()){
            maShoe=Shoe.getString(0);
            nameShoee=Shoe.getString(1);
            sizee = Integer.parseInt(Shoe.getString(2));
            prizee =Double.parseDouble(Shoe.getString(3));
            soluongg=Integer.parseInt(Shoe.getString(4));
            
            arrayShoes.add(new Shoes());
        }
        adapter.notifyDataSetChanged();
    }
}