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
    Button btnThemHang,btnHuyThemHang;
    String idHoaDonNhap,nhacc,username,size;
    String sizeString[]={"39","40","41","42"};
    int SoLuongsp;
    String datenhap;
    ArrayList<ChiTietHoaDonNhap> arrayHang;
    Database databaseNhapHang,databaseShoe;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhaphang);

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sizeString);

        getView();
        spinnerSize.setAdapter(adapter);
        arrayHang=new ArrayList<>();

        databaseNhapHang = new Database(activity_nhaphang.this,"QuanLyGiay.sqlite",null,1);
        databaseShoe = new Database(activity_nhaphang.this,"QuanLyGiay.sqlite",null,1);
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
        idHoaDonNhap=getIntent().getStringExtra("idHoaDonNhap");
        username=getIntent().getStringExtra("TKDN");
        btnThemHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensp=txtTen.getText().toString().trim();
                String gia=txtGia.getText().toString();
                String masp=txtMa.getText().toString();
                String soluong=txtSoLuong.getText().toString();
                if(masp.equals("")||tensp.equals("")||gia.equals("")||soluong.equals("")){
                    Toast.makeText(activity_nhaphang.this, "Vui lòng nhập đủ thông tin sản phẩm", Toast.LENGTH_SHORT).show();
                }
                else
                {
                Integer s=Integer.valueOf(size);
                double dongia=Double.parseDouble(gia);
                Integer sl=Integer.valueOf(soluong);

                String tkdn=username;
                String idHD=idHoaDonNhap;

                    Cursor hang = databaseNhapHang.GetData_Condition("SELECT MaSP FROM ChiTietHoaDonNhap WHERE MaSP=? AND TKDN=? AND idHoaDonNhap=? ",new String[]{masp,tkdn,idHD});
                    if(hang!=null && hang.moveToNext()){
                        Toast.makeText(activity_nhaphang.this,"Mã sản phẩm đã tồn tại",Toast.LENGTH_SHORT).show();
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
                        values.put("idHoaDonNhap",idHoaDonNhap);
                        databaseNhapHang.insertData("ChiTietHoaDonNhap",values);
                        Cursor cursor = databaseNhapHang.GetData_Condition("Select count(MaSP),sum(Gia*SoLuong) FROM ChiTietHoaDonNhap Where TKDN=? AND idHoaDonNhap=? GROUP BY(TKDN)",new String[]{tkdn,idHD} );
                        double tong=0;
                        int soSP=0;
                        while(cursor.moveToNext()){
                            soSP= Integer.valueOf(cursor.getString(0));
                            tong=Double.parseDouble(cursor.getString(1));
                        }
                        cursor.close();
                       // Cursor soSP = databaseNhapHang.GetData_Condition("Select count(MaSP) FROM ChiTietHoaDonNhap Where TKDN=? AND idHoaDonNhap=? GROUP BY(TKDN)",new String[]{tkdn,idHD} );
                        //double tong = Double.parseDouble(tongtien);

                        ContentValues hoadon=new ContentValues();
                        hoadon.put("TongTien",tong);
                        hoadon.put("SoSanPham",soSP);
                        databaseNhapHang.updateData("HoaDonNhap",hoadon,"TKDN=? AND idHoaDonNhap=? ",new String[]{tkdn,idHD});
                        Intent intent = new Intent(activity_nhaphang.this, activity_list_sanpham_nhap.class);
                        intent.putExtra("idHoaDonNhap",idHoaDonNhap);
                        intent.putExtra("TKDN",username);
                        intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
//                        finish();
                        startActivity(intent);
                        Toast.makeText(activity_nhaphang.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();

                        ContentValues update = new ContentValues();
                            update.put("idShoe",masp);
                            update.put("NameShoe",tensp);
                            update.put("Size",s);
                            update.put("Gia",gia);
                            update.put("SoLuong",soluong);
                            Toast.makeText(activity_nhaphang.this, "Đax ", Toast.LENGTH_SHORT).show();

                            databaseShoe.insertData("Shoes",update);

//                        else
//                        {
//                            Cursor slsp = databaseShoe.GetData_Condition("SELECT SoLuong FROM Shoes where idShoe=?",new String[]{masp});
//                            slsp.moveToFirst();
//                            int soluongmoi=slsp.getInt(0)+sl;
//                            update.put("SoLuong",soluongmoi);
//                            databaseShoe.updateData("Shoes",update,"idShoe =?",new String[]{masp});
//
//                        }

                    }
                }

            }
        });
        btnHuyThemHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_nhaphang.this, activity_list_sanpham_nhap.class);
                intent.putExtra("idHoaDonNhap",idHoaDonNhap);
                intent.putExtra("TKDN",username);
                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
                finish();
                startActivity(intent);
//                finish();
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
        btnHuyThemHang=findViewById(R.id.btnHuyThemHang);
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
            String idHoaDonNhap=cursor.getString(6);
            arrayHang.add(new ChiTietHoaDonNhap(masp,tensp,size,gia,soluong,TKDN,idHoaDonNhap));
        }
        cursor.close();
    }
    public String Size(int index){
        return sizeString[index];
    }

}
