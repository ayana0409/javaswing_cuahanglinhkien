/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import java.sql.Date;
import share.models.BaseModelOnlyId;

/**
 *
 * @author Asus
 */
public class Order extends BaseModelOnlyId {
    private Date purchaseDate;
    private String status;
    private float totalAmount;
    private int employeeId;
    
    public Order(int id, int employeeId, Date purchaseDate, String status, float totalAmount) {
        super(id);
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.employeeId = employeeId;
    }

    public Order() {
        this.purchaseDate = new Date(2024, 01, 01);
        this.status = "";
        this.totalAmount = 0;
        this.employeeId = 0;
    }

    public Order(int employeeId, Date purchaseDate, String status, float TotalAmount) {
        super();
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.totalAmount = TotalAmount;
        this.employeeId = employeeId;
    }
    
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
