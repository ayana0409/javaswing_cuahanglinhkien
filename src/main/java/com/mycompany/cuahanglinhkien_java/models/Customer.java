/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import share.models.BaseModelOnlyName;

/**
 *
 * @author Asus
 */
public class Customer extends BaseModelOnlyName {
    private String phoneNumber, Address;

    public Customer() {
        super();
        this.phoneNumber = "";
        this.Address = "";
    }

    public Customer(String phoneNumber, String Address, String name) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
}
