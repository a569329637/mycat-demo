package com.gsq.model;

public class Order {

    private Integer id;
    private String orderCode;
    private Integer orderAmount;
    private Integer customerId;

    public Order() {
    }

    public Order(Integer id, String orderCode, Integer orderAmount, Integer customerId) {
        this.id = id;
        this.orderCode = orderCode;
        this.orderAmount = orderAmount;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", orderAmount=" + orderAmount +
                ", customerId=" + customerId +
                '}';
    }
}
