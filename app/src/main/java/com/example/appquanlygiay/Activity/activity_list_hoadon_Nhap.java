package com.example.appquanlygiay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appquanlygiay.Adapter.List_HoaDon_Nhap_Adapter;
import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class activity_list_hoadon_Nhap extends AppCompatActivity {
    ListView lv;
    ImageView dangxuat;
    TextView TenNguoiSD;
    Database database;
    List_HoaDon_Nhap_Adapter adapter;
    ArrayList<HoaDonNhap> ListHD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoadon_nhap);
        getView();
        database = new Database(activity_list_hoadon_Nhap.this,"QuanLyGiay.sqlite",null,1);
        String name =getIntent().getStringExtra("TenNguoiSuDung");
        TenNguoiSD.setText(name);
        String username=getIntent().getStringExtra("TKDN");
        ListHD=new ArrayList<>();
        adapter=new List_HoaDon_Nhap_Adapter(this,R.layout.input_ds_hoadon_nhap,ListHD);
        lv.setAdapter(adapter);


        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_list_hoadon_Nhap.this, MainActivity.class);
                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
            }
        });
        try {
            hienthiDL();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String username,idHD;
                username=ListHD.get(i).getTKDN();
                idHD=ListHD.get(i).getIdHoaDonNhap();
                Intent intent=new Intent(activity_list_hoadon_Nhap.this, DS_SP_TrongHD_Nhap.class);
                intent.putExtra("TKDN",username);
                intent.putExtra("idHoaDonNhap",idHD);
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
                Toast.makeText(activity_list_hoadon_Nhap.this, idHD, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void getView(){
        lv=findViewById(R.id.list_HoaDonNhap);
        dangxuat=findViewById(R.id.btt_DangXuat);
        TenNguoiSD=findViewById(R.id.TenNguoiSD);
    }
    public void hienthiDL() throws ParseException {
        String username=getIntent().getStringExtra("TKDN");
        Cursor HoaDonNhap= database.GetData_Condition("Select * from HoaDonNhap WHERE TKDN=?",new String[]{username});
        ListHD.clear();
        String idHD,nhacc,tkdn;
        Date ngaynhap;
        Integer SL;
        Double tongtien;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (HoaDonNhap.moveToNext()){
            idHD=HoaDonNhap.getString(0);
            nhacc=HoaDonNhap.getString(1);

            ngaynhap=dateFormat.parse(HoaDonNhap.getString(2));
            SL=HoaDonNhap.getInt(3);
            tongtien=HoaDonNhap.getDouble(4);
            tkdn=HoaDonNhap.getString(5);
            //ListHD.add(new HoaDonNhap(idHD,nhacc,ngaynhap,SL,tongtien));
            ListHD.add(new HoaDonNhap(idHD,nhacc,ngaynhap,SL,tongtien,tkdn));
        }
        adapter.notifyDataSetChanged();
    }
}
