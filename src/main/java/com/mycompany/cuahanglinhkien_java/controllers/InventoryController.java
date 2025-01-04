/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Inventory;
import com.mycompany.cuahanglinhkien_java.models.Product;
import java.sql.SQLException;
import share.GenericController;

/**
 *
 * @author DLCT
 */
public class InventoryController {

    GenericController<Product> _dbHelper = new GenericController<>();

    public boolean ImportProduct(Inventory inventory) {
        String query = "INSERT INTO inventory (Pro_Id, ImportDate, BatchNumber, Total, QuantityImported, Importprice, StockQuantity) VALUES (?,?,?,?,?,?,?)";
        try {
            int id = _dbHelper.insert(query, inventory.getProductId(), inventory.getImportDate(),
                     inventory.getBatchNumber(), inventory.getTotal(), inventory.getQuantityImported(),
                     inventory.getImportPirce(), inventory.getStockQuantity());
            return id > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
