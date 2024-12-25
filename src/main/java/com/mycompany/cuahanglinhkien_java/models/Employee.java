/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import java.sql.Date;
import share.models.BaseModel;
import share.utils.PasswordUtils;

/**
 *
 * @author Asus
 */
public class Employee extends BaseModel {
    private String gender, address, phoneNumber, Status, username, hashedPassword;
    private Date Birthday;

    public Employee(String name, String gender, String address,String phoneNumber,
            String Status, String username, String password, Date Birthday) {
        super(name);
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.Status = Status;
        this.username = username;
        setPassword(password);
        this.Birthday = Birthday;
    }
    
    public Employee(int id, String name, String gender, String address,String phoneNumber,
            String Status, String username, String password, Date Birthday) {
        super(id, name);
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.Status = Status;
        this.username = username;
        setPassword(password);
        this.Birthday = Birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public final void setPassword(String rawPassword) {
        this.hashedPassword = PasswordUtils.hashPassword(rawPassword);
    }

    public boolean checkPassword(String rawPassword) {
        return PasswordUtils.verifyPassword(rawPassword, this.hashedPassword);
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }
    
}