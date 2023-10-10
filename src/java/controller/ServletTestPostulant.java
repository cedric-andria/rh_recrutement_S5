package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.QuestionTest;

import java.sql.*;
import java.util.Vector;

@WebServlet(name="PageTestPostulant", urlPatterns = {"/pageTestPostulant"})
public class ServletTestPostulant extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    
                    QuestionTest qt = new QuestionTest();
                    Vector<QuestionTest> allQtByPoste = qt.getQuestionTestByPoste(null, 1); //mila id anle poste

                    request.setAttribute("qtByPoste", allQtByPoste);

                    this.getServletContext().getRequestDispatcher("/web/testPostulant.jsp").forward(request, response);
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
