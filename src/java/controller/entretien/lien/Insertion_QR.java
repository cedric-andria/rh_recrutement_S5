package controller.entretien.lien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entretien.Question;

import java.io.IOException;

@WebServlet (value = "question_reponse")
public class Insertion_QR extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("questionByEntretien", new Question().getQuestionByEntretien(null, 1));
            req.getRequestDispatcher("question_reponse.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
