/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.InvoiceItem;
import com.mycompany.cuahanglinhkien_java.models.InvoiceModel;
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
    private final GenericController<InvoiceModel> _invoiceContext;
    private final GenericController<InvoiceItem> _invoiceItemContext;
    
    public OrderController() {
        this._dbContext = new GenericController<>();
        this._invoiceContext = new GenericController<>();
        this._invoiceItemContext = new GenericController<>();
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
    String query = "SELECT * FROM orders";
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
    
    public boolean paymentOrder(int orderId){
        String query = "UPDATE orders SET status = 'Hoàn thành' WHERE id = ?";

        try {
            int result = _dbContext.updateOrDelete(query, orderId);
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean cancelOrder(int orderId){
        String query = "UPDATE orders SET status = 'Hủy' WHERE id = ?";

        try {
            int result = _dbContext.updateOrDelete(query, orderId);
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public InvoiceModel getInvoiceData(int orderId){
        String query = "SELECT o.PhoneNumber, c.name as customerName, c.Address, e.name as EmployeeName "
                + "FROM Orders o JOIN Customer c ON o.PhoneNumber = c.PhoneNumber "
                + "JOIN Employee e ON o.Emp_Id = e.Id WHERE o.Id = ?;";
        List<InvoiceItem> items = getInvoiceItems(orderId);
        
        try {
            return _invoiceContext.fetchOne(query, i-> { 
                try {
                    return new InvoiceModel(i.getString("customerName"), i.getString("PhoneNumber"),
                            i.getString("Address"), i.getString("EmployeeName"), items);
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
    
    private List<InvoiceItem> getInvoiceItems(int orderId){
        String query = "SELECT p.Id AS productId, od.QuantitySold, p.Name AS ProductName, od.SalePrice "
                + "FROM OrderDetail od JOIN Product p ON od.Pro_Id = p.Id WHERE od.Id = ?;";
        try {
            return _invoiceItemContext.fetchAll(query, i -> {
                try {
                    return new InvoiceItem(i.getInt("productId"), i.getString("ProductName"), i.getInt("QuantitySold"), i.getFloat("SalePrice"));
                } catch (SQLException ex) {
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            },orderId);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    public List<Order> searchOrderByIdOrPhone(String name) {
        String query = "SELECT * FROM Orders WHERE id LIKE ? or phonenumber like ?";
        try {
            return _dbContext.fetchAll(query, rs -> {
                try {
                    return new Order(rs.getInt("id"), rs.getInt("emp_id"), 
                            rs.getString("phoneNumber"), rs.getDate("purchaseDate"), 
                            rs.getString("status"), rs.getFloat("totalAmount"));
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }, "%"+name+"%", "%"+name+"%");
        } catch (SQLException e) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return null;
        }
    }
    
}
