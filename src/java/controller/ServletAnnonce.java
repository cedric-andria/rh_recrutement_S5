package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Vector;

import modele.Annonce;

@WebServlet(name="PageAnnonce", urlPatterns = {"/pageAnnonce"})
public class ServletAnnonce extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    Annonce annonce = new Annonce();
                    Vector<Annonce> allAnnonce = annonce.getAllAnnonce(null);

                    request.setAttribute("annonce", allAnnonce);


                    this.getServletContext().getRequestDispatcher("/web/annonce.jsp").forward(request, response);
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
