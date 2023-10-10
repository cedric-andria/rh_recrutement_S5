package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Vector;

import model.ResultatTest;

@WebServlet(name="PageResultatTest", urlPatterns = {"/pageResultatTest"})
public class ServletResultatTest extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    ResultatTest resultat = new ResultatTest();
                    Vector<ResultatTest> allResultat = resultat.getResultatTest(null);

                    request.setAttribute("resultat", allResultat);


                    this.getServletContext().getRequestDispatcher("/web/resultatTest.jsp").forward(request, response);
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
