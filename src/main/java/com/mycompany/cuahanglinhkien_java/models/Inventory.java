/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import java.util.Date;
import share.models.BaseModelOnlyId;

/**
 *
 * @author Asus
 */
public class Inventory extends BaseModelOnlyId {
    private String batchNumber;
    private int productId, quantityImported, stockQuantity;
    private float total, importPirce;
    private Date importDate;

    public Inventory(int id, int productId, String batchNumber, int quantityImported, int stockQuantity, float importPirce, Date importDate) {
        super(id);
        this.batchNumber = batchNumber;
        this.productId = productId;
        this.quantityImported = quantityImported;
        this.stockQuantity = stockQuantity;
        setTotal(importPirce*quantityImported);
        this.importPirce = importPirce;
        this.importDate = importDate;
    }
    
    public Inventory(int productId, String batchNumber, int quantityImported, float importPirce) {
        this.batchNumber = batchNumber;
        this.productId = productId;
        this.quantityImported = quantityImported;
        this.stockQuantity = quantityImported;
        setTotal(importPirce*quantityImported);
        this.importPirce = importPirce;
        this.importDate = new Date();
    }

    public Inventory() {
        this.batchNumber = "";
        this.productId = 0;
        this.quantityImported = 0;
        this.stockQuantity = 0;
        this.total = 0;
        this.importPirce = 0;
        this.importDate = new Date(1999, 01, 01);
    }
    
    public Inventory(int id, int stockQuantity) {
        super(id);
        this.stockQuantity = stockQuantity;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityImported() {
        return quantityImported;
    }

    public void setQuantityImported(int quantityImported) {
        this.quantityImported = quantityImported;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public float getTotal() {
        return total;
    }

    private final void setTotal(float total) {
        this.total = total;
    }

    public float getImportPirce() {
        return importPirce;
    }

    public void setImportPirce(float importPirce) {
        this.importPirce = importPirce;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }
}
