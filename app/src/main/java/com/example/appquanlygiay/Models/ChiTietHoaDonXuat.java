package com.example.appquanlygiay.Models;

public class ChiTietHoaDonXuat {
    String IDShoe,idXuat;
    int Size, Gia, SoLuong;

    public ChiTietHoaDonXuat() {
    }

    public ChiTietHoaDonXuat(String IDShoe, int size, int gia, int soLuong,String idXuat) {
        this.IDShoe = IDShoe;
        this.Size = size;
        this.Gia = gia;
        this.SoLuong = soLuong;
        this.idXuat=idXuat;
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

    public int getGia() {
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
