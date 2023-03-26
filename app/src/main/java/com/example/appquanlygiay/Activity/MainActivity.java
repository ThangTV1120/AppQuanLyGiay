package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.R;

public class MainActivity extends AppCompatActivity {
//    Button ;
    Database database;
    ImageView dangxuat, btt_hangTrongkho,btt_nhapHang,btt_xuatHang,btt_hoadonNhap,btt_hoadonXuat;
   TextView TenNguoiSD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        String name =getIntent().getStringExtra("TenNguoiSuDung");
        TenNguoiSD.setText(name);
        String username=getIntent().getStringExtra("TKDN");

        database = new Database(MainActivity.this,"QuanLyGiay.sqlite",null,1);

        database.QueryData(("CREATE TABLE IF NOT EXISTS HoaDonNhap(idHoaDonNhap VARCHAR(30) primary key ,"
                + "Nhacc NVARCHAR(50)" + ",NgayNhap Date ," + "SoSanPham INTEGER, "
                +"TongTien DOUBLE," + "TKDN VARCHAR(30)," +"FOREIGN KEY (TKDN) REFERENCES User(TKDN))"));

        database.QueryData("CREATE TABLE IF NOT EXISTS HoaDonXuat(idHoaDonXuat VARCHAR(30) primary key," +
                "NguoiMua NVARCHAR(50),NgayXuat Date ," +"SoSanPham INTERGER "+ "TongTien INTERGER, "
                +"TKDN VARCHAR(30),"+"FOREIGN KEY (TKDN) REFERENCES User(TKDN))");

        database.QueryData("CREATE TABLE IF NOT EXISTS ChiTietHoaDonNhap(MaSP VARCHAR(30),TenSP NVARCHAR(40)" +
                ",Size INTEGER,Gia DOUBLE,SoLuong INTEGER," + "TKDN VARCHAR(30)," +
                "idHoaDonNhap VARCHAR(30),"+"FOREIGN KEY (TKDN) REFERENCES User(TKDN))");

        database.QueryData("CREATE TABLE IF NOT EXISTS ChiTietHoaDonXuat (MaSP VARCHAR(30),TenSP NVARCHAR(40)" +
                ",Size INTEGER,GiaBan DOUBLE,SoLuong INTEGER," + "TKDN VARCHAR(30)," +
                "idHoaDonXuat VARCHAR(30),"+"FOREIGN KEY (TKDN) REFERENCES User(TKDN))");

        database.QueryData("CREATE TABLE IF NOT EXISTS Shoes (idShoe VARCHAR(30) PRIMARY KEY, NameShoe NVARCHAR(30),"
                + "SoLuong INTERGER"+"Size INTERGER ,"+ "Gia DOUBLE )");

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this, Login.class);
//                startActivity(intent);
                finish();
            }
        });
        btt_hangTrongkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, activity_hangtrongkho.class);
                intent.putExtra("TKDN",username);
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
            }
        });
       btt_nhapHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, activity_themhoadon_nhap.class);
                intent.putExtra("TKDN",username);
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
            }
        });
        btt_xuatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, activity_themhoadon_xuat.class);
                intent.putExtra("TKDN",username);
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
            }
        });
        btt_hoadonNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, activity_list_hoadon_Nhap.class);
                intent.putExtra("TKDN",username);
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
            }
        });
    }
    public void getView(){
        dangxuat=findViewById(R.id.btt_DangXuat);
        btt_hangTrongkho=findViewById(R.id.btt_hangtrongkho);
        btt_nhapHang=findViewById(R.id.btt_nhaphang);
        btt_xuatHang=findViewById(R.id.btt_xuathang);
        btt_hoadonNhap=findViewById(R.id.btt_hoadonnhap);
        btt_hoadonXuat=findViewById(R.id.btt_hoadonxuat);
        TenNguoiSD=findViewById(R.id.TenNguoiSD);
    }
}