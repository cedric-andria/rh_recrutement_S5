///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author P14A-10-Cedric
// */
//public class SampleServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SampleServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SampleServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////        String nom=request.getParameter("nom"),prenom=request.getParameter("prenom"),identifiant=request.getParameter("identifiant"),motdepasse=request.getParameter("motdepasse");
////        String sDate=request.getParameter("dateNaissance");
////        System.out.println(sDate);
////        String[] elDate=sDate.split("-");
////        int j=Integer.parseInt(elDate[2]);
////        int m=Integer.parseInt(elDate[1]);
////        int a=Integer.parseInt(elDate[0]);
////        System.out.println(sDate);
////        Date dateNaissance=new Date(a-1900,m-1,j);
////        Client cl=new Client();
////        cl.setNom(nom);
////        cl.setPrenom(prenom);
////        cl.setIdentifiant(identifiant);
////        cl.setMotdepasse(motdepasse);
////        cl.setDate(dateNaissance);
////        try {
////            ServiceClient.save(cl);
////            ArrayList<Client> lcl=ServiceClient.get(cl);
////            request.getSession().setAttribute("IdClient", lcl.get(0).getId());
////            RequestDispatcher dispat =request.getRequestDispatcher("mainclient");
////            dispat.forward(request,response);
////        } catch (IllegalArgumentException ex) {
////            RequestDispatcher dispat =request.getRequestDispatcher("error.jsp?error="+ex.getMessage()+"");
////            ex.printStackTrace();
////                dispat.forward(request,response);
////        } catch (InvocationTargetException ex) {
////            Logger.getLogger(InscriptionClientServlet.class.getName()).log(Level.SEVERE, null, ex);
////            response.sendRedirect("error.jsp?error="+ex.getMessage()+"");
////        } catch (Exception ex) {
////            Logger.getLogger(InscriptionClientServlet.class.getName()).log(Level.SEVERE, null, ex);
////            response.sendRedirect("error.jsp?error="+ex.getMessage()+"");
////        }
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
