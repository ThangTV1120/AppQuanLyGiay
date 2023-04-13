package com.example.appquanlygiay.Activity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.Adapter.List_SanPham_Adapter;
import com.example.appquanlygiay.Adapter.List_SanPham_Xuat_Adapter;
import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.ChiTietHoaDonXuat;
import com.example.appquanlygiay.R;

import java.util.ArrayList;

public class DS_SP_TrongHD_Xuat extends AppCompatActivity {
    Database database;
    ArrayList<ChiTietHoaDonXuat> arrayListSP;
    List_SanPham_Adapter adapter;
    ListView lv;
    ImageView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_sp_tronghd_xuat);
        getView();
        database = new Database(DS_SP_TrongHD_Xuat.this,"QuanLyGiay.sqlite",null,1);
        arrayListSP=new ArrayList<>();
        adapter=new List_SanPham_Xuat_Adapter(this,R.layout.sanpham,arrayListSP);
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
        idHD=getIntent().getStringExtra("idHoaDonXuat");
        Cursor dataListSPXuat=database.GetData_Condition("SELECT * FROM ChiTietHoaDonXuat WHERE TKDN=? AND idHoaDonXuat=? ",new String[]{username,idHD});
        String IDShoe,TenSP,TKKH,idHoaDonXuat;
        Integer Size, SoLuong;
        double Gia;
        arrayListSP.clear();
        while (dataListSPXuat.moveToNext()){
            IDShoe=dataListSPXuat.getString(0);
            TenSP=dataListSPXuat.getString(1);
            Size=dataListSPXuat.getInt(2);
            Gia=dataListSPXuat.getDouble(3);
            SoLuong=dataListSPXuat.getInt(4);
            TKKH=dataListSPXuat.getString(5);
            idHoaDonXuat=dataListSPXuat.getString(6);
            arrayListSP.add(new ChiTietHoaDonXuat(IDShoe, TenSP, Size, Gia, SoLuong, TKKH, idHoaDonXuat));

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
