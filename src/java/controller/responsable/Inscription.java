package controller.responsable;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Responsable;
import model.Responsable_service;
import util.Model;

import java.util.Vector;

@WebServlet (name = "inscriptionResponsable", value = "/inscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int id_service = Integer.parseInt(req.getParameter("service"));
        String nom = req.getParameter("nom");
        String mdp = req.getParameter("mdp");
        try {
            Responsable responsable = new Responsable();
            responsable.setNom(nom);
            responsable.setMdp(mdp);
            responsable.insert();
            Vector<Model> models = responsable.select();
            responsable = (Responsable) models.get(0);
            Responsable_service responsableService = new Responsable_service();
            responsableService.setId_service(id_service);
            responsableService.setId_responsable(responsable.getId());
            responsableService.insert();
            req.getRequestDispatcher("login_responsable.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
