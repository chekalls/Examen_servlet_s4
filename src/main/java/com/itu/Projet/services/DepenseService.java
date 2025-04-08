package com.itu.Projet.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itu.Projet.model.Depense;
import com.itu.Projet.model.Prevision;
import com.itu.Projet.model.PrevisionDAO;

public class DepenseService {
    public boolean isDepenseValide(int idPrevision,double montantDepense,Connection conn) throws Exception{
        PrevisionDAO previsionDAO = new PrevisionDAO();
        try {
            Prevision prevision = (Prevision) previsionDAO.getById(idPrevision, conn);
            double montantDispo = prevision.getMontant();
            double totalDepense = getTotalDepenseByPrevision(idPrevision, conn);
            if(montantDispo-totalDepense-montantDepense<0){
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public double getTotalDepenseByPrevision(int idPrevision,Connection conn) throws Exception{
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
