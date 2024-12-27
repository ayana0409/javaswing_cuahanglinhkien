/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Employee;
import com.mycompany.cuahanglinhkien_java.models.Order;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;

/**
 *
 * @author Asus
 */
public class AuthenticationController {
    private final GenericController<Employee> _dbContext;

    public AuthenticationController() {
        this._dbContext = new GenericController<>();
    }

    public Employee getUserByUsername(String username) {
        String query = "SELECT * FROM employee WHERE username = ? LIMIT 1";
        try {
            return _dbContext.fetchOne(query, rs -> {
                try {
                    return new Employee(rs.getInt("id"), rs.getString("name"),
                            rs.getString("gender"), rs.getString("address"), 
                            rs.getString("phoneNumber"), rs.getString("status"), 
                            rs.getString("username"), rs.getString("password"), 
                            rs.getDate("birthday"), rs.getInt("rol_Id"));
                } catch (SQLException e) {          
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, e);
                    return null;
                }
            }, username);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean addAccount() {
        String query = "INSERT INTO employee (name, gender, address, phoneNumber, "
                + "status, username, password, birthday, rol_id)" 
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Date date = new Date(03, 9, 4);
            Employee e = new Employee("Dương Đoàn Thuận", "Nam", "Cần Thơ", "123123123", 
                    "Đang làm", "admin", "1", date, 1);
            int id = _dbContext.insert(query, e.getName(), e.getGender(), e.getAddress(), 
                    e.getPhoneNumber(), e.getStatus(), e.getUsername() , e.getHashedPassword(),
                    e.getBirthday(), e.getRoleId());
            return id > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
