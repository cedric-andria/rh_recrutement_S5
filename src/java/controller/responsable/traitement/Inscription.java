package controller.responsable.traitement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Responsable;
import model.Responsable_service;

import java.io.IOException;

@WebServlet (name = "traitementInscription", value = "/traitementInscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id_service = Integer.parseInt(req.getParameter("id_service"));
        String nom = req.getParameter("nom");
        String mdp = req.getParameter("mdp");
        Responsable responsable = new Responsable();
        responsable.setNom(nom);
        responsable.setMdp(mdp);
        try {
            responsable.insert(null);
            responsable = responsable.getResponsable(null);
            Responsable_service responsableService = new Responsable_service();
            responsableService.setId_service(id_service);
            responsableService.setId_responsable(responsable.getId());
            responsableService.insert(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("connection_responsable.jsp");
    }
}
