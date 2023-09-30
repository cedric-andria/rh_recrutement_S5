/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Postulant;
import connection.ConnectionJava;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author P14A-10-Cedric
 */
public class InscPostulantServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {
    //     response.setContentType("text/html;charset=UTF-8");
    //     try (PrintWriter out = response.getWriter()) {
    //         /* TODO output your page here. You may use following sample code. */
    //         out.println("<!DOCTYPE html>");
    //         out.println("<html>");
    //         out.println("<head>");
    //         out.println("<title>Servlet InscPostulantServlet</title>");            
    //         out.println("</head>");
    //         out.println("<body>");
    //         out.println("<h1>Servlet InscPostulantServlet at " + request.getContextPath() + "</h1>");
    //         out.println("</body>");
    //         out.println("</html>");
    //     }
    // }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispat = request.getRequestDispatcher("/inscpostulant.jsp");
        String nom = null;
        String prenom = null;
        String datenaissance = null;
        String sexe = null;
        String mail = null;
        String mdp = null;

        int valeurnulle = 0;
        String valnuls = "";
        //test au moins une valeur null
        try {
            nom = request.getParameter("nom");
        } catch (NullPointerException e) {
            valnuls += "nom";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
            // response.sendRedirect("inscpostulant.jsp");
        }
        if (nom.trim().isEmpty()) {
            valnuls += "nom";
            request.setAttribute("erreur", valnuls);
            // response.sendRedirect("inscpostulant.jsp");
            valeurnulle = 1;
            dispat.forward(request, response);
        }

        try {
            prenom = request.getParameter("prenom");
        } catch (NullPointerException e) {
            valnuls += ", prenom";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }
        if (prenom.trim().isEmpty() || (prenom == null)) {
            valnuls += ", prenom";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }

        try {
            datenaissance = request.getParameter("datenaissance");
        } catch (NullPointerException e) {
            valnuls += ", date de naissance";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }
        if (datenaissance.trim().isEmpty() || (datenaissance == null)) {
            valnuls += ", date de naissance";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }

        try {
            sexe = request.getParameter("sexe");
        } catch (NullPointerException e) {
            valnuls += ", sexe";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }
        if (sexe.trim().isEmpty() || (sexe == null)) {
            valnuls += ", sexe";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }

        try {
            mail = request.getParameter("mail");
        } catch (NullPointerException e) {
            valnuls += ", mail";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }
        if (mail.trim().isEmpty() || (mail == null)) {
            valnuls += ", mail";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }

        try {
            mdp = request.getParameter("mdp");
        } catch (NullPointerException e) {
            valnuls += ", mot de passe";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }
        if (mdp.trim().isEmpty() || (mdp == null)) {
            valnuls += ", mot de passe";
            request.setAttribute("erreur", valnuls);
            valeurnulle = 1;
            dispat.forward(request, response);
        }
        //test au moins une valeur null
        if (valeurnulle == 0) {
            Postulant postulant = null;
            Connection connection = null;
            ConnectionJava connex = new ConnectionJava("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/baserecrutement", "baserecrutement", "baserecrutement");
            try {
                connection = connex.connect();
                connection.setAutoCommit(false);

                try {
                    postulant = new Postulant(nom, prenom, datenaissance, sexe, mail, mdp);
                    

                    postulant.insert(connection, false);
                    connection.commit();
                } catch (Exception e) {
                    try
                    {
                        connection.rollback();
                    }
                    catch(SQLException sqlex)
                    {
                        sqlex.printStackTrace();
                    }
                    
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        if(!connection.isClosed())
                        {
                            connection.close();
                        }
                    }
                    catch(SQLException sqlex)
                    {
                        sqlex.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
