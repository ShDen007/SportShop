package org.itstep.SportShop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = -1000119078147252957L;

    @Id
    @Column(name = "Code", length = 20, nullable = false)
    private String code;

    @Column(name = "Name", length = 245, nullable = false)
    private String name;

    @Column(name = "Brand",length = 254, nullable = false)
    private String brand;

    @Column(name = "Color", length = 254, nullable = false)
    private String color;

    @Column(name = "Size", length = 50, nullable = false)
    private String size;

    @Column(name = "Price", nullable = false)
    private double price;

    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
    private Date createDate;

    public Product() {
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

   public String getBrand() { return brand;}

   public void setBrand(String brand) { this.brand = brand;}

   public String getColor() { return color;}

   public void setColor(String color) { this.color = color;   }

   public String getSize() { return size;   }

   public void setSize(String size) { this.size = size;   }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}