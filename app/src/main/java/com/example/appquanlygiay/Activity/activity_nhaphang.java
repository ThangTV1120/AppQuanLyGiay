package com.example.appquanlygiay.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.R;

import java.util.ArrayList;
import java.util.Calendar;


public class activity_nhaphang extends AppCompatActivity {
    ImageButton TimeNhap;

    Button btnTaoHoaDon,btnHuyNhap;

    TextView txtTimeNhap;

    ArrayList<HoaDonNhap> arrayHoaDonNhap;

    Database databaseHoaDonNhap;

    String idNhap,nhacc,nguoinhap;

    int SoLuongsp;
    String datenhap;


    @Override
    protected void onCreate(Bundle savesavedInstanceState) {
        super.onCreate(savesavedInstanceState);
        setContentView(R.layout.activity_themhoadon_nhap);
        getView();
        arrayHoaDonNhap = new ArrayList<>();
        databaseHoaDonNhap = new Database(activity_nhaphang.this,"HoaDonNhap.sqlite",null,1);

        databaseHoaDonNhap.QueryData("CREATE TABLE IF NOT EXISTS HoaDonNhap (idNhap VARCHAR(30) primary key, NguoiNhap NVARCHAR(30),"
                + "Nhacc NVARCHAR(50)),NgayNhap Date ," +"SoSanPham INTERGER "+ "TongTien INTERGER "
                +"TKDN VARCHAR(30)"+"TKDN FOREIGN KEY (TKDN) REFERENCES User(TKDN)");

        idNhap = getIntent().getStringExtra("idNhap");
        nguoinhap = getIntent().getStringExtra("nguoinhap");
        nhacc = getIntent().getStringExtra("nhacc");
        datenhap = getIntent().getStringExtra("datenhap");




        TimeNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        activity_nhaphang.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int yearr, int monthh, int dayy) {
                                txtTimeNhap.setText(dayy+" / "+monthh+" / "+ yearr);
                            }
                        } ,
                        year, month, day);
                datePickerDialog.show();
            }
        });

        btnTaoHoaDon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(activity_nhaphang.this, activity_themhoadon_nhap.class);
                startActivity(intent);
            }
        });

        btnHuyNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(activity_nhaphang.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getData()
    {
        Cursor dataHoaDonNhap= databaseHoaDonNhap.GetData("Select * from HoaDonNhap");
        arrayHoaDonNhap.clear();
        while (dataHoaDonNhap.moveToNext()){
            String idnhap = dataHoaDonNhap.getString(0);
            String nguoinhap = dataHoaDonNhap.getString(1);
            String nhacc = dataHoaDonNhap.getString(2);
            String ngaynhap = dataHoaDonNhap.getString(3);
            int tongsp = dataHoaDonNhap.getInt(4);
            int TongTien = dataHoaDonNhap.getInt(5);

            arrayHoaDonNhap.add(new HoaDonNhap(idnhap,nguoinhap,nhacc,ngaynhap,tongsp,TongTien));
        }

    }

    public void getView()
    {
        TimeNhap=findViewById(R.id.buttonTimeNhapHang);
        btnTaoHoaDon=findViewById(R.id.buttonThemHoaDonNhap);
        btnHuyNhap=findViewById(R.id.buttonHuyTaoHoaDonNhap);
        txtTimeNhap=findViewById(R.id.TextNgayLapHoaDonNhap);
    }
}
