/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import java.util.Date;
import share.models.BaseModelOnlyId;
import share.singleton.UserSession;

/**
 *
 * @author Asus
 */
public class Order extends BaseModelOnlyId {
    private Date purchaseDate;
    private String status, phoneNumber;
    private float totalAmount;
    private int employeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Order(int id, int employeeId, String phoneNumber, Date purchaseDate, String status, float totalAmount) {
        super(id);
        this.phoneNumber = phoneNumber;
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
        this.phoneNumber = "0";
    }

    public Order(int employeeId, String phoneNumber, Date purchaseDate, String status, float TotalAmount) {
        super();
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.totalAmount = TotalAmount;
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
    }
    
    public Order(String phoneNumber) {
        super();
        this.purchaseDate = new Date();
        this.status = "Mới";
        this.totalAmount = 0;
        this.employeeId = UserSession.getInstance().getId();
        this.phoneNumber = phoneNumber;
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
