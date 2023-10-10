package controller.entretien.traitement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employe;
import model.Entretien;

import java.io.IOException;

@WebServlet (value = "/traitementEmbauche")
public class Embauche extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_entretien = Integer.parseInt(req.getParameter("id_entretien"));
        String[] idPostulants = req.getParameterValues("id_postulants");
        if (idPostulants != null) {
            Entretien entretien = new Entretien();
            try {
                entretien = entretien.getEntretienById(null, id_entretien);
                for (String idPostulant : idPostulants) {
                    Employe employe = new Employe();
                    employe.setId_poste(entretien.getId_poste());
                    employe.setId_postulant(Integer.parseInt(idPostulant));
                    employe.insert(null);
                }
                req.getRequestDispatcher("acceuil.jsp").forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
