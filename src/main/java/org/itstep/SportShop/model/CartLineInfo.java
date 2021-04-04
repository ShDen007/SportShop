package org.itstep.SportShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@AllArgsConstructor
@EnableAutoConfiguration


public class CartLineInfo {

    private ProductInfo productInfo;
    private int quantity;

    public CartLineInfo() {
        this.quantity = 0;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return this.productInfo.getPrice() * this.quantity;
    }

}