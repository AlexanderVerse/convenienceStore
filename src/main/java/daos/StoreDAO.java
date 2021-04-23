/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dbConnectors.Conexion;
import models.Store;

/**
 *
 * @author alexa
 */
public class StoreDAO {
    private Conexion con;
        private Connection connection;

    public StoreDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println("ProyectosDAO_JDBC:" + jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public void agregarProyecto (String userId, String projectName) throws SQLException {
        Statement statement;
        ResultSet resultSet;
        //String sql = "INSERT INTO proyecto (nombre) VALUES ('" + projectName + "')";
        String sql = "INSERT INTO proyecto (nombre, users_idusers) VALUES ('" + projectName + "', '" + userId + "')";
        
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        if(statement.executeUpdate(sql) != 0) System.out.println("Project added successfully!");
        else System.out.println("Insert query could not be executed!");
        
        con.desconectar();
    }
    
    public void eliminarProyecto (String userId, String projectId) throws SQLException {
        Statement statement;
        ResultSet resultSet;
        //String sql = "INSERT INTO proyecto (nombre) VALUES ('" + projectName + "')";
        String sql = "DELETE FROM proyecto WHERE id = '" + projectId + "' AND users_idusers = '" + userId + "'";
        
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        if(statement.executeUpdate(sql) != 0) System.out.println("Project deleted successfully!");
        else System.out.println("Delete query could not be executed!");
        
        con.desconectar();
    }
    
    public List<Store> listarProyectos () throws SQLException {
        List<Store> listaProyectos = new ArrayList<Store>();
        String sql = "SELECT * FROM proyecto";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String nombre = resultSet.getString("nombre");
            Store itemProyecto = new Store(id, nombre);
            listaProyectos.add(itemProyecto);
        }
        
        con.desconectar();
        return listaProyectos;
    }
    
    public List<Store> getUserProjects (String userId) throws SQLException {
        List<Store> listaProyectos = new ArrayList<Store>();
        String sql = "SELECT * FROM proyecto WHERE users_idusers = '" + userId + "'";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String nombre = resultSet.getString("nombre");
            Store itemProyecto = new Store(id, nombre);
            listaProyectos.add(itemProyecto);
        }
        
        con.desconectar();
        return listaProyectos;
    }
    
    public void updateProyecto (String userId, String projectId, String projectName) throws SQLException {
        Statement statement;
        ResultSet resultSet;
        //String sql = "INSERT INTO proyecto (nombre) VALUES ('" + projectName + "')";
        String sql = "UPDATE proyecto SET nombre = '" + projectName + "' WHERE proyecto.id = '" + projectId + "' AND users_idusers = '" + userId + "'";
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        if(statement.executeUpdate(sql) != 0) System.out.println("Project updated successfully!");
        else System.out.println("Update query could not be executed!");
        
        con.desconectar();
    }
}
