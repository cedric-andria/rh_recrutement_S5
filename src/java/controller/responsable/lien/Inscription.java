package controller.responsable.lien;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Service;

import java.util.Vector;

@WebServlet (value = "/inscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Vector<Service> services = new Service().getAll(null);
            req.setAttribute("services", services);
            req.getRequestDispatcher("inscription_responsable.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
