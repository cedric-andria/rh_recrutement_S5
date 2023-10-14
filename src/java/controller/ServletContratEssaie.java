package controller;

import java.io.*;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;

import model.ContratEssaie;
import model.Employe;

@WebServlet(name="InsertContratEssaie", urlPatterns = {"/insertContratEssaie"})
public class ServletContratEssaie extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    HttpSession session = request.getSession(true);
                    Employe emp = new Employe();

                    int idEmploye = Integer.parseInt(session.getAttribute("idEmp"));
                    String numeroMatricule = emp.idChar(6, "null", session.getAttribute("idEmp"));
                    java.util.Date utilDateDebut = new SimpleDateFormat("dd MMM yyyy").parse(request.getParameter("debut"));
                    Date debut = new Date(utilDateDebut.getTime());
                    java.util.Date utilDateFin = new SimpleDateFormat("dd MMM yyyy").parse(request.getParameter("fin"));
                    Date fin = new Date(utilDateFin.getTime());
                    double salaire = Double.parseDouble(request.getParameter("salaire"));
                    String lieuTravail = request.getParameter("lieu_travail");

                    ContratEssaie contratEssaie = new ContratEssaie();
                    contratEssaie.setId_employe(idEmploye);
                    contratEssaie.setNumero_matricule(numeroMatricule);
                    contratEssaie.setDate_debut(debut);
                    contratEssaie.setDate_fin(fin);
                    contratEssaie.setSalaire(salaire);
                    contratEssaie.setLieu_travail(lieuTravail);

                    contratEssaie.insertContratEssaie(null, contratEssaie);

                    this.getServletContext().getRequestDispatcher("/web/success.jsp").forward(request, response);
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
