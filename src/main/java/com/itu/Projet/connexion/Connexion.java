package com.itu.Projet.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private String url;

    public Connexion(){
        this.url = "jdbc:mysql://172.80.237.222:3306/db_s2_ETU003104";
    }

    public  Connection getConnection(){
        String userName = "ETU003104";
        String password = "Wpiajvze";
        Connection c = null;
        try {
            c = DriverManager.getConnection(url,userName,password);    
            c.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
