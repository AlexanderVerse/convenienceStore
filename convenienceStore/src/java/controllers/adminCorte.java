/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AdminCortesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Sale;
import models.SaleOrder;

/**
 *
 * @author coque
 */
public class adminCorte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private AdminCortesDAO adminCortesDAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String corteTotal, cortePersonal;
            RequestDispatcher dispatcher;
            corteTotal = request.getParameter("corteTotal");
            cortePersonal = request.getParameter("cortePersonal");
            
            if(corteTotal == null && cortePersonal == null){
                dispatcher = request.getRequestDispatcher("views/adminCortecaja.jsp");
                dispatcher.forward(request, response);
            }
            if(corteTotal != null) corteTotal(request,response);
            if(cortePersonal != null) cortePersonal(request,response);
        }
    }
    public void corteTotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher;
        List<Sale> sales = new ArrayList<Sale>();
        List<SaleOrder> salesorders = new ArrayList<SaleOrder>();

        dispatcher = request.getRequestDispatcher("views/corteTotal.jsp");
        sales = adminCortesDAO.getSale(); //aqui llamo el resultado de la tabla sale 
        salesorders = adminCortesDAO.getSaleOrder(); //aqui llamo el resultado de la tabla saleorder
        
        request.setAttribute("sales", sales);
        request.setAttribute("salesorders", salesorders);
        
        dispatcher.forward(request, response);
    }

    public void cortePersonal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("views/cortePersonal.jsp");

        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(adminCorte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(adminCorte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
