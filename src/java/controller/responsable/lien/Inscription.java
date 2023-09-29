package controller.responsable.lien;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Service;
import util.Model;

import java.util.Vector;

@WebServlet (name = "inscription", value = "/inscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Vector<Model> models = new Service().select();
            Vector<Service> services = new Vector<>();
            for (Model model : models) {
                Service service = (Service) model;
                services.add(service);
            }
            req.setAttribute("services", services);
            resp.sendRedirect("inscription_responsable.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
