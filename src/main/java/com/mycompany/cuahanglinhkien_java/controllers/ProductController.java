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

    public Product getProductById(int id) {
        String query = "SELECT * FROM product WHERE id = ?";
        try {
            return _dbHelper.fetchOne(query, rs -> {
                try {
                    return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("cat_Id"),
                            rs.getInt("man_Id"),rs.getInt("quantity"),
                            rs.getString("details"),rs.getString("image"), rs.getFloat("price"));
                } catch (SQLException e) {
                    return null;
                }
            }, id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addProduct(Product product) {
        String query = "INSERT INTO product ( cat_Id, man_Id, name,quantity, details,  price, image  ) VALUES (?,?,?,?,?,?,?)";

        try {
            int id = _dbHelper.insert(query,
                     product.getCategoryId(),product.getManufacturerId(),product.getName(), product.getQuantity(),
                    product.getDetails(), product.getPrice(),
                    product.getImage());
            return id > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String query = "UPDATE product SET  name = ?,cat_Id = ?, man_Id = ?,  quantity = ?, details = ?, price = ?, image = ? WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query,
                    product.getName(),
                    product.getCategoryId(),
                    product.getManufacturerId(),
                    product.getQuantity(),
                    product.getDetails(),
                    product.getPrice(),
                    product.getImage(),
                    product.getId()
            );
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> searchProductByName(String name) {
        String query = "SELECT * FROM product WHERE name LIKE ?";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("cat_Id"),
                            rs.getInt("man_Id"), rs.getInt("quantity"),
                            rs.getString("details"), rs.getString("image"), rs.getFloat("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }, "%"+name+"%");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> getAllProduct() {
        String query = "SELECT * FROM product";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("cat_Id"),
                            rs.getInt("man_Id"), rs.getInt("quantity"),
                            rs.getString("details"), rs.getString("image"), rs.getFloat("price"));
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

