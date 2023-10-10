package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

import connexion.Connexion;
import modele.*;

@WebServlet(name="InsertBesoinService", urlPatterns = {"/insertBesoinService"})
public class ServletBesoinService extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out  = response.getWriter();
        int status = 0;
        
        try {
            Connexion c = new Connexion();
            Connection co = c.connectPostgre();

            HttpSession session = request.getSession(true);
            int idResponsable = (int)session.getAttribute("idResponsableService");

            ResponsableService responsable = new ResponsableService();

            int idService = responsable.getResponsableService(null, idResponsable).getId();
            int idPoste = Integer.parseInt(request.getParameter("idPoste"));
            int nbr = Integer.parseInt(request.getParameter("nbr"));
            double volumeHoraire = Double.parseDouble(request.getParameter("horaire"));


            Service s = new Service();
            s.insertBesoinService(co, idService, idPoste, nbr, volumeHoraire);
            status = 1;

            request.setAttribute("status", status);

            co.close();

            this.getServletContext().getRequestDispatcher("/pageBesoinService").forward(request, response);

        } catch (Exception e){
            out.print(e);
            request.setAttribute("status", status);
            this.getServletContext().getRequestDispatcher("/pageBesoinService").forward(request, response);
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
