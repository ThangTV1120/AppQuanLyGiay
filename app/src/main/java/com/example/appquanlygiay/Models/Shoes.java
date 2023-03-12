package com.example.appquanlygiay.Models;

public class Shoes {
    String idShoes, nameShoes;
    int size,price;

    public Shoes() {
    }

    public Shoes(String id , String name, int size, int price)
    {
        this.idShoes=id;
        this.nameShoes= name;
        this.size=size;
        this.price=price;
    }

    public String getName() {
        return nameShoes;
    }

    public void setName(String name) {
        this.nameShoes = name;
    }

    public String getId() {
        return idShoes;
    }

    public void setId(String id) {
        this.idShoes = id;
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
}
