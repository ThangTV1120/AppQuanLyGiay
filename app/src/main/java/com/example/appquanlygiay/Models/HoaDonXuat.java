package com.example.appquanlygiay.Models;

import java.util.Date;

public class HoaDonXuat {
    String idXuat, nguoimua, nguoinhap, TKKH;
    Date datexuat;
    int SoLuongsp;
    double TongTienXuat;

    public HoaDonXuat() {
    }

    public HoaDonXuat(String idXuat, String nguoimua, Date datexuat, int SoLuongsp, double TongTienXuat, String TKKH){
        this.idXuat= idXuat;
        this.nguoimua = nguoimua;
        this.datexuat = datexuat;
        this.SoLuongsp = SoLuongsp;
        this.TongTienXuat = TongTienXuat;
        this.TKKH = TKKH;
    }

    public String getIdXuat() {
        return idXuat;
    }

    public void setIdXuat(String idXuat) {
        this.idXuat = idXuat;
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

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public String getTKKH() {
        return TKKH;
    }

    public void setTKKH(String TKKH) {
        this.TKKH = TKKH;
    }

    public Date getDatexuat() {
        return datexuat;
    }

    public void setDatexuat(Date datexuat) {
        this.datexuat = datexuat;
    }

    public int getSoLuongsp() {
        return SoLuongsp;
    }

    public void setSoLuongsp(int soLuongsp) {
        SoLuongsp = soLuongsp;
    }

    public double getTongTienXuat() {
        return TongTienXuat;
    }

    public void setTongTienXuat(double tongTienXuat) {
        TongTienXuat = tongTienXuat;
    }
}

