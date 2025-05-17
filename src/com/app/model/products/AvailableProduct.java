package com.app.model.products;

import com.app.model.storage.Printable;

public class AvailableProduct implements Printable {    //Супертип для Product
    private String name;
    private int price;
    private int sizeValue;

    public AvailableProduct(String name, int price, int sizeValue){
        setName(name);
        setPrice(price);
        setSizeValue(sizeValue);
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    void setSizeValue(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    @Override
    public String getInfo(){
        return "________________________" + "\n" +
                "|Название: " + name + "\t\n" +
                "|Цена: " + price + "\t\n" +
                "|Размер: " + sizeValue + "\t";

    }
}
