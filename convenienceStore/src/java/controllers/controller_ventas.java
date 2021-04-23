/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.VentasDAO;
import daos.ProductosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Producto;
import models.Venta;

/**
 *
 * @author hapib
 */
public class controller_ventas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    VentasDAO ventasDAO;
    private String IDVENDOR;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = "jdbc:mysql://localhost:3306/conveniencestore";
            String db_username = "root";
            String db_password = "";
            String callOrdersControllerRequest;
            
            ventasDAO = new VentasDAO(url, db_username, db_password);
            
            callOrdersControllerRequest = String.valueOf(request.getAttribute("callPedidosControllerRequest"));
            
            if(callOrdersControllerRequest != null) loginVendorVentas(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controller_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loginVendorVentas(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        IDVENDOR = String.valueOf(request.getAttribute("idVendor"));
        
        System.out.println("Logging verdor orders..");
        System.out.println("IDVENDOR: " + IDVENDOR);
        getVendorSalesRequest(request, response);
    }
    
    private void getVendorSalesRequest(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        RequestDispatcher dispatcher;
        List<Venta> listaVentas;
 
        dispatcher = request.getRequestDispatcher("views/ventas.jsp");
        
        System.out.println("Getting sales..");
        System.out.println("IDVENDOR: " + IDVENDOR);
        listaVentas = ventasDAO.getVentas();
        System.out.println("IDVENDOR: " + IDVENDOR);
        request.setAttribute("idVendor",IDVENDOR);
        request.setAttribute("listaVentas",listaVentas);
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
