/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Inventory;
import com.mycompany.cuahanglinhkien_java.models.Role;
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
public class RoleController {
    GenericController<Role> _dbHelper = new GenericController<>();
    
    public List<Role> getRole() {
        String query = "select * from role";
        try {
            return _dbHelper.fetchAll(query, r -> {
                try {
                    return new Role(r.getInt("id"), r.getString("name"));
                } catch (SQLException ex) {
                    Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
