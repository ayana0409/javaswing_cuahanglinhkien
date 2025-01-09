/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Inventory;
import com.mycompany.cuahanglinhkien_java.models.Order;
import com.mycompany.cuahanglinhkien_java.models.OrderDetail;
import com.mycompany.cuahanglinhkien_java.models.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;
import share.OutOfStockException;

/**
 *
 * @author Asus
 */
public class PaymentController {

    GenericController<OrderDetail> _orderDetailContext = new GenericController<>();
    OrderController _orderController = new OrderController();
    InventoryController _inventoryController = new InventoryController();

    public boolean payOrder(int orderId) throws OutOfStockException {
        List<OrderDetail> details = getOrderDetail(orderId);
        
        for (OrderDetail detail : details){
            int totalStock = getTotalStock(detail.getProductId());
            if (totalStock < detail.getQuantitySold()) {
                throw new OutOfStockException();
            }
        }
        
        for (OrderDetail detail : details){
            if (!consumeInventory(detail.getProductId(), detail.getQuantitySold()))
                return false;
        }
        _orderController.paymentOrder(orderId);
        return true;
    }

    private List<OrderDetail> getOrderDetail(int orderId) {
        try {
            String query = "select * from orderDetail where id = ?";
            return _orderDetailContext.fetchAll(query, od -> {
                try {
                    return new OrderDetail(od.getInt("pro_id"), od.getInt("id"), od.getInt("quantitySold"), od.getFloat("SalePrice"));
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }, orderId);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private boolean consumeInventory(int productId, int consumeQuantity) {
        List<Inventory> inventories = _inventoryController.getStockQuantityByProductId(productId);
        List<Inventory> updatedInventory = new ArrayList<>();

        for (Inventory i : inventories) {
            int stock = i.getStockQuantity();
            if (stock >= consumeQuantity) {
                i.setStockQuantity(stock - consumeQuantity);
                consumeQuantity = 0;
                updatedInventory.add(i);
                break;
            } else {
                i.setStockQuantity(0);
                consumeQuantity -= stock;
                updatedInventory.add(i);
            }
        }
        try {
            _inventoryController.updateInventoryQuantities(updatedInventory);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    private int getTotalStock(int productId) {
        List<Inventory> inventories = _inventoryController.getStockQuantityByProductId(productId);
        int totalStock = 0;
        for (Inventory i : inventories) {
           totalStock += i.getStockQuantity();
        }
        return totalStock;
    }

}
