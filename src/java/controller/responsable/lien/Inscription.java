package controller.responsable.lien;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
