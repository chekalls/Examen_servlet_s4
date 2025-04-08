package com.itu.Projet.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.itu.Projet.connexion.Connexion;
import com.itu.Projet.model.Prevision;
import com.itu.Projet.model.PrevisionDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrevisionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String libelle = req.getParameter("libelle");
        Double montant = Double.parseDouble(req.getParameter("montant"));
        Connection conn = (new Connexion()).getConnection();
        PrevisionDAO previsionDAO = new PrevisionDAO();

        try {
            Prevision buffer = (new Prevision()).getPrevisionByName(libelle, null);
            if(buffer!=null){
                buffer.setMontant(buffer.getMontant()+montant);
                previsionDAO.update(buffer, conn);
            }else{
                buffer = new Prevision();
                buffer.setLibelle(libelle);
                buffer.setMontant(montant);
                previsionDAO.save(buffer,conn);                
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }finally{
            try {
                
                conn.close();
            } catch (SQLException e) {
                throw new ServletException(e);
            }
            resp.sendRedirect("index.html");
        }
    }
}