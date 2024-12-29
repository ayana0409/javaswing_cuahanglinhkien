/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.OrderDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;

/**
 *
 * @author Asus
 */
public class OrderDetailController {

    private final GenericController<OrderDetail> _dbContext;

    public OrderDetailController() {
        this._dbContext = new GenericController<>();
    }

    public List<OrderDetail> getByOrderId(int orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String query = "select * from OrderDetail where id = ?";

        try {
            orderDetails = _dbContext.fetchAll(query, sr -> {
                try {
                    return new OrderDetail(sr.getInt("pro_id"), sr.getInt("id"),
                            sr.getInt("quantitySold"), sr.getFloat("salePrice"));
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }, orderId);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetails;
    }

    public OrderDetail getByOrderIdAndProductId(int orderId, int productId) {
        String query = "select * from OrderDetail where id = ? and pro_id = ?";

        try {
            return _dbContext.fetchOne(query, sr -> {
                try {
                    return new OrderDetail(sr.getInt("pro_id"), sr.getInt("id"),
                            sr.getInt("quantitySold"), sr.getFloat("salePrice"));
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }, orderId, productId);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean upsertOrDeleteOrderDetail(OrderDetail detail) {
        var existDetail = getByOrderIdAndProductId(detail.getOrderId(), detail.getProductId());
        String query;
        try {
            if (existDetail == null) {
                query = "insert into orderdetail (pro_id, id, salePrice, quantitySold) value (?,?,?,?)";
                return _dbContext.insert(query, detail.getOrderId(), detail.getProductId(),
                        detail.getQuantitySold(), detail.getSalePrice()) > 0;
            } else if (detail.getQuantitySold() > 0) {
                query = "UPDATE orderdetail SET quantitySold = ? WHERE pro_id = ? and id = ?";
                return _dbContext.updateOrDelete(query, detail.getQuantitySold(), 
                        detail.getProductId(), detail.getOrderId()) > 0;
            } else {
                query = "DELETE FROM orderdetail WHERE pro_id = ? and id = ?";
                return _dbContext.updateOrDelete(query, detail.getProductId(), detail.getOrderId()) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
