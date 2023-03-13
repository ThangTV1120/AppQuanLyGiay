package com.example.appquanlygiay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.R;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


=======
>>>>>>> c211b9492c33ba0124d93d32333d7e6d24e996d5
public class activity_nhaphang extends AppCompatActivity {
    EditText txtMa,txtTen,txtSize,txtGia,txtSoLuong;
    Button btnThemHang;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themhoadon_nhap);
        getView();

        btnThemHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
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

=======
>>>>>>> c211b9492c33ba0124d93d32333d7e6d24e996d5
                Intent intent = new Intent(activity_nhaphang.this, activity_themhoadon_nhap.class);
                startActivity(intent);
            }
        });
    }

    public void getView()
    {
        txtMa=findViewById(R.id.txtMaSP);
        txtTen=findViewById(R.id.txtTenSP);
        txtSize=findViewById(R.id.txtSize);
        txtGia=findViewById(R.id.txtGia);
        txtSoLuong=findViewById(R.id.txtSoLuong);
        btnThemHang=findViewById(R.id.btnThemHang);
    }

}
