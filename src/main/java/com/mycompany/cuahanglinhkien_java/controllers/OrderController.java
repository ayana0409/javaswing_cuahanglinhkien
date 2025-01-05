/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Order;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
            return (Order) _dbContext.fetchOne(query, rs -> {
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
    public List<Order> getAllOrder() {
    String query = "SELECT * FROM order";
    try {
        return _dbContext.fetchAll(query, rs -> {
            try {
                return new Order(rs.getInt("id"), rs.getInt("emp_id"), 
                            rs.getString("phoneNumber"), rs.getDate("purchaseDate"), 
                            rs.getString("status"), rs.getFloat("totalAmount") 
                );
            } catch (SQLException e) {
                e.printStackTrace();
                return null; // Trả về null nếu có lỗi trong quá trình đọc ResultSet
            }
        });
    } catch (SQLException ex) {
        Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, "Error fetching employees", ex);
        return new ArrayList<>(); // Trả về danh sách rỗng nếu có lỗi khi thực thi query
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
