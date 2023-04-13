package com.example.appquanlygiay.Models;

public class Shoes {
    String idShoes, nameShoes;
    int size,price,Soluong;

    public Shoes() {
    }

    public Shoes(String idShoes, String nameShoes, int size, int price, int soluong) {
        this.idShoes = idShoes;
        this.nameShoes = nameShoes;
        this.size = size;
        this.price = price;
        Soluong = soluong;
    }

    public String getIdShoes() {
        return idShoes;
    }

    public void setIdShoes(String idShoes) {
        this.idShoes = idShoes;
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
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }
}
