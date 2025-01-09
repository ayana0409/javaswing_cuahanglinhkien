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
public class Role extends BaseModel {
    public Role() {
        super();
    }

    public Role(int id, String name) {
        super(id, name);
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
