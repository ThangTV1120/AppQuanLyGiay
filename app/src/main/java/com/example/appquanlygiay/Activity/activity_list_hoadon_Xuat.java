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
import com.example.appquanlygiay.Adapter.List_HoaDon_Xuat_Adapter;
import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.Models.HoaDonXuat;
import com.example.appquanlygiay.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class activity_list_hoadon_Xuat extends AppCompatActivity {
    ListView lv;
    ImageView dangxuat;
    TextView TenNguoiSD;
    Database database;
    List_HoaDon_Xuat_Adapter adapter;
    ArrayList<HoaDonXuat> ListHD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoadon_xuat);
        database = new Database(activity_list_hoadon_Xuat.this, "QuanLyGiay.sqlite", null, 1);
        String name = getIntent().getStringExtra("TenNguoiSuDung");
        TenNguoiSD.setText(name);
        String username = getIntent().getStringExtra("TKDN");
        ListHD = new ArrayList<>();
        adapter = new List_HoaDon_Xuat_Adapter(this, R.layout.input_ds_hoadon_xuat, ListHD);
        lv.setAdapter(adapter);

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(activity_list_hoadon_Xuat.this, MainActivity.class);
//                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
//                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
//                startActivity(intent);
                finish();
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
                String username, idHD;
                username = ListHD.get(i).getTKKH();
                idHD = ListHD.get(i).getIdXuat();
                Intent intent = new Intent(activity_list_hoadon_Xuat.this, DS_SP_TrongHD_Xuat.class);
                intent.putExtra("TKDN", username);
                intent.putExtra("idHoaDonXuat", idHD);
                intent.putExtra("TenNguoiSuDung", getIntent().getStringExtra("TenNguoiSuDung"));
                startActivity(intent);
                Toast.makeText(activity_list_hoadon_Xuat.this, idHD, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getView() {
        lv = findViewById(R.id.list_HoaDonXuat);
        dangxuat = findViewById(R.id.btt_DangXuat);
        TenNguoiSD = findViewById(R.id.TenNguoiSD);
    }

    public void hienthiDL() throws ParseException {
        String username = getIntent().getStringExtra("TKDN");
        Cursor HoaDonXuat = database.GetData_Condition("Select * from HoaDonXuat WHERE TKDN=?", new String[]{username});
        ListHD.clear();
        String idHD, nguoimua, tkkh;
        Date ngayxuat;
        Integer SL;
        Double tongtien;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (HoaDonXuat.moveToNext()) {
            idHD = HoaDonXuat.getString(0);
            nguoimua = HoaDonXuat.getString(1);

            ngayxuat = dateFormat.parse(HoaDonXuat.getString(2));
            SL = HoaDonXuat.getInt(3);
            tongtien = HoaDonXuat.getDouble(4);
            tkkh = HoaDonXuat.getString(5);
            //ListHD.add(new HoaDonNhap(idHD,nhacc,ngaynhap,SL,tongtien));
            ListHD.add(new HoaDonXuat(idHD, nguoimua, ngayxuat, SL, tongtien, tkkh));
        }
        adapter.notifyDataSetChanged();
    }
}
