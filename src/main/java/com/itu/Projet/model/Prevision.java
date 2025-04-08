package com.itu.Projet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itu.Projet.connexion.Connexion;
import com.itu.Projet.util.BaseModel;


public class Prevision extends BaseModel{

    private String libelle;

    private double montant;

    public Prevision(){}

    public Prevision(String libelle, double montant) {
        this.libelle = libelle;
        this.montant = montant;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Prevision getPrevisionByName(String name,Connection conn) throws SQLException{
        Prevision prevision = null;
        String sql = "SELECT * FROM Previsions WHERE libelle=?";
        Connection connection = (new Connexion()).getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet set = pstmt.executeQuery();
            if(set.next()){
                prevision = new Prevision();
                prevision.setId(set.getInt("idPrevision"));
                prevision.setLibelle(set.getString("libelle"));
                prevision.setMontant(set.getDouble("montant"));
            }
        } catch (Exception e) {
            throw e;
        }

        return prevision;
    }
}
