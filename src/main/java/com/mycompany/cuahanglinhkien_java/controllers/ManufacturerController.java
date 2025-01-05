/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Manufacturer;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;

/**
 *
 * @author DLCT
 */
public class ManufacturerController {

    GenericController<Manufacturer> _dbHelper = new GenericController<>();

    public Manufacturer getManufacturerById(int id) throws SQLException {
        String query = "SELECT * FROM manufacturer WHERE id = ?";
        return _dbHelper.fetchOne(query, rs -> {
            try {
                return new Manufacturer(rs.getInt("id"), rs.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, id);
    }

    public List<Manufacturer> getAllManufacturer() {
        String query = "SELECT * FROM manufacturer ";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Manufacturer(rs.getInt("id"), rs.getString("name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(ManufacturerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addManufacturer(Manufacturer manufacturer) {
        String query = "INSERT INTO manufacturer (name) VALUES (?)";
        try {
            int id = _dbHelper.insert(query, manufacturer.getName());
            return id > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateManufacturer(int id, String newName) {
        String query = "UPDATE manufacturer SET name = ? WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query, newName, id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteManufacturer(int id) {
        String query = "DELETE FROM manufacturer WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query, id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Manufacturer> searchManufacturerbyName(String name) {
        String query = "SELET * FROM manufacturer WHERE name LIKE ?";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Manufacturer(rs.getInt("id"), rs.getString("name"));
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
}
