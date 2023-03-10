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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.Models.HoaDonXuat;
import com.example.appquanlygiay.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class activity_themhoadon_xuat extends AppCompatActivity
{
    ImageButton btnTimeXuat;

    Button btnXuatHoaDon,btnHuyXuat;
    TextView textViewTimeXuat;
    String idXuat, nguoimua, nguoinhap;
    String datexuat;

    int TongTienXuat;
    ArrayList<HoaDonXuat> arrayHoaDonXuat;
    Database databaseHoaDonXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themhoadon_xuat);
        getView();
        arrayHoaDonXuat = new ArrayList<>();
        databaseHoaDonXuat = new Database(activity_themhoadon_xuat.this,"HoaDonXuat.sqlite",null,1);

        databaseHoaDonXuat.QueryData("CREATE TABLE IF NOT EXISTS HoaDonXuat (idXuat VARCHAR(30) primary key, NguoiNhap NVARCHAR(30),"
                + "NguoiMua NVARCHAR(50)),NgayXuat Date ," +"SoSanPham INTERGER "+ "TongTien INTERGER "
                +"TKDN VARCHAR(30)"+"TKDN FOREIGN KEY (TKDN) REFERENCES User(TKDN)");

        idXuat = getIntent().getStringExtra("idNhap");
        nguoinhap = getIntent().getStringExtra("nguoinhap");
        nguoimua = getIntent().getStringExtra("nguoimua");
        datexuat =getIntent().getStringExtra("datenhap");

        textViewTimeXuat.setText(datexuat);


        btnTimeXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_themhoadon_xuat.this,"Djfkd",Toast.LENGTH_LONG);
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        activity_themhoadon_xuat.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int yearr, int monthh, int dayy) {
                                textViewTimeXuat.setText(dayy+" / "+monthh+" / "+ yearr);
                            }
                        } ,
                        year, month, day);
                datePickerDialog.show();
            }
        });

        btnXuatHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_themhoadon_xuat.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnHuyXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_themhoadon_xuat.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
    public void getData() throws ParseException {
        Cursor dataHoaDonXuat= databaseHoaDonXuat.GetData("Select * from HoaDonXuat");
        arrayHoaDonXuat.clear();
        while (dataHoaDonXuat.moveToNext()){
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            String idXuat = dataHoaDonXuat.getString(0);
            String nguoinhap = dataHoaDonXuat.getString(1);
            String nguoimua = dataHoaDonXuat.getString(2);
            String day =dataHoaDonXuat.getString(3);
            Date ngaynhap =df.parse(day) ;
            int tongsp = dataHoaDonXuat.getInt(4);
            int TongTien = dataHoaDonXuat.getInt(5);

            arrayHoaDonXuat.add(new HoaDonXuat(idXuat,nguoinhap,nguoimua,ngaynhap,tongsp,TongTien));
        }
        dataHoaDonXuat.close();
    }
    public void getView(){
        btnTimeXuat=findViewById(R.id.buttonTimeXuatHang);
        textViewTimeXuat=findViewById(R.id.TextViewNgayLapHoaDonXuat);
        btnXuatHoaDon=findViewById(R.id.buttonXuatHoaDon);
        btnHuyXuat=findViewById(R.id.buttonHuyTaoHoaDonXuat);
    }
}
