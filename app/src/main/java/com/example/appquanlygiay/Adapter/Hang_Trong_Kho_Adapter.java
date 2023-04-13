package com.example.appquanlygiay.Adapter;

import android.companion.WifiDeviceFilter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appquanlygiay.Models.Shoes;
import com.example.appquanlygiay.R;

import java.util.List;

public class Hang_Trong_Kho_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Shoes> ShoeL;

    public Hang_Trong_Kho_Adapter(Context context, int layout, List<Shoes> shoe) {
        this.context = context;
        this.layout = layout;
        ShoeL = shoe;
    }

    public int getCount(){
        return  ShoeL==null?0:ShoeL.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    class ViewHoler{
        TextView idShoe,nameShoe,size,prize,soluong;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoler viewHoler ;
        Shoes shoee= ShoeL.get(i);

        if (view==null)
        {
            viewHoler = new ViewHoler();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.input_san_pham,null);

            viewHoler.idShoe= view.findViewById(R.id.txt_idShoe);
            viewHoler.nameShoe=view.findViewById(R.id.txt_nameShoe);
            viewHoler.size=view.findViewById(R.id.txt_size);
            viewHoler.prize=view.findViewById(R.id.txt_prire);
            viewHoler.soluong= view.findViewById(R.id.txtSoLuong);
            view.setTag(viewHoler);
        }
        else{
            viewHoler=(Hang_Trong_Kho_Adapter.ViewHoler) view.getTag();
        }
            String idShoe = shoee.getIdShoes();
            String nameShoe=shoee.getNameShoes();
            int size= shoee.getSize();
            int prire = shoee.getPrice();
            int soluong= shoee.getSoluong();

            viewHoler.idShoe.setText("idShoe : "+idShoe);
            viewHoler.nameShoe.setText("nameShoe : "+nameShoe);
            viewHoler.size.setText("Size : "+ size);
            viewHoler.prize.setText("Prize : "+prire);
            viewHoler.prize.setText("SoLuong : "+soluong);
            return  view;
    }

}
