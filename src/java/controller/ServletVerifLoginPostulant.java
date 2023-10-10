package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

import connexion.Connexion;
import modele.Postulant;

@WebServlet(name="VerifLoginPostulant", urlPatterns = {"/verifLogPostulant"})
public class ServletVerifLoginPostulant extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out  = response.getWriter();

        try{
            Connexion c = new Connexion();
            Connection co = c.connexPostgres();

            String mail = request.getParameter("mail");
            String mdp = request.getParameter("mdp");

            Postulant p = new Postulant();
            p = p.getPostulant(co, mail, mdp);
            
            if(p != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("idService", p.getId());
                out.print(session.getAttribute("idService"));
                this.getServletContext().getRequestDispatcher("/web/success.jsp").forward(request, response);
            }


            co.close();

            this.getServletContext().getRequestDispatcher("/logPostulant").forward(request, response);
        } catch (Exception e) {
            out.print(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
