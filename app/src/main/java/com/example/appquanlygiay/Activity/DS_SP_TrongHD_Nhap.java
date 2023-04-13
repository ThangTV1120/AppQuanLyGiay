package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.appquanlygiay.Adapter.List_SanPham_TrongHD_Nhap_Adapter;
import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.ChiTietHoaDonNhap;
import com.example.appquanlygiay.R;

import java.util.ArrayList;

public class DS_SP_TrongHD_Nhap extends AppCompatActivity {
    Database database;
    ArrayList<ChiTietHoaDonNhap> arrayListSP;
    List_SanPham_TrongHD_Nhap_Adapter adapter;
    ListView lv;
    ImageView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_sp_tronghd_nhap);
        getView();
        database = new Database(DS_SP_TrongHD_Nhap.this,"QuanLyGiay.sqlite",null,1);
        arrayListSP=new ArrayList<>();
        adapter=new List_SanPham_TrongHD_Nhap_Adapter(this,R.layout.sanpham,arrayListSP);
        lv.setAdapter(adapter);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(DS_SP_TrongHD_Nhap.this, activity_list_hoadon_Nhap.class);
//                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
//                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
//                startActivity(intent);
                finish();
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
        out=findViewById(R.id.btt_Out);
        lv=findViewById(R.id.list_sp);
    }
}