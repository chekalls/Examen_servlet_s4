package com.itu.Projet.util;

public class BaseModel {
    private int id;

    public BaseModel(){}

    public BaseModel(int id){
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
