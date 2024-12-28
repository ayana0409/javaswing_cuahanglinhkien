/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Order;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;

/**
 *
 * @author Asus
 */
public class OrderController {
    private final GenericController<Order> _dbContext;

    public OrderController() {
        this._dbContext = new GenericController<>();
    }

    public Order getOrder(int orderId) {
        String query = "SELECT * FROM orders WHERE id = ?";
        try {
            return _dbContext.fetchOne(query, rs -> {
                try {
                    return new Order(rs.getInt("id"), rs.getInt("emp_id"), 
                            rs.getString("phoneNumber"), rs.getDate("purchaseDate"), 
                            rs.getString("status"), rs.getFloat("totalAmount"));
                } catch (SQLException ex) {   
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }, orderId);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean addOrder(Order order) {
        String query = "INSERT INTO orders (emp_id, phoneNumber, purchaseDate, status, totalAmount) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(order.getPurchaseDate());
            int id = _dbContext.insert(query, order.getEmployeeId(), order.getPhoneNumber(),
                    formattedDate, order.getStatus(), order.getTotalAmount());
            return id > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
