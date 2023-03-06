package com.example.appquanlygiay.Class;

import java.util.Date;

public class HoaDonNhap {
    String idNhap,nhacc,nguoinhap;
    Date datenhap;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String id, String nhacc  , Date datenhap,String nguoinhap) {
        this.idNhap=id;
        this.nhacc = nhacc;
        this.datenhap = datenhap;
        this.nguoinhap =  nguoinhap;
    }

    public String getId() {
        return idNhap;
    }

    public void setId(String id) {
        this.idNhap = id;
    }

    public String getNhacc() {
        return nhacc;
    }

    public void setNhacc(String nhacc) {
        this.nhacc = nhacc;
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
