/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionJava;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Diplome;
import model.Experience;
import model.Langue;

import java.io.IOException;
import java.sql.Connection;

/**
 *
 * @author P14A-10-Cedric
 */
@WebServlet(name="VersSubmitCv", urlPatterns = {"/versSubmitCv"})
public class VersSoumissionCvServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection connection = null;
        ConnectionJava connex = new ConnectionJava("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/baserecrutement", "baserecrutement", "baserecrutement");
        Diplome[] tabdiplomes = null;
        Langue[] tablangues = null;
        Experience[] tabexperiences = null;
        try {
            connection = connex.connect();
            connection.setAutoCommit(false);
            tabdiplomes = new Diplome().selectWhere(connection, "1 = 1 order by id asc", false).toArray(new Diplome[0]);
            tablangues = new Langue().selectWhere(connection, "1 = 1 order by id asc", false).toArray(new Langue[0]);
            tabexperiences = new Experience().selectWhere(connection, "1 = 1 order by id asc", false).toArray(new Experience[0]);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        request.setAttribute("liste_diplome", tabdiplomes);
        request.setAttribute("liste_langue", tablangues);
        request.setAttribute("liste_experience", tabexperiences);
        request.setAttribute("id_poste", request.getParameter("id_poste"));

        
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
