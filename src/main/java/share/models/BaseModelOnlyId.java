/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share.models;

/**
 *
 * @author Asus
 */
public class BaseModelOnlyId {
    private int id;

    public BaseModelOnlyId(int id) {
        this.id = id;
    }

    public BaseModelOnlyId() {
        this.id = -1;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
