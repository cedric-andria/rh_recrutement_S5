package controller.critere.traitement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

@WebServlet (value = "/traitementInsertionCritere")
public class Insertion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String nom_poste = req.getParameter("poste");
        int id_diplome = Integer.parseInt(req.getParameter("id_diplome"));
        double coeff_diplome  = Double.parseDouble(req.getParameter("coeff_diplome"));
        int id_langue = Integer.parseInt(req.getParameter("id_langue"));
        double coeff_langue  = Double.parseDouble(req.getParameter("coeff_langue"));
        int id_experience = Integer.parseInt(req.getParameter("id_experience"));
        double coeff_experience  = Double.parseDouble(req.getParameter("coeff_experience"));
        int sexe = Integer.parseInt(req.getParameter("sexe"));

        try {
            HttpSession session = req.getSession();
            int id_service = (int) session.getAttribute("id_service");

            Poste poste = new Poste();
            poste.setNom(nom_poste);
            poste.setId_service(id_service);
            poste.insert(null);
            poste.getPoste(null);

            int id_poste = poste.getId();

            Critere_poste criterePoste = new Critere_poste();
            criterePoste.setId_poste(id_poste);
            criterePoste.setId_diplome(id_diplome);
            criterePoste.setId_langue(id_langue);
            criterePoste.setId_experience(id_experience);
            criterePoste.setSexe(sexe);

            Coeff_diplome_service coeffDiplomeService = new Coeff_diplome_service();
            coeffDiplomeService.setId_poste(id_poste);
            coeffDiplomeService.setId_diplome(id_diplome);
            coeffDiplomeService.setNote(coeff_diplome);

            Coeff_langue_service coeffLangueService = new Coeff_langue_service();
            coeffLangueService.setId_poste(id_poste);
            coeffLangueService.setId_langue(id_langue);
            coeffLangueService.setNote(coeff_langue);

            Coeff_experience_service coeffExperienceService = new Coeff_experience_service();
            coeffExperienceService.setId_poste(id_poste);
            coeffExperienceService.setId_experience(id_experience);
            coeffExperienceService.setNote(coeff_experience);

            criterePoste.insert(null);
            coeffDiplomeService.insert(null);
            coeffLangueService.insert(null);
            coeffExperienceService.insert(null);

            resp.sendRedirect("acceuil.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
