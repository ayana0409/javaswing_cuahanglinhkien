/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import share.models.BaseModel;

/**
 *
 * @author Asus
 */
public class Product extends BaseModel {
    private int categoryId, manufacturerId, quantity;
    private String  details, image;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(int id, String name, int categoryId, int manufacturerId, 
            int quantity, String details, String image, float price) {
        super(id, name);
        this.categoryId = categoryId;
        this.manufacturerId = manufacturerId;
        this.quantity = quantity;
        this.details = details;
        this.image = image;
        this.price = price;
    }
    
    public Product(String name, int categoryId, int manufacturerId, 
            int quantity, String details, String image, float price) {
        super(name);
        this.categoryId = categoryId;
        this.manufacturerId = manufacturerId;
        this.quantity = quantity;
        this.details = details;
        this.image = image;
        this.price = price;
    }

    public Product() {
        super();
        this.categoryId = 0;
        this.manufacturerId = 0;
        this.quantity = 0;
        this.details = "";
        this.image = "";
        this.price = 0;
    }
    
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
