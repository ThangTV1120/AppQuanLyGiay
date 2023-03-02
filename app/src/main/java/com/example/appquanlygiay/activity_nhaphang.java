package com.example.appquanlygiay;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;


public class activity_nhaphang extends AppCompatActivity {
    ImageButton TimeNhap;

    Button btnTaoHoaDon,btnHuyNhap;

    TextView txtTimeNhap;
    @Override
    protected void onCreate(Bundle savesavedInstanceState) {
        super.onCreate(savesavedInstanceState);
        setContentView(R.layout.activity_nhap_hang);
        getView();


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

            }
        });

        btnHuyNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }

    public void getView()
    {
        TimeNhap=findViewById(R.id.buttonTimeNhapHang);
        btnTaoHoaDon=findViewById(R.id.buttonThemHoaDonNhap);
        btnHuyNhap=findViewById(R.id.buttonHuyTaoHoaDonNhap);
        txtTimeNhap=findViewById(R.id.TextNgayLapHoaDonNhap);
    }
}
