package com.itu.Projet.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.itu.Projet.connexion.Connexion;
import com.itu.Projet.model.PrevisionDAO;
import com.itu.Projet.util.BaseModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormDepenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (new Connexion()).getConnection();
        try {
            PrevisionDAO previsionDAO = new PrevisionDAO();
            ArrayList<BaseModel> listePrevisions = previsionDAO.findAll(conn);
            req.setAttribute("listePrevisions", listePrevisions);
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("pages/formDepense.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
