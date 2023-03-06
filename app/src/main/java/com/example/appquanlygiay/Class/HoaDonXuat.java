package com.example.appquanlygiay.Class;

import java.util.Date;

public class HoaDonXuat {
    String idXuat,nguoimua,nguoinhap;
    Date datenhap;

    public HoaDonXuat() {
    }

    public HoaDonXuat(String id, String nguoimua  , Date datenhap,String nguoinhap) {
        this.idXuat=id;
        this.nguoimua= nguoimua;
        this.datenhap = datenhap;
        this.nguoinhap =  nguoinhap;
    }

    public String getId() {
        return idXuat;
    }

    public void setId(String id) {
        this.idXuat = id;
    }

    public String getNguoimua() {
        return nguoimua;
    }

    public void setNguoimua(String nguoimua) {
        this.nguoimua = nguoimua;
    }

    public String getNguoinhap() {
        return nguoinhap;
    }

    public Date getDatenhap() {
        return datenhap;
    }

    public void setDatenhap(Date datenhap) {
        this.datenhap = datenhap;
    }

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }
}
