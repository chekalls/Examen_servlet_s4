package com.itu.Projet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itu.Projet.connexion.Connexion;
import com.itu.Projet.util.BaseModel;
import com.itu.Projet.util.InterfaceDAO;

public class PrevisionDAO implements InterfaceDAO {

    @Override
    public void save(BaseModel obj, Connection conn) throws Exception {
        Prevision prevision = (Prevision) obj;
        String sql = "INSERT INTO Previsions (libelle,montant) VALUES(?,?) ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prevision.getLibelle());
            pstmt.setDouble(2, prevision.getMontant());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void update(BaseModel obj, Connection conn) throws Exception {
        Prevision prevision = (Prevision) obj;
        String sql = "UPDATE Previsions SET libelle=?,montant=? WHERE idPrevision=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prevision.getLibelle());
            pstmt.setDouble(2, prevision.getMontant());
            pstmt.setInt(3, prevision.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public BaseModel getById(int id, Connection conn) throws Exception {
        String sql = "SELECT * FROM Previsions WHERE idPrevision=?";
        BaseModel resutlModel = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                Prevision prevision = new Prevision();
                prevision.setId(set.getInt("idPrevision"));
                prevision.setLibelle(set.getString("libelle"));
                prevision.setMontant(set.getDouble("montant"));
                resutlModel = prevision;
            }

        } catch (Exception e) {
            throw e;
        }
        return resutlModel;
    }

    @Override
    public void remove(int id, Connection conn) throws Exception {
        String sql = "DELETE FROM Previsions WHERE idPrevision=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ArrayList<BaseModel> findAll(Connection conn) throws Exception {
        String sql = "SELECT * FROM Previsions";
        ArrayList<BaseModel> listeModels = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Prevision c = new Prevision();
                c.setId(set.getInt("idPrevision"));
                c.setLibelle(set.getString("libelle"));
                c.setMontant(set.getDouble("montant"));
                listeModels.add(c);
            }
        } catch (Exception e) {
            throw e;
        }
        return listeModels;
    }

    @Override
    public void save(BaseModel obj) throws Exception {
        save(obj, (new Connexion()).getConnection());
    }

    @Override
    public void update(BaseModel obj) throws Exception {
        update(obj, (new Connexion()).getConnection());
    }

    @Override
    public BaseModel getById(int id) throws Exception {
        return getById(id, (new Connexion()).getConnection());
    }

    @Override
    public void remove(int id) throws Exception {
        remove(id, (new Connexion()).getConnection());
    }

    @Override
    public ArrayList<BaseModel> findAll() throws Exception {
        return findAll((new Connexion()).getConnection());
    }

}
