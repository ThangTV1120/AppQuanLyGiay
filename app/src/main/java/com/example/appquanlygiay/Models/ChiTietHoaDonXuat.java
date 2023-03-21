package com.example.appquanlygiay.Models;

public class ChiTietHoaDonXuat {
    String IDShoe, idHoaDonXuat, TKKH,TenSP;
    int Size,  SoLuong;
    double Gia;

    public ChiTietHoaDonXuat() {
    }



    public ChiTietHoaDonXuat(String IDShoe, String tenSP, int size, double gia, int soLuong, String idHoaDonXuat, String TKKH) {
        this.IDShoe = IDShoe;
        this.idHoaDonXuat = idHoaDonXuat;
        this.TKKH = TKKH;
        TenSP = tenSP;
        Size = size;
        Gia = gia;
        SoLuong = soLuong;
    }

    public String getIDShoe() {
        return IDShoe;
    }

    public void setIDShoe(String IDShoe) {
        this.IDShoe = IDShoe;
    }

    public String getIdHoaDonXuat() {
        return idHoaDonXuat;
    }

    public void setIdHoaDonXuat(String idHoaDonXuat) {
        this.idHoaDonXuat = idHoaDonXuat;
    }

    public String getTKKH() {
        return TKKH;
    }

    public void setTKKH(String TKKH) {
        this.TKKH = TKKH;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
