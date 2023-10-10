package controller.entretien.lien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entretien.Resultat;

import java.io.IOException;

@WebServlet (value = "/embauche")
public class Embauche extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Resultat resultat = new Resultat();
        try {
            req.setAttribute("resultats", resultat.getResultatByEntretien(null, 1));
            req.getRequestDispatcher("resultat.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
