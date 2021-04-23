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
public class user extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = "jdbc:mysql://localhost:3306/planeacionagil";
            String db_username = "root";
            String db_password = "";
            
            String loginUserRequest = request.getParameter("loginUser");
            String signupUserRequest = request.getParameter("signupUser");
            
            System.out.println("user controler!");
            if(loginUserRequest != null) loginUserRequest(request, response);
            if(signupUserRequest != null) adduser(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loginUserRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //User loginUser;
        RequestDispatcher dispatcher;
        String username;
        String password;
        
        username = request.getParameter("loginUsername");
        password = request.getParameter("loginPassword");
        
        if(username.equals("admin") && password.equals("admin")) {
            dispatcher = request.getRequestDispatcher("views/adminCortecaja.jsp");
            dispatcher.include(request, response);
        }
        
        System.out.println("Loging user..");
    }
     private void adduser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username;
        String password; 
        
        System.out.println("Signing user..");
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
