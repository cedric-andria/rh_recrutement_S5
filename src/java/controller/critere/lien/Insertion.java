package controller.critere.lien;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Diplome;
import model.Experience;
import model.Langue;

import java.util.Vector;

@WebServlet(value = "/insertion")
public class Insertion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Vector<Diplome> diplomes = new Diplome().getAll(null);
            Vector<Langue> langues = new Langue().getAll(null);
            Vector<Experience> experiences = new Experience().getAll(null);
            req.setAttribute("diplomes", diplomes);
            req.setAttribute("langues", langues);
            req.setAttribute("experiences", experiences);
            req.getRequestDispatcher("insertion_critere.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
