package com.itu.Projet.model;

import java.sql.Date;

import com.itu.Projet.util.BaseModel;

public class Depense extends BaseModel {

    private int idPrevision;
    private double montant;
    private Date dateDepense;

    public int getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(int idPrevision) {
        this.idPrevision = idPrevision;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }
}
