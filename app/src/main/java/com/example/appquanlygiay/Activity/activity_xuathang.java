package com.example.appquanlygiay.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlygiay.R;

import java.util.Calendar;

public class activity_xuathang extends AppCompatActivity
{
    ImageButton btnTimeXuat;

    Button btnXuatHoaDon,btnHuyXuat;
    TextView textViewTimeXuat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuathang);

        btnTimeXuat=findViewById(R.id.buttonTimeXuatHang);
        textViewTimeXuat=findViewById(R.id.TextViewNgayLapHoaDonXuat);
        btnXuatHoaDon=findViewById(R.id.buttonXuatHoaDon);
        btnHuyXuat=findViewById(R.id.buttonHuyTaoHoaDonXuat);

        btnTimeXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_xuathang.this,"Djfkd",Toast.LENGTH_LONG);
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        activity_xuathang.this,
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
                Intent intent = new Intent(activity_xuathang.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnHuyXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_xuathang.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
