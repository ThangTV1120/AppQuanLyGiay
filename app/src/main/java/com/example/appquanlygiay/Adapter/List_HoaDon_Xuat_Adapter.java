package com.example.appquanlygiay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appquanlygiay.Models.HoaDonNhap;
import com.example.appquanlygiay.Models.HoaDonXuat;
import com.example.appquanlygiay.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class List_HoaDon_Xuat_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<HoaDonXuat> HoaDonXuatSP;

    public List_HoaDon_Xuat_Adapter(Context context, int layout, List<HoaDonXuat> hoaDonXuatSP) {
        this.context = context;
        this.layout = layout;
        HoaDonXuatSP = hoaDonXuatSP;
    }

    private class ViewHoler{
        TextView maHDXuat,ngayXuat,nguoimua,tongTienXuat,SLXuat;
    }

    @Override
    public int getCount() {
        return HoaDonXuatSP==null?0:HoaDonXuatSP.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler = new ViewHoler();
        HoaDonXuat HDXuat = HoaDonXuatSP.get(position);
        if(convertView == null)
        {
            viewHoler = new List_HoaDon_Xuat_Adapter.ViewHoler();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// chuyen file xml thanh file java
            convertView=inflater.inflate(R.layout.input_ds_hoadon_xuat,null);
            //anh xa
            viewHoler.maHDXuat=convertView.findViewById(R.id.txt_idHDXuat);
            viewHoler.tongTienXuat=convertView.findViewById(R.id.txtTongTienXuat);
            viewHoler.ngayXuat=convertView.findViewById(R.id.txt_ngayNhapXuat);
            viewHoler.nguoimua=convertView.findViewById(R.id.txt_nguoimua);
            viewHoler.SLXuat=convertView.findViewById(R.id.txt_SOSPXuat);
            convertView.setTag(viewHoler);
        }
        else{
            viewHoler=(ViewHoler) convertView.getTag();
        }
        String maHDNhap=HDXuat.getIdXuat();
        String nguoimua=HDXuat.getNguoimua();
        String TongTien=Double.toString(HDXuat.getTongTienXuat());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String NgayXuat=dateFormat.format(HDXuat.getDatexuat());
        String SL=Integer.toString(HDXuat.getSoLuongsp());
        viewHoler.maHDXuat.setText("Mã HD:"+maHDNhap);
        viewHoler.tongTienXuat.setText("Tổng:"+TongTien);
        viewHoler.ngayXuat.setText("Date:"+NgayXuat);
        viewHoler.nguoimua.setText("Nguoimua:"+nguoimua);
        viewHoler.SLXuat.setText("Số Lượng: "+SL);
        return convertView;
    }
}
