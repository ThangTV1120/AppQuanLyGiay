package com.example.appquanlygiay.Models;

import java.util.Date;

public class HoaDonXuat {
    String idXuat, nguoimua, nguoinhap;
    Date datenhap;
    int tongsp;
    int TongTienXuat;

    public HoaDonXuat() {
    }

    public HoaDonXuat(String id, String nguoinhap, String nguoimua, Date datenhap, int tongsp, int TongTienXuat) {
        this.idXuat = id;
        this.nguoinhap = nguoinhap;
        this.nguoimua = nguoimua;
        this.datenhap = datenhap;
        this.tongsp = tongsp;
        this.TongTienXuat = TongTienXuat;
    }

    public String getIdXuat() {
        return idXuat;
    }

    public void setIdXuat(String id) {
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

    public int getTongsp() {
        return tongsp;
    }

    public void setTongsp(int tongsp) {
        this.tongsp = tongsp;
    }

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public int getTongTienXuat() {
        return TongTienXuat;
    }

    public void setTongTienXuat(int tongTienXuat) {
        TongTienXuat = tongTienXuat;
    }
}

