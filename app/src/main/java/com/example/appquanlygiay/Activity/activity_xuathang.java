package com.example.appquanlygiay.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.ChiTietHoaDonXuat;
import com.example.appquanlygiay.R;

import java.text.ParseException;
import java.util.ArrayList;

public class activity_xuathang extends AppCompatActivity {
    EditText txtMaXuat, txtTen, txtSize, txtGia, txtSoLuong;
    Button btnXuatHang;
    Spinner spinnerSize;
    ArrayList<ChiTietHoaDonXuat> arrayHangXuat;
    Database databaseXuatHang,databaseHangTrongKho;
    String idHoaDonXuat,nguoimua,username,size;
    String sizeString[]={"39","40","41","42"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuathang);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sizeString);
        getView();

        spinnerSize.setAdapter(adapter);

        arrayHangXuat= new ArrayList<>();

        databaseXuatHang = new Database(activity_xuathang.this,"QuanLyGiay.sqlite",null,1);

        spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index=spinnerSize.getSelectedItemPosition();
                size=sizeString[index];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        idHoaDonXuat=getIntent().getStringExtra("idHoaDonXuat");
        username=getIntent().getStringExtra("TKDN");

        btnXuatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tensp = txtTen.getText().toString().trim();
                String gia = txtGia.getText().toString();
                String masp = txtMaXuat.getText().toString();
                String soluong = txtSoLuong.getText().toString();
                if (masp.equals("") || tensp.equals("") || gia.equals("") || soluong.equals("")) {
                    Toast.makeText(activity_xuathang.this, "Vui lòng nhập đủ thông tin sản phẩm", Toast.LENGTH_SHORT).show();
                } else {
                    Integer s = Integer.valueOf(size);
                    int dongia =Integer.parseInt(gia);
                    Integer sl = Integer.valueOf(soluong);
                    String tkdn = username;
                    String idHD = idHoaDonXuat;
                    Cursor hang = databaseHangTrongKho.GetData_Condition("SELECT SoLuong FROM HangTrongKho WHERE MaSP=? "
                            ,new String[]{ masp});
                    int val = Integer.parseInt(hang.getString(0));
                    if ((hang == null || val <sl)  && hang.moveToNext()) {
                        Toast.makeText(activity_xuathang.this, "Sản phẩm đã hết hàng ", Toast.LENGTH_SHORT).show();
                        hang.close();
                    } else {
                        sl=val-sl;
                        ContentValues values = new ContentValues();
                        values.put("MaSP", masp);
                        values.put("TenSP", tensp);
                        values.put("Size", s);
                        values.put("Gia", dongia);
                        values.put("SoLuong", sl);
                        values.put("TKDN", username);
                        values.put("idHoaDonXuat", idHoaDonXuat);

                        ContentValues valueUp = new ContentValues();
                        values.put("Gia", dongia);
                        values.put("SoLuong",sl);

                        databaseHangTrongKho.updateData("HangTrongKho ", valueUp,"idHoaDonXuat",
                                new String[]{sl.toString(), String.valueOf(dongia)} );

                        databaseXuatHang.insertData("ChiTietHoaDonXuat", values);
                        Cursor cursor = databaseXuatHang.GetData_Condition("Select count(MaSP),sum(Gia*SoLuong) FROM ChiTietHoaDonNhap " +
                                "Where TKDN=? AND idHoaDonNhap=? GROUP BY(TKDN)", new String[]{tkdn, idHD});
                        double tong = 0;
                        int soSP = 0;
                        while (cursor.moveToNext()) {
                            soSP = Integer.valueOf(cursor.getString(0));
                            tong = Double.parseDouble(cursor.getString(1));
                        }
                        cursor.close();
                        // Cursor soSP = databaseNhapHang.GetData_Condition("Select count(MaSP) FROM ChiTietHoaDonNhap Where TKDN=? AND idHoaDonNhap=? GROUP BY(TKDN)",new String[]{tkdn,idHD} );
                        //double tong = Double.parseDouble(tongtien);

                        ContentValues hoadon = new ContentValues();
                        hoadon.put("TongTien", tong);
                        hoadon.put("SoSanPham", soSP);
                        databaseXuatHang.updateData("HoaDonXuat", hoadon, "TKDN=? AND idHoaDonNhap=? ", new String[]{tkdn, idHD});

                        Intent intent = new Intent(activity_xuathang.this, activity_list_sanpham_xuat.class);
                        intent.putExtra("idHoaDonNhap", idHoaDonXuat);
                        intent.putExtra("TKDN", username);
                        intent.putExtra("TenNguoiSuDung", getIntent().getStringExtra("TenNguoiSuDung"));
                        startActivity(intent);
                        Toast.makeText(activity_xuathang.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(activity_xuathang.this, activity_list_sanpham_xuat.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void getData(String username)  {
        Cursor cursor =databaseXuatHang.GetData_Condition("SELECT * FROM ChiTietHoaDonXuat WHERE TKDN=?",new String[]{username});
        arrayHangXuat.clear();
        while (cursor.moveToNext()){
            String masp=cursor.getString(0);
            String tensp=cursor.getString(1);
            Integer size=cursor.getInt(2);
            int gia=cursor.getInt(3);
            int soluong=cursor.getInt(4);
            String TKDN=cursor.getString(5);
            String idHoaDonXuat=cursor.getString(6);
            arrayHangXuat.add(new ChiTietHoaDonXuat(masp,tensp,size,gia,soluong,idHoaDonXuat,TKDN));

        }
        cursor.close();
    }

    public void getView(){
        txtMaXuat = findViewById(R.id.txtMaSP);
        txtTen = findViewById(R.id.txtTenSP);
        txtSize = findViewById(R.id.txtSize);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        txtGia = findViewById(R.id.txtGia);
        btnXuatHang = findViewById(R.id.btnXuatHang);
    }

    public String Size(int index){
        return sizeString[index];
    }
}
