package org.itstep.SportShop.form;

import org.itstep.SportShop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private String code;
    private String name;
    private String brand;
    private String color;
    private String size;
    private double price;

    private boolean newProduct = false;

    // Завантаження файла.
    private MultipartFile fileData;

    public ProductForm() {
        this.newProduct= true;
    }

    public ProductForm(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.brand = product.getBrand();
        this.color = product.getColor();
        this.size = product.getSize();
        this.price = product.getPrice();
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

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

}