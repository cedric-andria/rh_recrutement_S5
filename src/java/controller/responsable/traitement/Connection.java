package controller.responsable.traitement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Responsable;
import model.Responsable_service;

import java.io.IOException;

@WebServlet (name = "traitementConnection", value = "/traitementConnection")
public class Connection extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nom = req.getParameter("nom");
        String mdp = req.getParameter("mdp");
        Responsable responsable = new Responsable();
        responsable.setNom(nom);
        responsable.setMdp(mdp);
        try {
            responsable = responsable.getResponsable(null);
            HttpSession session = req.getSession();
            int id_responsable = responsable.getId();
            session.setAttribute("id_responsable", id_responsable);
            Responsable_service responsableService = new Responsable_service();
            responsableService.setId_responsable(id_responsable);
            responsableService.getResponsable_service(null);
            session.setAttribute("id_service", responsableService.getId_service());
            req.getRequestDispatcher("acceuil.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.sendRedirect("connection_responsable.jsp");
        }
    }
}
