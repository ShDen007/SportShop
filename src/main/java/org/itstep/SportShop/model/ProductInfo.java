package org.itstep.SportShop.model;

import org.itstep.SportShop.entity.Product;

public class ProductInfo {
    private String code;
    private String name;
    private String brand;
    private String color;
    private String size;
    private double price;


    public ProductInfo() {
    }

    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.brand = product.getBrand();
        this.color = product.getColor();
        this.size = product.getSize();
        this.price = product.getPrice();
    }

    // Using in JPA/Hibernate query
    public ProductInfo(String code, String name, String brand, String color, String size, double price) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name;   }

    public String getBrand() {return brand; }

    public void setBrand(String brand) {this.brand = brand; }

    public String getColor() {return color; }

    public void setColor(String color) {this.color = color; }

    public String getSize() {return size; }

    public void setSize(String size) {this.size = size; }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
