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

public class DepenseDAO implements InterfaceDAO {
    @Override
    public void save(BaseModel obj, Connection conn) throws Exception {
        Depense depense = (Depense) obj;
        String sql = "INSERT INTO Depense (idPrevision,montant) VALUES(?,?) ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, depense.getIdPrevision());
            pstmt.setDouble(2, depense.getMontant());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void update(BaseModel obj, Connection conn) throws Exception {
        Depense depense = (Depense) obj;
        String sql = "UPDATE Depense SET idPrevision=?,montant=? WHERE idDepense=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, depense.getIdPrevision());
            pstmt.setDouble(2, depense.getMontant());
            pstmt.setInt(3, depense.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public BaseModel getById(int id, Connection conn) throws Exception {
        String sql = "SELECT * FROM Depense WHERE idDepense=?";
        BaseModel resutlModel = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                Depense depense = new Depense();
                depense.setId(set.getInt("idDepense"));
                depense.setIdPrevision(set.getInt("idPrevision"));
                depense.setMontant(set.getDouble("montant"));
                resutlModel = depense;
            }

        } catch (Exception e) {
            throw e;
        }
        return resutlModel;
    }

    @Override
    public void remove(int id, Connection conn) throws Exception {
        String sql = "DELETE FROM Depense WHERE idDepense=?";
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
        String sql = "SELECT * FROM Depense";
        ArrayList<BaseModel> listeModels = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Depense c = new Depense();
                c.setId(set.getInt("idDepense"));
                c.setIdPrevision(set.getInt("idPrevision"));
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

    public double getTotalDepenseByPrevision(int idPrevision, Connection conn) throws Exception {
        String sql = "SELECT SUM(montant) as total FROM Depense WHERE idPrevision=? ";
        double sum = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idPrevision);
            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                sum = set.getDouble("total");
            }
        } catch (Exception e) {
            throw e;
        }
        return sum;
    }
}
