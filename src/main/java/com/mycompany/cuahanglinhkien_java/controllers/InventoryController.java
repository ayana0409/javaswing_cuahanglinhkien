/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Inventory;
import com.mycompany.cuahanglinhkien_java.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;

/**
 *
 * @author DLCT
 */
public class InventoryController {

    GenericController<Inventory> _dbHelper = new GenericController<>();

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

    public List<Inventory> getAllInventory() {
        String query = "SELECT * FROM inventory";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Inventory(
                            rs.getInt("Id"), // Lấy Id từ bảng inventory
                            rs.getInt("Pro_Id"), // Lấy ProductId
                            rs.getString("BatchNumber"), // Lấy BatchNumber
                            rs.getInt("QuantityImported"), // Lấy QuantityImported
                            rs.getInt("StockQuantity"), // Lấy StockQuantity
                            rs.getFloat("ImportPrice"), // Lấy ImportPrice
                            rs.getDate("ImportDate") // Lấy ImportDate
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Trả về danh sách rỗng nếu có lỗi
        }
    }

    public List<Inventory> getStockQuantityByProductId(int productId){
        try {
            String query = "select * from inventory where pro_id = ? and stockQuantity > 0";
            return _dbHelper.fetchAll(query, od -> {
                try {
                    return new Inventory(od.getInt("id"), od.getInt("stockQuantity"));
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }, productId);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);        
            return null;
        }
    }
    
    public void updateInventoryQuantities(List<Inventory> inventories) throws SQLException {
        String query = "UPDATE inventory SET stockquantity = ? WHERE id = ?";

        try (Connection conn = _dbHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false);

            for (Inventory inventory : inventories) {
                stmt.setInt(1, inventory.getStockQuantity());
                stmt.setInt(2, inventory.getId());
                stmt.addBatch();
            }

            stmt.executeBatch();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
