package controller.responsable;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Responsable;
import util.Model;

import java.io.IOException;
import java.util.Vector;

public class Connection extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String nom = req.getParameter("nom");
        String mdp = req.getParameter("mdp");
        Vector<Model> models = null;
        try {
            Responsable responsable = new Responsable();
            responsable.setNom(nom);
            responsable.setMdp(mdp);
            models = responsable.select();
            responsable = (Responsable) models.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("id_responsable", responsable.getId());
            resp.sendRedirect("acceuil.jsp");
        } catch (Exception e) {
            try {
                resp.sendRedirect("login_responsable.jsp");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
