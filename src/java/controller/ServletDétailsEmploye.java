package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Vector;

import model.AvantageNature;
import model.DetailsEmploye;
import model.Avantage;

import java.sql.*;

@WebServlet(name="InsertDetailsEmploye", urlPatterns = {"/insertDetailsEmploye"})
public class ServletDétailsEmploye extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out  = response.getWriter();

        try{
            DetailsEmploye detailsEmploye = new DetailsEmploye();


            String adresse = request.getParameter("adresse");
            String pere = request.getParameter("pere");
            String mere = request.getParameter("mere");
            String cin = request.getParameter("cin");
            HttpSession session = request.getSession(true);
            int idEmp = session.getAttribute("idEmp");

            detailsEmploye.setId_employe(idEmp);
            detailsEmploye.setAdresse(adresse);
            detailsEmploye.setNom_prenom_pere(pere);
            detailsEmploye.setNom_prenom_mere(mere);
            detailsEmploye.setNumero_cin(cin);

            Avantage avantage = new Avantage();
            Vector<Avantage> allAvantages = avantage.getAllAvantage(null);
            AvantageNature avantageNature = new AvantageNature();
            for(int i = 0; i < allAvantages.size(); i++)
            {
                String name = "rep"+i;
                int idAvantage = Integer.parseInt(request.getParameter(name));

                avantageNature.setId_employe(idEmp);
                avantageNature.setId_avantage(idAvantage);

                avantageNature.insertAvantageNature(null, avantageNature);
            }

            detailsEmploye.insertDetailsEmploye(null, detailsEmploye);

            detailsEmploye = detailsEmploye.getDetailsEmployes(null, "ASC").get(0);
            session.setAttribute("idDetailsEmp", detailsEmploye.getId());

            this.getServletContext().getRequestDispatcher("/web/contratEssaie.jsp").forward(request, response);
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
