package com.itu.Projet.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.itu.Projet.connexion.Connexion;
import com.itu.Projet.model.Depense;
import com.itu.Projet.model.DepenseDAO;
import com.itu.Projet.services.DepenseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DepenseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepenseDAO depenseDAO = new DepenseDAO();
        Connection conn = (new Connexion()).getConnection();
        Integer idPrevision = Integer.parseInt(req.getParameter("prevision"));
        Double montant = Double.parseDouble(req.getParameter("montant"));
        DepenseService depenseService = new DepenseService();

        if (idPrevision != null && montant != null) {
            try {
                
                if(!depenseService.isDepenseValide(idPrevision, montant, conn)){
                    resp.sendRedirect("pages/formDepense.jsp?error");
                }else{
                    Depense nouvelleDepense = new Depense();
                    nouvelleDepense.setIdPrevision(idPrevision);
                    nouvelleDepense.setMontant(montant);
                    depenseDAO.save(nouvelleDepense,conn);
                    
                    conn.close();
                    resp.sendRedirect("index.html");
                }

            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }
}