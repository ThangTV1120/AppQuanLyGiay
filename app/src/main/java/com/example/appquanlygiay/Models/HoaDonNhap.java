package com.example.appquanlygiay.Models;

import java.util.Date;

public class HoaDonNhap {
    String idHoaDonNhap,nhacc,nguoinhap,TKDN;

    int SoLuongsp;
    Date datenhap;

    double TongTienNhap;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String id, String nhacc  , Date datenhap,int SoLuongsp, double TongTienNhap,String TKDN) {
        this.idHoaDonNhap=id;
//        this.nguoinhap =  nguoinhap;
        this.nhacc = nhacc;
        this.datenhap = datenhap;
        this.SoLuongsp=SoLuongsp;
        this.TongTienNhap=TongTienNhap;
        this.TKDN=TKDN;
    }
    public HoaDonNhap(String id, String nhacc  , Date datenhap,int SoLuongsp, double TongTienNhap){
        this.idHoaDonNhap=id;
        this.nhacc = nhacc;
        this.datenhap = datenhap;
        this.SoLuongsp=SoLuongsp;
        this.TongTienNhap=TongTienNhap;
    }
    public String getTKDN() {
        return TKDN;
    }

    public void setTKDN(String TKDN) {
        this.TKDN = TKDN;
    }

    public String getIdHoaDonNhap() {
        return idHoaDonNhap;
    }

    public void setIdHoaDonNhap(String idHoaDonNhap) {
        this.idHoaDonNhap = idHoaDonNhap;
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

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public Date getDatenhap() {
        return datenhap;
    }

    public void setDatenhap(Date datenhap) {
        this.datenhap = datenhap;
    }


    public double getTongTienNhap() {
        return TongTienNhap;
    }

    public void setTongTienNhap(double tongTienNhap) {
        TongTienNhap = tongTienNhap;
    }

    public int getSoLuongsp() {
        return SoLuongsp;
    }

    public void setSoLuongsp(int soLuongsp) {
        SoLuongsp = soLuongsp;
    }
}
