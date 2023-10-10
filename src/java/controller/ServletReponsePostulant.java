package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;
import java.util.Vector;

import model.QuestionTest;
import model.ReponsePostulant;
import model.ReponseTest;
import model.ResultatTest;

@WebServlet(name="SoumissionReponsePostulant", urlPatterns = {"/soumissionReponsePostulant"})
public class ServletReponsePostulant extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    QuestionTest qt = new QuestionTest();
                    Vector<QuestionTest> allQtByPoste = qt.getQuestionTestByPoste(null, 1);

                    for(int i = 0; i < allQtByPoste.size(); i++)
                    {
                        ReponseTest rt = new ReponseTest();
                        Vector<ReponseTest> allRt = rt.getReponseTestByQuestion(null, allQtByPoste.get(i).getId_question());
                        for(int j = 0; j < allRt.size(); j++)
                        {
                            String name = "rep"+allRt.get(j).getId();

                            if(request.getParameter(name) != null){
                                int reponse = Integer.parseInt(request.getParameter(name));


                                ReponsePostulant repPostulant = new ReponsePostulant();
                                repPostulant.setId(0);
                                repPostulant.setId_postulant(1); // mila id anle postulant
                                repPostulant.setId_test(1); // mila id anle test
                                repPostulant.setId_question(allQtByPoste.get(i).getId_question());
                                repPostulant.setReponse(reponse);

                                repPostulant.insertReponsePostulant(null, repPostulant);
                            }
                            
                        }
                    }


                    
                    ResultatTest resultTest = new ResultatTest();
                    resultTest.insertReponseTest(null, 1, 1); // mila id anle test sy postulant
                    

                    this.getServletContext().getRequestDispatcher("/web/success.jsp").forward(request, response);
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
