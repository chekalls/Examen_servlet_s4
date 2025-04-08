package com.itu.Projet.util;

import java.sql.Connection;
import java.util.ArrayList;


public interface InterfaceDAO {

    public abstract void save(BaseModel obj) throws Exception;

    public abstract void update(BaseModel obj) throws Exception;

    public abstract BaseModel getById(int id) throws Exception;

    public abstract void remove(int id) throws Exception;

    public abstract ArrayList<BaseModel> findAll() throws Exception;


    public abstract void save(BaseModel obj,Connection conn) throws Exception;

    public abstract void update(BaseModel obj,Connection conn) throws Exception;

    public abstract BaseModel getById(int id,Connection conn) throws Exception;

    public abstract void remove(int id,Connection conn) throws Exception;

    public abstract ArrayList<BaseModel> findAll(Connection conn) throws Exception;
}