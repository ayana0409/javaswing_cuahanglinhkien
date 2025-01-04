/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import java.sql.SQLException;
import java.util.List;
import share.GenericController;
import com.mycompany.cuahanglinhkien_java.models.Category;

public class CategoryController {

    GenericController<Category> _dbHelper = new GenericController<>();

    public Category getCategoryById(int id) throws SQLException {
        String query = "SELECT * FROM category WHERE id = ?";
        return _dbHelper.fetchOne(query, rs -> {
            try {
                return new Category(rs.getInt("id"), rs.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, id);
    }

    public boolean addCategory(Category category) {
        String query = "INSERT INTO category (name) VALUES (?)";

        try {
            int id = _dbHelper.insert(query, category.getName());
            return id > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCategory(int id, String newName) {
        String query = "UPDATE category SET name = ? WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query, newName, id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCategory(int id) {
        String query = "DELETE FROM category WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query, id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Category> searchCategorybyName(String name ){
        String query ="SELECT * FROM category WHERE name LIKE ?";
        try {
        return _dbHelper.fetchAll(query, rs -> {
            try {
                return new Category(rs.getInt("id"), rs.getString("name"));
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
    public List<Category> getAllCategory() throws SQLException {
        String query = "SELECT * FROM category";
        return _dbHelper.fetchAll(query, rs -> {
            try {
                return new Category(rs.getInt("id"), rs.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}



