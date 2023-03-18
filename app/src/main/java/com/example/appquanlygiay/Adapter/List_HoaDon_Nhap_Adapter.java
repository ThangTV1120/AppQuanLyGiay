package com.example.appquanlygiay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class List_HoaDon_Nhap_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HoaDonNhap> HoaDonNhapSP;
    public List_HoaDon_Nhap_Adapter(Context context,int layout,List<HoaDonNhap> HoaDonSP){
        this.context=context;
        this.layout=layout;
        this.HoaDonNhapSP=HoaDonSP;
    }

    @Override
    public int getCount() {
        return HoaDonNhapSP==null?0:HoaDonNhapSP.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    class ViewHoler{
        TextView maHD,ngayNhap,tongTien,SL,Nhacc;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoler viewHoler;
        HoaDonNhap HDNhap=HoaDonNhapSP.get(i);
        if(view==null){
            viewHoler = new ViewHoler();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// chuyen file xml thanh file java
            view=inflater.inflate(R.layout.input_ds_hoadon_nhap,null);
            //anh xa
            viewHoler.maHD=view.findViewById(R.id.txt_idHDXuat);
            viewHoler.tongTien=view.findViewById(R.id.txtTongTienXuat);
            viewHoler.ngayNhap=view.findViewById(R.id.txt_ngayNhap);
            viewHoler.Nhacc=view.findViewById(R.id.txt_NhaCC);
            viewHoler.SL=view.findViewById(R.id.txt_SOSPXuat);
            view.setTag(viewHoler);
        }
        else{
          viewHoler=(ViewHoler) view.getTag();
        }
        String maHDNhap=HDNhap.getIdHoaDonNhap();
        String nhacc=HDNhap.getNhacc();
        String TongTien=Double.toString(HDNhap.getTongTienNhap());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String NgayNhap=dateFormat.format(HDNhap.getDatenhap());
        String SL=Integer.toString(HDNhap.getSoLuongsp());
        viewHoler.maHD.setText("Mã HD:"+maHDNhap);
        viewHoler.tongTien.setText("Tổng:"+TongTien);
        viewHoler.ngayNhap.setText("Date:"+NgayNhap);
        viewHoler.Nhacc.setText("Nhà cung cấp:"+nhacc);
        viewHoler.SL.setText("Số Lượng: "+SL);
        return view;
    }
}
