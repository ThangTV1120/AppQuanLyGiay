package com.example.appquanlygiay.Activity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.Database.Database;
import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.Models.User;
import com.example.appquanlygiay.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class activity_themhoadon_nhap extends AppCompatActivity {
    ImageView TimeNhap;

    Button btnTaoHoaDon,btnHuyNhap;

    EditText IDHoaDonnhap,NhaCC;

    TextView txtTimeNhap;

    ArrayList<HoaDonNhap> arrayHoaDonNhap;

    Database databaseHDNhap;



    int SoLuongsp;



    @Override
    protected void onCreate(Bundle savesavedInstanceState) {
        super.onCreate(savesavedInstanceState);
        setContentView(R.layout.activity_themhoadon_nhap);
        getView();
        arrayHoaDonNhap = new ArrayList<>();
        databaseHDNhap = new Database(activity_themhoadon_nhap.this,"QuanLyGiay.sqlite",null,1);

//        databaseHDNhap.QueryData("CREATE TABLE IF NOT EXISTS HoaDonNhap (idHoaDonNhap VARCHAR(30),Nhacc NVARCHAR(50),NgayNhap Date ,SoSanPham INTEGER,TongTien DOUBLE "
//                +",TKDN VARCHAR(30),"+"FOREIGN KEY (TKDN) REFERENCES User(TKDN))");

        TimeNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        activity_themhoadon_nhap.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int yearr, int monthh, int dayy) {
                                monthh=monthh+1;
                                txtTimeNhap.setText(dayy+"/"+monthh+"/"+ yearr);
//                                Toast.makeText(activity_themhoadon_nhap.this, txtTimeNhap.getText().toString(), Toast.LENGTH_SHORT).show();

                            }
                        } ,
                        year, month, day);
                datePickerDialog.show();
            }
        });

        btnTaoHoaDon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String idHoaDonNhap,nhacc,username,datenhap;
                idHoaDonNhap = IDHoaDonnhap.getText().toString();
                nhacc = NhaCC.getText().toString();
                username=getIntent().getStringExtra("TKDN");
                datenhap=txtTimeNhap.getText().toString();
                Date datehientai=null,date = null;
               // Toast.makeText(activity_themhoadon_nhap.this, idHoaDonNhap+ "  "+nhacc+" "+datenhap, Toast.LENGTH_SHORT).show();
                if(idHoaDonNhap.equals("")||nhacc.equals("")||datenhap.equals("")){
                    Toast.makeText(activity_themhoadon_nhap.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    Cursor cursor =databaseHDNhap.GetData_Condition("SELECT idHoaDonNhap FROM HoaDonNhap WHERE TKDN='"+username+"' AND idHoaDonNhap=?",new String[]{idHoaDonNhap});
                    if(cursor!=null && cursor.moveToNext()){
                        Toast.makeText(activity_themhoadon_nhap.this, "Mã hóa đơn đã tồn tại", Toast.LENGTH_SHORT).show();
                        cursor.close();
                    }
                    else{
                        try {
                            date =new java.text.SimpleDateFormat("dd/MM/yyyy").parse(datenhap);
                        }catch (ParseException e){
                            e.printStackTrace();
                        };
                        datehientai=new Date();
                        if(date.after(datehientai)){
                            Toast.makeText(activity_themhoadon_nhap.this,"Ngày nhập không được quá ngày hiện tại",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            ContentValues values=new ContentValues();
                            values.put("idHoaDonNhap",idHoaDonNhap);
                            values.put("Nhacc",nhacc);
                            values.put("NgayNhap",datenhap);
                            values.put("SoSanPham",0);
                            values.put("TongTien",0);
                            values.put("TKDN",username);
                             databaseHDNhap.insertData("HoaDonNhap",values);

                            Intent intent = new Intent(activity_themhoadon_nhap.this, activity_list_sanpham_nhap.class);
                            intent.putExtra("idHoaDonNhap",idHoaDonNhap);
                            intent.putExtra("TKDN",username);
                            intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
//                            finish();
                            Toast.makeText(activity_themhoadon_nhap.this, "Tạo hóa đơn thành công", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    }


                }

            }
        });

        btnHuyNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                Intent intent = new Intent(activity_themhoadon_nhap.this,MainActivity.class);
//                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
//                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
//                startActivity(intent);
                finish();
            }
        });
    }

    public void getData() throws ParseException {
        Cursor dataHoaDonNhap= databaseHDNhap.GetData("Select * from HoaDonNhap");
        arrayHoaDonNhap.clear();
        while (dataHoaDonNhap.moveToNext()){
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            String idHoaDonNhap = dataHoaDonNhap.getString(0);
            String nguoinhap = dataHoaDonNhap.getString(1);
            String nhacc = dataHoaDonNhap.getString(2);
            String day =dataHoaDonNhap.getString(3);
            Date ngaynhap =df.parse(day) ;
            int tongsp = dataHoaDonNhap.getInt(4);
            int TongTien = dataHoaDonNhap.getInt(5);

//            arrayHoaDonNhap.add(new HoaDonNhap(idnhap,nguoinhap,nhacc,ngaynhap,tongsp,TongTien));
        }
        dataHoaDonNhap.close();
    }

    public void getView()
    {
        TimeNhap=findViewById(R.id.buttonTimeNhapHang);
        btnTaoHoaDon=findViewById(R.id.buttonThemHoaDonNhap);
        btnHuyNhap=findViewById(R.id.buttonHuyTaoHoaDonNhap);
        txtTimeNhap=findViewById(R.id.TextNgayLapHoaDonNhap);
        NhaCC=findViewById(R.id.editTextNhaCungCap);
        IDHoaDonnhap=findViewById(R.id.IDHoaDonNhap);
    }
}
