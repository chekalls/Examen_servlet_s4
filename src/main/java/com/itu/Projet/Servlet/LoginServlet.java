package com.itu.Projet.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

// import com.itu.Projet.model.EmpModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // PrintWriter out = resp.getWriter();
        // EmpModel emp = new EmpModel();
        // String nom = req.getParameter("nom");
        // String password = req.getParameter("password");
        // int error = 0;

        // if (password.isBlank() || nom.isBlank()) {
        //     // error+=1;
        //     resp.sendRedirect("/testConnexion/index.html");
        // } else {
        //     int idEmp;
        //     try {
        //         idEmp = emp.exist(nom, password);
        //         if (idEmp != -1) {
        //             HttpSession session = req.getSession();
        //             session.setAttribute("empSession", idEmp);
        //             resp.sendRedirect("/testConnexion/navigation.jsp");
        //         } else {
        //             out.print("aucun utilisateur trouver");
        //         }
        //     } catch (SQLException e) {
        //         throw new ServletException(e);
        //     }
        // }
    }
}