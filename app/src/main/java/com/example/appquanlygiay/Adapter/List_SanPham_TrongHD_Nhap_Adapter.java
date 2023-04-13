package com.example.appquanlygiay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appquanlygiay.Models.ChiTietHoaDonNhap;
import com.example.appquanlygiay.R;

import java.util.List;

public class List_SanPham_TrongHD_Nhap_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ChiTietHoaDonNhap> ChiTietHoaDonNhapSP;
    public List_SanPham_TrongHD_Nhap_Adapter(Context context, int layout, List<ChiTietHoaDonNhap> chiTietHoaDonNhap){
        this.context=context;
        this.layout=layout;
        this.ChiTietHoaDonNhapSP=chiTietHoaDonNhap;
    }

    @Override
    public int getCount() {
        return ChiTietHoaDonNhapSP==null?0:ChiTietHoaDonNhapSP.size();
    }

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
        public ViewHoder(){

        }
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      ViewHoder viewHoder;
      ChiTietHoaDonNhap SPNhap=ChiTietHoaDonNhapSP.get(i);
      if(view==null){
          viewHoder=new ViewHoder();
          LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// chuyen file xml thanh file java
          //.inflate(file(layout) xml,cha cua file xml)
          view=inflater.inflate(R.layout.sanpham,null);;
          //anhxa
          viewHoder.masp=(TextView)view.findViewById(R.id.textMaSP_input);
          viewHoder.tensp=(TextView)view.findViewById(R.id.textSP_input);
          viewHoder.gia=(TextView)view.findViewById(R.id.textGiaNhap_input);
          viewHoder.sizeSP=(TextView)view.findViewById(R.id.textSize_input);
          viewHoder.soluong=(TextView)view.findViewById(R.id.textSoLuong_input);
          view.setTag(viewHoder);
      }
      else{
          viewHoder=(ViewHoder) view.getTag();
      }

      String masp=SPNhap.getIDShoe();
      String tensp=SPNhap.getTenSP();
      String size=Integer.toString(SPNhap.getSize());
      String dongia=Double.toString(SPNhap.getGia());
      String soluong=Integer.toString(SPNhap.getSoLuong());
      viewHoder.masp.setText("Mã SP:"+masp);
      viewHoder.tensp.setText("Tên SP:"+tensp);
      viewHoder.sizeSP.setText("Size:"+size);
      viewHoder.gia.setText("Giá:"+dongia);
      viewHoder.soluong.setText("Số Lượng:"+soluong);
      return view;

    }

}
