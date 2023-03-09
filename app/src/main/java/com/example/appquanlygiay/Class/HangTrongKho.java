package com.example.appquanlygiay.Class;

public class HangTrongKho {
    String idShoe, nameShoes;
    int size,price,soluong;

    public HangTrongKho() {
    }

    public HangTrongKho(String idShoe,String nameShoes , int size, int price , int soluong) {
        this.idShoe = idShoe;
        this.nameShoes=nameShoes;
        this.size=size;
        this.price=price;
        this.soluong=soluong;
    }

    public String getIdShoe() {
        return idShoe;
    }

    public void setIdShoe(String idShoe) {
        this.idShoe = idShoe;
    }

    public String getNameShoes() {
        return nameShoes;
    }

    public void setNameShoes(String nameShoes) {
        this.nameShoes = nameShoes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int Money(int soluong, int size) { return  soluong*size;}
}
