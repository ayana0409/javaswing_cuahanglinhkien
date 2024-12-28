/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;
/**
 *
 * @author DLCT
 */
public class ProductController {
    GenericController<Product> _dbHelper = new GenericController<>();

    public Product getProductById(int id){
        String query = "SELECT * FROM product WHERE id = ?";
        try {
            return _dbHelper.fetchOne(query, rs -> {
                try {
                    return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("cat_Id"),
                            rs.getInt("man_Id"),rs.getInt("quantity"),
                            rs.getString("details"),rs.getString("image"));
                } catch (SQLException e) {
                    return null;
                }
            }, id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public List<Product> getAllProduct(){
        String query = "SELECT * FROM product";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("cat_Id"),
                            rs.getInt("man_Id"),rs.getInt("quantity"),
                            rs.getString("details"),rs.getString("image"));
                } catch (SQLException e) {
                    return null;
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
}

