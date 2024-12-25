/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.models;

import share.models.BaseModel;

/**
 *
 * @author Asus
 */
public class Manufacturer extends BaseModel {
    public Manufacturer() {
        super();
    }

    public Manufacturer(int id, String name) {
        super(id, name);
    }
    
    public Manufacturer(String name) {
        super(name);
    }
}