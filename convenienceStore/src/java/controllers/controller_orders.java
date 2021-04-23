/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hapib
 */
public class controller_orders extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String IDVENDOR;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String callOrdersControllerRequest;
            
            callOrdersControllerRequest = String.valueOf(request.getAttribute("callOrdersControllerRequest"));
            
            if(callOrdersControllerRequest != null) loginVendorOrders(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loginVendorOrders(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        IDVENDOR = String.valueOf(request.getAttribute("idVendor"));
        
        System.out.println("Logging verdor orders..");
        System.out.println("IDVENDOR: " + IDVENDOR);
        newOrderRequest(request, response);
    }
    
    private void newOrderRequest(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        RequestDispatcher dispatcher;
        
        IDVENDOR = String.valueOf(request.getAttribute("projectId"));
        
        System.out.println("Logging histories project..");
        System.out.println("IDVENDOR: " + IDVENDOR);
        dispatcher = request.getRequestDispatcher("views/ordenes.jsp");
        request.setAttribute("idVendor",IDVENDOR);
        //request.setAttribute("userId", loginUser.getId());
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
        processRequest(request, response);
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
        processRequest(request, response);
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
