package com.nick;

import java.util.Date;

/**
 * Created by dreamcatchernick on 25/09/2017.
 */
public class Order {
    private int orderId;
    private int userId;
    private double totalAmount;
    private String orderDescription;
    private Date orderDate;
    public Order(){}
    public Order(int orderId, int userId, double totalAmount, String orderDescription, Date orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderDescription = orderDescription;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
