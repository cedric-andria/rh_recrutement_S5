package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Vector;

import modele.Service;
import modele.Poste;

@WebServlet(name="PageBesoinService", urlPatterns = {"/pageBesoinService"})
public class ServletSoumissionBesoinService extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    HttpSession session = request.getSession(true);
                    int idResponsable = (int)session.getAttribute("idResponsableService");

                    int status = (int) request.getAttribute("status");
                    request.setAttribute("status", status);

                    Poste p = new Poste();
                    Vector<Poste> allPoste = p.getAllPosteByService(null, idResponsable); 

                    request.setAttribute("poste", allPoste);

                    this.getServletContext().getRequestDispatcher("/web/soumissionBesoinService.jsp").forward(request, response);
                } catch(Exception e){
                    request.setAttribute("status", 10);
                    try {
                        HttpSession session = request.getSession(true);
                        int idResponsable = (int)session.getAttribute("idResponsableService");
                        
                        Poste p = new Poste();
                        Vector<Poste> allPoste = p.getAllPosteByService(null, idResponsable); 

                        request.setAttribute("poste", allPoste);

                    } catch (Exception ex) {
                        // TODO: handle exception
                    }
                    
                    this.getServletContext().getRequestDispatcher("/web/soumissionBesoinService.jsp").forward(request, response);
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
