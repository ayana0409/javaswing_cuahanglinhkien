/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import java.util.List;

/**
 *
 * @author Asus
 */
public class InvoiceModel {
    private int id;
    private String customerName, phone, address, employeeName;
    private List<InvoiceItem> items;

    public InvoiceModel(int id, String customerName, String phone, String address, String employeeName, List<InvoiceItem> items) {
        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.employeeName = employeeName;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
    
    public float getTotalPrice() {
        float total = 0;
        for (InvoiceItem i : items)
            total += i.getPrice() * i.getQuantity();
        return total;
    }
}
