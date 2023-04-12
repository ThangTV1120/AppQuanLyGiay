package com.example.appquanlygiay.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.appquanlygiay.Activity.activity_list_sanpham_xuat;
import com.example.appquanlygiay.Models.ChiTietHoaDonXuat;
import com.example.appquanlygiay.R;

import java.util.List;
public class List_SanPham_Xuat_Adapter extends BaseAdapter{
    private activity_list_sanpham_xuat context;
    private int layout;
    private List<ChiTietHoaDonXuat> ChiTietHoaDonXuatSP;
    public List_SanPham_Xuat_Adapter(activity_list_sanpham_xuat context, int layout, List<ChiTietHoaDonXuat> chiTietHoaDonXuat){

        this.layout=layout;
        this.context=context;
        this.ChiTietHoaDonXuatSP=chiTietHoaDonXuat;
    }
    @Override
    public int getCount(){return ChiTietHoaDonXuatSP==null?0:ChiTietHoaDonXuatSP.size(); }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHoder{
        public TextView tensp,masp,sizeSP,gia,soluong;
        public ImageView btn_xoa;
        public ViewHoder(){

        }
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder;
        ChiTietHoaDonXuat SPXuat=ChiTietHoaDonXuatSP.get(i);
        if(view==null){
            viewHoder=new List_SanPham_Xuat_Adapter.ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// chuyen file xml thanh file java
            //.inflate(file(layout) xml,cha cua file xml)
            view=inflater.inflate(R.layout.sanpham_input_output,null);;
            //anhxa
            viewHoder.masp=(TextView)view.findViewById(R.id.textMaSP_input);
            viewHoder.tensp=(TextView)view.findViewById(R.id.textSP_input);
            viewHoder.gia=(TextView)view.findViewById(R.id.textGiaNhap_input);
            viewHoder.sizeSP=(TextView)view.findViewById(R.id.textSize_input);
            viewHoder.soluong=(TextView)view.findViewById(R.id.textSoLuong_input);
            viewHoder.btn_xoa=(ImageView) view.findViewById(R.id.btn_xoaSP);
            view.setTag(viewHoder);
        }
        else{
            viewHoder=(List_SanPham_Xuat_Adapter.ViewHoder) view.getTag();
        }
        String masp=SPXuat.getIDShoe();
        String tensp=SPXuat.getTenSP();
        String size=Integer.toString(SPXuat.getSize());
        String dongia=Double.toString(SPXuat.getGia());
        String soluong=Integer.toString(SPXuat.getSoLuong());
        viewHoder.masp.setText("Mã SP:"+masp);
        viewHoder.tensp.setText("Tên SP:"+tensp);
        viewHoder.sizeSP.setText("Size:"+size);
        viewHoder.gia.setText("Giá:"+dongia);
        viewHoder.soluong.setText("Số Lượng:"+soluong);
        viewHoder.btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.XoaSP(i);

            }
        });
        return view;

    }
}
