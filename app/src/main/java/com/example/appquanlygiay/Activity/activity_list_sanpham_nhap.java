package com.example.appquanlygiay.Activity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.appquanlygiay.Adapter.List_SanPham_Nhap_Adapter;
import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.ChiTietHoaDonNhap;
import com.example.appquanlygiay.R;

import java.util.ArrayList;

public class activity_list_sanpham_nhap extends AppCompatActivity {
    Button btnThem,btnHuy;
    Database database;
    ArrayList<ChiTietHoaDonNhap> arrayListSP;
    List_SanPham_Nhap_Adapter adapter;
    ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sanpham_nhap);
        getView();
        database = new Database(activity_list_sanpham_nhap.this,"QuanLyGiay.sqlite",null,1);
        arrayListSP=new ArrayList<>();
        adapter=new List_SanPham_Nhap_Adapter(activity_list_sanpham_nhap.this,R.layout.sanpham_input_output,arrayListSP);
        lv.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_list_sanpham_nhap.this, activity_nhaphang.class);
                intent.putExtra("idHoaDonNhap",getIntent().getStringExtra("idHoaDonNhap"));
                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_list_sanpham_nhap.this, MainActivity.class);
                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
            }
        });
        hienthiDL();

    }
    public void hienthiDL(){
        String username,idHD;
        username=getIntent().getStringExtra("TKDN");
        idHD=getIntent().getStringExtra("idHoaDonNhap");
        Cursor dataListSPNhap=database.GetData_Condition("SELECT * FROM ChiTietHoaDonNhap WHERE TKDN=? AND idHoaDonNhap=? ",new String[]{username,idHD});
        String IDShoe,TenSP,TKDN,idHoaDonNhap;
        Integer Size, SoLuong;
        double Gia;
        arrayListSP.clear();
        while (dataListSPNhap.moveToNext()){
            IDShoe=dataListSPNhap.getString(0);
            TenSP=dataListSPNhap.getString(1);
            Size=dataListSPNhap.getInt(2);
            Gia=dataListSPNhap.getDouble(3);
            SoLuong=dataListSPNhap.getInt(4);
            TKDN=dataListSPNhap.getString(5);
            idHoaDonNhap=dataListSPNhap.getString(6);
            arrayListSP.add(new ChiTietHoaDonNhap(IDShoe,TenSP,Size,Gia,SoLuong,TKDN,idHoaDonNhap));

        }
//        dataListSPNhap.close();
        adapter.notifyDataSetChanged();
    }
    public void getView()
    {
        btnThem=findViewById(R.id.btnThem);
        btnHuy=findViewById(R.id.btnHuy);
        lv=findViewById(R.id.listxuathang);
    }
    public void XoaSP(int i){
        String tkdn,idHD,masp;
        tkdn= arrayListSP.get(i).getTKDN();
        idHD=arrayListSP.get(i).getIdHoaDonNhap();
        masp=arrayListSP.get(i).getIDShoe();
        Toast.makeText(this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
       database.deleteData("ChiTietHoaDonNhap","TKDN=? AND idHoaDonNhap=? AND MaSP=?",new String[]{tkdn,idHD,masp});
      // if(s>0) Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        Cursor cursor = database.GetData_Condition("Select count(MaSP),sum(Gia*SoLuong) FROM ChiTietHoaDonNhap Where TKDN=? AND idHoaDonNhap=? GROUP BY(TKDN)",new String[]{tkdn,idHD} );
        double tong=0;
        int soSP=0;
        while(cursor.moveToNext()){
            soSP= Integer.valueOf(cursor.getString(0));
            tong=Double.parseDouble(cursor.getString(1));
        }
        cursor.close();

        ContentValues hoadon=new ContentValues();
        hoadon.put("TongTien",tong);
        hoadon.put("SoSanPham",soSP);
        database.updateData("HoaDonNhap",hoadon,"TKDN=? AND idHoaDonNhap=? ",new String[]{tkdn,idHD});
        hienthiDL();
    }
}
