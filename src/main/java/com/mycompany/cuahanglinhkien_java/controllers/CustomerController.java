/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Category;
import com.mycompany.cuahanglinhkien_java.models.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;

/**
 *
 * @author YEN VY
 */
public class CustomerController extends javax.swing.JFrame {

    GenericController<Customer> _dbHelper = new GenericController<>();

    public Customer getCustomerByPhoneNumber(String PhoneNumber) {
        String query = "SELECT * FROM customer WHERE PhoneNumber = ?";
        try {
            return _dbHelper.fetchOne(query, rs -> {
                try {
                    return new Customer(rs.getString("PhoneNumber"), rs.getString("name"), rs.getString("Address"));
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }, PhoneNumber);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Customer> getAllCustomer() {
        String query = "SELECT * FROM customer";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Customer(rs.getString("PhoneNumber"), rs.getString("name"), rs.getString("Address"));
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Customer>();
        }
    }

    public boolean addCustomer(Customer customer) {
        String query = "INSERT INTO customer (PhoneNumber, name, Address ) VALUES (?, ?, ?)";

        try {
            int c = _dbHelper.insert(query, customer.getPhoneNumber(), customer.getName(), customer.getAddress());
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}