package com.fp.model.entity;

public class CartEntity {
    private int customerId;
    private int productId;
    private int quantity;
    private String code;
    private int price;

    public CartEntity() {
    }

    public CartEntity(int customerId, int productId, int quantity, String code, int price) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.code = code;
        this.price = price;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
