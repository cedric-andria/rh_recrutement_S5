package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Vector;

import model.QuestionTest;
import model.ReponseTest;

@WebServlet(name="QuestionReponseTest", urlPatterns = {"/questionReponseTest"})
public class ServletQuestionReponseTest extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                PrintWriter out  = response.getWriter();

                try{
                    ReponseTest repTest = new ReponseTest();
                    QuestionTest qTest = new QuestionTest();

                    String question = request.getParameter("question");
                    int coeff = Integer.parseInt(request.getParameter("coeff"));
                    int nbRep = Integer.parseInt(request.getParameter("nbRep"));


                    qTest.setQuestion(question);
                    qTest.setCoefficient(coeff);
                    qTest.setId_test(1); // mila id anle test ho atao

                    qTest.insertQuestionTest(null, qTest);

                    for(int i = 0; i < nbRep+1; i++)
                    {
                        String reponse = request.getParameter("reponse"+i);
                        int etat = Integer.parseInt(request.getParameter("etat"+i));

                        repTest.setId(0);
                        repTest.setId_question(qTest.nbQuestion(null));
                        repTest.setReponse(reponse);
                        repTest.setEtat(etat);

                        repTest.insertReponseTest(null, repTest);
                    }



                    this.getServletContext().getRequestDispatcher("/pageQuestionReponseTest").forward(request, response);
                } catch(Exception e){
                    this.getServletContext().getRequestDispatcher("/web/erreur.jsp").forward(request, response);
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
