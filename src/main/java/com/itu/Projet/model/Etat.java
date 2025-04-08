package com.itu.Projet.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itu.Projet.util.BaseModel;

public class Etat {
    private String libelle;
    private double prevision;
    private double depense;
    private double reste;

    public Etat(){}

    public Etat(String libelle, double prevision, double depense, double reste) {
        this.libelle = libelle;
        this.prevision = prevision;
        this.depense = depense;
        this.reste = reste;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public double getPrevision() {
        return prevision;
    }
    public void setPrevision(double prevision) {
        this.prevision = prevision;
    }
    public double getDepense() {
        return depense;
    }
    public void setDepense(double depense) {
        this.depense = depense;
    }
    public double getReste() {
        return reste;
    }
    public void setReste(double reste) {
        this.reste = reste;
    }
    
    public ArrayList<Etat> findAll(Connection conn) throws Exception {
        String sql = "SELECT * FROM Etat";
        ArrayList<Etat> listeEtat = new ArrayList<>();
        PrevisionDAO previsionDAO = new PrevisionDAO();
        try {
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Etat etat = new Etat();
                etat.setLibelle(((Prevision)previsionDAO.getById(set.getInt("idPrevision"))).getLibelle());
                etat.setPrevision(set.getDouble("prevision"));
                etat.setDepense(set.getDouble("depense"));
                etat.setReste(set.getDouble("rest"));
                listeEtat.add(etat);
            }
        } catch (Exception e) {
            throw e;
        }
        return listeEtat;
    }    
}
