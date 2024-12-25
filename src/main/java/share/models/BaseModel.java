/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share.models;

/**
 *
 * @author Asus
 */
public class BaseModel {
    private BaseModelOnlyId idComponent;
    private BaseModelOnlyName nameComponent;

    public BaseModel() {
        idComponent = new BaseModelOnlyId();
        nameComponent = new BaseModelOnlyName();
    }
    
    public BaseModel(int id, String name) {
        idComponent.setId(id);
        nameComponent.setName(name);
    }

    public BaseModel(String name){
        idComponent.setId(-1);
        nameComponent.setName(name);
    }
    
    public String getName() {
        return nameComponent.getName();
    }

    public void setName(String name) {
        this.nameComponent.setName(name);
    }
    
    public int getId(){
        return idComponent.getId();
    }
    
    protected void setId(int id){
        this.idComponent.setId(id);
    }
}
