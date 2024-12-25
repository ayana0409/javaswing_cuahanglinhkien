/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

/**
 *
 * @author Asus
 */
public class OrderDetail {
    private int quantitySold, productId, orderId;
    private float salePrice;

    public OrderDetail() {
        this.quantitySold = 0;
        this.productId = 0;
        this.orderId = 0;
        this.salePrice = 0;
    }

    public OrderDetail(int productId, int orderId, int quantitySold, float salePrice) {
        this.quantitySold = quantitySold;
        this.productId = productId;
        this.orderId = orderId;
        this.salePrice = salePrice;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }
    
}
