package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Avantage;
import model.Employe;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

@WebServlet(name="InsertEmploye", urlPatterns = {"/insertEmploye"})
public class ServletEmploye extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    Employe emp = new Employe();

                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    java.util.Date utilDate = new SimpleDateFormat("dd MMM yyyy").parse(request.getParameter("dtn"));
                    Date dtn = new Date(utilDate.getTime());
                    int sexe = Integer.parseInt(request.getParameter("dtn"));
                    String mail = request.getParameter("mail");

                    emp.setNom(nom);
                    emp.setPrenom(prenom);
                    emp.setDate_naissance(dtn);
                    emp.setSexe(sexe);
                    emp.setMail(mail);

                    emp.insertEmploye(null, emp);
                    
                    emp = emp.getEmployes(null, "ASC").get(0);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("idEmp", emp.getId());

                    Avantage avantage = new Avantage();
                    Vector<Avantage> allAvantages = avantage.getAllAvantage(null);
                    request.setAttribute("allAvantages", allAvantages);

                    this.getServletContext().getRequestDispatcher("/web/detailsEmploye.jsp").forward(request, response);
                } catch(Exception e){
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
