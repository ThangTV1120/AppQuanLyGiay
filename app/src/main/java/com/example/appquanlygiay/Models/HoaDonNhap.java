package com.example.appquanlygiay.Models;

import java.util.Date;

public class HoaDonNhap {
    String idNhap,nhacc,nguoinhap;

    int SoLuongsp;
    Date datenhap;

    int TongTienNhap;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String id,String nguoinhap, String nhacc  , Date datenhap,int SoLuongsp, int TongTienNhap) {
        this.idNhap=id;
        this.nguoinhap =  nguoinhap;
        this.nhacc = nhacc;
        this.datenhap = datenhap;
        this.SoLuongsp=SoLuongsp;
        this.TongTienNhap=TongTienNhap;
    }

    public String getIdNhap() {
        return idNhap;
    }

    public void setIdNhap(String id) {
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

    public int getTongTienNhap() {
        return TongTienNhap;
    }

    public void setTongTienNhap(int tongTienNhap) {
        TongTienNhap = tongTienNhap;
    }

    public int getSoLuongsp() {
        return SoLuongsp;
    }

    public void setSoLuongsp(int soLuongsp) {
        SoLuongsp = soLuongsp;
    }
}
