package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.QuestionTest;

import java.sql.*;
import java.util.Vector;

@WebServlet(name="PageQuestionReponseTest", urlPatterns = {"/pageQuestionReponseTest"})
public class ServletVersQuestionReponseTest extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    
                    QuestionTest qt = new QuestionTest();
                    Vector<QuestionTest> allQtByTest = qt.getQuestionTestByTest(null, 1);

                    request.setAttribute("qtByTest", allQtByTest);

                    this.getServletContext().getRequestDispatcher("/web/questionReponseTest.jsp").forward(request, response);
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
