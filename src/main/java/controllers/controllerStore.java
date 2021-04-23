/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import daos.StoreDAO;
import models.Store;
import controllers.controllerStore;

/**
 *
 * @author alexa
 */
public class controllerStore extends HttpServlet{
    private StoreDAO proyectosDAO;
    private String USERID;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            
            String url = "jdbc:mysql://localhost:3306/conveniencestore";
            String username = "root";
            String password = "";
            
            Object loginUserRequest = request.getAttribute("loginUser");
            String logoutRequest = request.getParameter("logout");
            
            String addProjectRequest = request.getParameter("addProject");
            String deleteProjectRequest = request.getParameter("deleteProject");
            String getAllProjectsRequest = request.getParameter("getAllProjects");
            Object getUserProjects = request.getAttribute("getProjects");
            String updateProjectRequest = request.getParameter("updateProject");
            
            String callHistoriasControllerRequest = request.getParameter("proyHistorias");
            String callTarjetasControllerRequest = request.getParameter("proyTarjetas");
            
            
            proyectosDAO = new StoreDAO(url, username, password);
            
            if (loginUserRequest != null)  login(request, response);
            
            if (addProjectRequest != null)  addProject(request, response);
            if (deleteProjectRequest != null)  deleteProject(request, response);
            if (getAllProjectsRequest != null)  getAllProjects(request, response);
            if (getUserProjects != null)  getProjects(request, response);
            if (updateProjectRequest != null)  updateProject(request, response);
            
            if (callHistoriasControllerRequest != null)  callHistoriasController(request, response);
            if (callTarjetasControllerRequest != null)  callTarjetasController(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controllerStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException, ServletException {
        USERID = String.valueOf(request.getAttribute("userId"));
        getProjects(request, response);
    }
    
    private void addProject(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        String nombreProyecto = request.getParameter("addProjectName");
        System.out.println("addProjectData: " + USERID + ", " + nombreProyecto);
        proyectosDAO.agregarProyecto(USERID, nombreProyecto);
        getProjects(request, response);
    }
    
    private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        String idProyecto = request.getParameter("proyId");
        System.out.println("removeProjectId: " + idProyecto);
        proyectosDAO.eliminarProyecto(USERID, idProyecto);
        getProjects(request, response);
    }
    
    private void getAllProjects(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException  {
        List<Store> listaProyectos;
        RequestDispatcher dispatcher;
        
        listaProyectos = proyectosDAO.listarProyectos();
        dispatcher = request.getRequestDispatcher("views/misProyectos.jsp");
        
        /*
        System.out.println("Showing proyectos");
        for (Proyecto proy: listaProyectos) {
            System.out.println("proy " + proy.getId() + " : " + proy.getNombre());
        }
        */
        request.setAttribute("lista_proyectos", listaProyectos);
        dispatcher.forward(request, response);
    }
    
    private void getProjects(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException  {
        List<Store> listaProyectos;
        RequestDispatcher dispatcher;
        
        System.out.println("getProjectsData: " + USERID);
        listaProyectos = proyectosDAO.getUserProjects(USERID);
        dispatcher = request.getRequestDispatcher("views/misProyectos.jsp");
        request.setAttribute("lista_proyectos", listaProyectos);
        dispatcher.forward(request, response);
    }
    
    private void updateProject(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        String idProyecto = request.getParameter("proyId");
        String nombreProyecto = request.getParameter("proyNombre");
        System.out.println("updateProjectData: " + idProyecto + ", " + nombreProyecto);
        proyectosDAO.updateProyecto(USERID, idProyecto, nombreProyecto);
        getProjects(request, response);
    }

    private void callHistoriasController(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        RequestDispatcher dispatcher;
        String projectId = request.getParameter("proyId");
        
        dispatcher = request.getRequestDispatcher("controller_historias");
        request.setAttribute("callHistoriesControllerRequest", "Calling project histories..");
        request.setAttribute("projectId", projectId);
        //request.setAttribute("userId", loginUser.getId());
        dispatcher.forward(request, response);
    }
    private void callTarjetasController(HttpServletRequest request, HttpServletResponse response) throws 
            SQLException, IOException , ServletException {
        RequestDispatcher dispatcher;
        String proyID;
        proyID = request.getParameter("proyId");
        dispatcher = request.getRequestDispatcher("controller_tarjeta");
        request.setAttribute("project_id",proyID);
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
