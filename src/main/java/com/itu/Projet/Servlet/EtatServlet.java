package com.itu.Projet.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.itu.Projet.connexion.Connexion;
import com.itu.Projet.model.Etat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EtatServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Etat etat = new Etat();
        Connection conn = (new Connexion()).getConnection();
        try {
            ArrayList<Etat> listeEtat = etat.findAll(conn);
            
            req.setAttribute("listeEtat", listeEtat);
            RequestDispatcher dispatcher = req.getRequestDispatcher("pages/listeEtat.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
