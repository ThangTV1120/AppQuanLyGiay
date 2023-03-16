package com.example.appquanlygiay.Activity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.ChiTietHoaDonNhap;
import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.R;

import java.util.ArrayList;


public class activity_nhaphang extends AppCompatActivity {
    EditText txtMa,txtTen,txtGia,txtSoLuong;
    Spinner spinnerSize;
    Button btnThemHang;
    String idHoaDon,nhacc,username,size;
    String sizeString[]={"39","40","41","42"};
    int SoLuongsp;
    String datenhap;
    ArrayList<ChiTietHoaDonNhap> arrayHang;
    Database databaseNhapHang;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhaphang);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sizeString);
        getView();
        spinnerSize.setAdapter(adapter);
        arrayHang=new ArrayList<>();
        databaseNhapHang = new Database(activity_nhaphang.this,"QuanLyGiay.sqlite",null,1);
        databaseNhapHang.QueryData("CREATE TABLE IF NOT EXISTS ChiTietHoaDonNhap (MaSP VARCHAR(30),TenSP NVARCHAR(40),Size INTEGER,Gia DOUBLE,SoLuong INTEGER,"
                + "TKDN VARCHAR(30),idHoaDon VARCHAR(30),"+"FOREIGN KEY (idHoaDon) REFERENCES HoaDonNhap(idHoaDon),FOREIGN KEY (TKDN) REFERENCES User(TKDN))");
        spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    int index=spinnerSize.getSelectedItemPosition();
                    size=sizeString[index];
                Toast.makeText(activity_nhaphang.this,"1" , Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        idHoaDon=getIntent().getStringExtra("idHoaDon");
        username=getIntent().getStringExtra("TKDN");
        btnThemHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensp=txtTen.getText().toString().trim();
                String gia=txtGia.getText().toString();
                String masp=txtMa.getText().toString().trim();
                String soluong=txtSoLuong.getText().toString();
                if(masp.equals("")||tensp.equals("")||gia.equals("")||soluong.equals("")){
                    Toast.makeText(activity_nhaphang.this, "Vui long nhap du thong tin san pham", Toast.LENGTH_SHORT).show();
                }
                else{
                Integer s=Integer.valueOf(size);
                double dongia=Double.parseDouble(gia);
                Integer sl=Integer.valueOf(soluong);
                String tkdn=username;
                    Cursor hang = databaseNhapHang.GetData_Condition("SELECT MaSP FROM ChiTietHoaDonNhap WHERE MaSP=? AND TKDN=?",new String[]{masp,tkdn});
                    if(hang!=null && hang.moveToNext()){
                        Toast.makeText(activity_nhaphang.this,"Ma dang nhap da ton tai",Toast.LENGTH_SHORT).show();
                        hang.close();
                    }
                    else{
                        ContentValues values=new ContentValues();
                        values.put("MaSP",masp);
                        values.put("TenSP",tensp);
                        values.put("Size",s);
                        values.put("Gia",dongia);
                        values.put("SoLuong",sl);
                        values.put("TKDN",username);
                        values.put("idHoaDon",idHoaDon);
                        databaseNhapHang.insertData("ChiTietHoaDonNhap",values);
                        Intent intent = new Intent(activity_nhaphang.this, activity_list_sanpham_nhap.class);
                        startActivity(intent);
                        Toast.makeText(activity_nhaphang.this, "Them Thanh cong", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void getView()
    {
        txtMa=findViewById(R.id.txtMaSP);
        txtTen=findViewById(R.id.txtTenSP);
       spinnerSize=findViewById(R.id.ListSize);
        txtGia=findViewById(R.id.txtGia);
        txtSoLuong=findViewById(R.id.txtSoLuong);
        btnThemHang=findViewById(R.id.btnThemHang);
    }
    public void getData(String username){
        Cursor cursor =databaseNhapHang.GetData_Condition("SELECT * FROM ChiTietHoaDonNhap WHERE TKDN=?",new String[]{username});
        arrayHang.clear();
        while(cursor.moveToNext()){
            String masp=cursor.getString(0);
            String tensp=cursor.getString(1);
            Integer size=cursor.getInt(2);
            double gia=cursor.getDouble(3);
            int soluong=cursor.getInt(4);
            String TKDN=cursor.getString(5);
            String idHoaDon=cursor.getString(6);
            arrayHang.add(new ChiTietHoaDonNhap(masp,tensp,size,gia,soluong,TKDN,idHoaDon));
        }
        cursor.close();
    }
    public String Size(int index){
        return sizeString[index];
    }

}
