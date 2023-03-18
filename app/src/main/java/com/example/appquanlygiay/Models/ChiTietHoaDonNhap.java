package com.example.appquanlygiay.Models;

public class ChiTietHoaDonNhap {
    String IDShoe,idHoaDonNhap,TenSP,TKDN;
    int Size, SoLuong;
    double Gia;

    public ChiTietHoaDonNhap() {
    }

    public ChiTietHoaDonNhap(String IDShoe,String tensp, int size, double gia, int soLuong,String TKDN,String idHoaDonNhap) {
        this.TenSP=tensp;
        this.IDShoe = IDShoe;
        this.Size = size;
        this.Gia = gia;
        this.SoLuong = soLuong;
        this.idHoaDonNhap=idHoaDonNhap;
        this.TKDN=TKDN;
    }


    public String getTenSP() {
        return TenSP;
    }

    public String getIdHoaDonNhap() {
        return idHoaDonNhap;
    }

    public void setIdHoaDonNhap(String idHoaDonNhap) {
        this.idHoaDonNhap = idHoaDonNhap;
    }

    public String getTKDN() {
        return TKDN;
    }

    public void setTKDN(String TKDN) {
        this.TKDN = TKDN;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getIDShoe() {
        return IDShoe;
    }

    public void setIDShoe(String IDShoe) {
        this.IDShoe = IDShoe;
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

    public void setGia(double gia) {
        Gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
