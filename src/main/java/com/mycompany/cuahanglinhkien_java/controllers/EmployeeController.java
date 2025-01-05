/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Employee;
import com.mycompany.cuahanglinhkien_java.models.Manufacturer;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import share.GenericController;
import share.utils.PasswordUtils;

/**
 *
 * @author YEN VY
 */
public class EmployeeController implements Serializable{

    GenericController<Employee> _dbHelper = new GenericController<>();

    public Employee getEmployeeById(int id) {
    String query = "SELECT * FROM employee WHERE id = ?";
        try {
            return _dbHelper.fetchOne(query, rs -> {
                try {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("address"),
                            rs.getString("PhoneNumber"),
                            rs.getString("Status"),
                            rs.getString("Username"),
                            rs.getString("Password"),
                            rs.getDate("birthday"),
                            rs.getInt("Rol_Id")
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }, id);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    public List<Employee> getAllEmployee() {
        String query = "SELECT * FROM employee";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Employee(
                            rs.getInt("Id"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("address"),
                            rs.getString("PhoneNumber"),
                            rs.getString("Status"),
                            rs.getString("Username"),
                            rs.getString("Password"),
                            rs.getDate("birthday"),
                            rs.getInt("Rol_Id")
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null; // Trả về null nếu có lỗi trong quá trình đọc ResultSet
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, "Error fetching employees", ex);
            return new ArrayList<>(); // Trả về danh sách rỗng nếu có lỗi khi thực thi query
        }
    }
    public boolean addEmployee(Employee employee) {
        String query = "INSERT INTO employee ( name, birthday, gender, address, PhoneNumber, Status, Username,Password, Rol_Id) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";

        try {
            int c = _dbHelper.insert(query,  employee.getName(), employee.getBirthday(), 
                        employee.getGender(), employee.getAddress(), employee.getPhoneNumber(),
                        employee.getStatus(), employee.getUsername(), employee.getHashedPassword(),employee.getRoleId());
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean editEmployee(Employee employee, int id ) {
        String query = "UPDATE Employee SET name=?, birthday=?, gender=?, address=?, "
                + "PhoneNumber=?, Status=?, Username=?,Password=?, Rol_Id=? WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query,  employee.getName(), employee.getBirthday(), 
                        employee.getGender(), employee.getAddress(), employee.getPhoneNumber(),
                        employee.getStatus(), employee.getUsername(), employee.getHashedPassword(), employee.getRoleId(), employee.getId());
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean editInforEmployee(Employee employee, int id ) {
        String query = "UPDATE Employee SET name=?, birthday=?, gender=?, address=?,"
                + " PhoneNumber=?, Status=?, Username=?, Rol_Id=? WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query, employee.getName(), employee.getBirthday(), 
                        employee.getGender(), employee.getAddress(), employee.getPhoneNumber(),
                        employee.getStatus(), employee.getUsername(), employee.getRoleId(),id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean updatePasswordEmployee( String password, int id ) {
        String query = "UPDATE Employee SET Password=? WHERE id = ?";
        try {
            int rowsAffected = _dbHelper.updateOrDelete(query, PasswordUtils.hashPassword(password), id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean deleteEmployee(int id) {
        String query = "DELETE FROM Employee WHERE id = ?";

        try {
            int rowsAffected = _dbHelper.updateOrDelete(query, id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Employee> searchEmployeebyName(String name) {
        String query = "SELET * FROM employee WHERE name LIKE ?";
        try {
            return _dbHelper.fetchAll(query, rs -> {
                try {
                    return new Employee(rs.getInt("Id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("address"),
                    rs.getString("PhoneNumber"),
                    rs.getString("Status"),
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getDate("birthday"),
                    rs.getInt("Rol_Id"));
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