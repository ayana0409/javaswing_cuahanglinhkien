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
public class Category extends BaseModel {
    public Category() {
        super();
    }

    public Category(int id, String name) {
        super(id, name);
    }
    
    public Category(String name) {
        super(name);
    }
}
