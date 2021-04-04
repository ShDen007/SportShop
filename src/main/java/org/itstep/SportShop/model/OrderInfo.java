package org.itstep.SportShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;
import java.util.List;

@Data
@EnableAutoConfiguration
@AllArgsConstructor

public class OrderInfo {

    private String id;
    private Date orderDate;
    private int orderNum;
    private double amount;

    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;

    private List<OrderDetailInfo> details;

    // Using for Hibernate Query.
    public OrderInfo(String id, Date orderDate, int orderNum, //
                     double amount, String customerName, String customerAddress, //
                     String customerEmail, String customerPhone) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderNum = orderNum;
        this.amount = amount;

        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public String getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public List<OrderDetailInfo> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailInfo> details) {
        this.details = details;
    }

}
