package org.itstep.SportShop.model;

import lombok.Data;
import org.itstep.SportShop.entity.Product;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@EnableAutoConfiguration

public class ProductInfo {
    private String code;
    private String name;
    private double price;

    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductInfo(String code, String name, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}