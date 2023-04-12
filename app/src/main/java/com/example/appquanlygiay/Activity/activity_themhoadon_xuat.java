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
    ImageView TimeXuat;
    Button btnXuatHoaDon,btnHuyXuat;

    EditText IDHoaDonXuat,NguoiMua;
    TextView txtTimeXuat;
    int TongTienXuat;
    ArrayList<HoaDonXuat> arrayHoaDonXuat;
    Database databaseHDXuat;

    int SoLuongsp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themhoadon_xuat);
        getView();
        arrayHoaDonXuat = new ArrayList<>();
        databaseHDXuat = new Database(activity_themhoadon_xuat.this,"QuanLyGiay.sqlite",null,1);



        TimeXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                                monthh=monthh+1;
                                txtTimeXuat.setText(dayy+" / "+monthh+" / "+ yearr);
                            }
                        } ,
                        year, month, day);
                datePickerDialog.show();
            }
        });

        btnXuatHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idHoaDonXuat,nguoimua,username,datexuat;
                idHoaDonXuat = IDHoaDonXuat.getText().toString();
                nguoimua = NguoiMua.getText().toString();
                username=getIntent().getStringExtra("TKDN");
                datexuat=txtTimeXuat.getText().toString();
                Date datehientai=null,date = null;
                // Toast.makeText(activity_themhoadon_nhap.this, idHoaDonNhap+ "  "+nhacc+" "+datenhap, Toast.LENGTH_SHORT).show();
                if(idHoaDonXuat.equals("")||nguoimua.equals("")||datexuat.equals("")){
                    Toast.makeText(activity_themhoadon_xuat.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    Cursor cursor =databaseHDXuat.GetData_Condition("SELECT idHoaDonXuat FROM HoaDonXuat WHERE TKDN='"+username+"' AND idHoaDonXuat=?",new String[]{idHoaDonXuat});
                    if(cursor!=null && cursor.moveToNext()){
                        Toast.makeText(activity_themhoadon_xuat.this, "Mã hóa đơn đã tồn tại", Toast.LENGTH_SHORT).show();
                        cursor.close();
                    }
                    else{
                        try {
                            date =new java.text.SimpleDateFormat("dd/MM/yyyy").parse(datexuat);
                        }catch (ParseException e){
                            e.printStackTrace();
                        };
                        datehientai=new Date();
                        if(date.after(datehientai)){
                            Toast.makeText(activity_themhoadon_xuat.this,"Ngày xuất không được quá ngày hiện tại",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            ContentValues values=new ContentValues();
                            values.put("idHoaDonXuat",idHoaDonXuat);
                            values.put("Nguoimua",nguoimua);
                            values.put("NgayXuat",datexuat);
                            values.put("SoSanPham",0);
                            values.put("TongTien",0);
                            values.put("TKDN",username);
                            databaseHDXuat.insertData("HoaDonxuat",values);

                            Intent intent = new Intent(activity_themhoadon_xuat.this, activity_list_sanpham_xuat.class);
                            intent.putExtra("idHoaDonXuat",idHoaDonXuat);
                            intent.putExtra("TKDN",username);
                            intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
//                            finish();
                            Toast.makeText(activity_themhoadon_xuat.this, "Tạo hóa đơn thành công", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    }


                }

            }
        });

        btnHuyXuat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                Intent intent = new Intent(activity_themhoadon_xuat.this,MainActivity.class);
//                intent.putExtra("TKDN",getIntent().getStringExtra("TKDN"));
//                intent.putExtra("TenNguoiSuDung",getIntent().getStringExtra("TenNguoiSuDung"));
//                startActivity(intent);
                finish();

            }
        });
    }
    public void getData() throws ParseException {
        Cursor dataHoaDonXuat= databaseHDXuat.GetData("Select * from HoaDonXuat");
        arrayHoaDonXuat.clear();
        while (dataHoaDonXuat.moveToNext()){
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            String idHoaDonXuat = dataHoaDonXuat.getString(0);
            String nguoinhap = dataHoaDonXuat.getString(1);
            String nhacc = dataHoaDonXuat.getString(2);
            String day =dataHoaDonXuat.getString(3);
            Date ngayxuat =df.parse(day) ;
            int tongsp = dataHoaDonXuat.getInt(4);
            int TongTien = dataHoaDonXuat.getInt(5);

//            arrayHoaDonXuat.add(new HoaDonXuat(idnhap,nguoinhap,nhacc,ngaynhap,tongsp,TongTien));
        }
        dataHoaDonXuat.close();
    }

    public void getView(){
        IDHoaDonXuat=findViewById(R.id.IDHoaDonXuat);
        NguoiMua=findViewById(R.id.editTextNguoiMua);
        TimeXuat=findViewById(R.id.buttonTimeXuatHang);
        txtTimeXuat=findViewById(R.id.TextViewNgayLapHoaDonXuat);
        btnXuatHoaDon=findViewById(R.id.buttonXuatHoaDon);
        btnHuyXuat=findViewById(R.id.buttonHuyTaoHoaDonXuat);
    }
}
