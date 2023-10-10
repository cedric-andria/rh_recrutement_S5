package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Annonce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name="PageAnnonce", urlPatterns = {"/pageAnnonce"})
public class ServletAnnonce extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    Annonce annonce = new Annonce();
                    Vector<Annonce> allAnnonce = annonce.getAllAnnonce(null);

                    request.setAttribute("annonce", allAnnonce);


                    this.getServletContext().getRequestDispatcher("/frontoffice/public/annonce.jsp").forward(request, response);
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
