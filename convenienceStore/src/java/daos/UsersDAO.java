/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Servicios.Conexion;
import java.sql.*;
import java.sql.Statement;
import models.User;

/**
 *
 * @author hapib
 */
public class UsersDAO {
    private Conexion con;
    private Connection connection;
        
    public UsersDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public User getUser(String username, String password) throws SQLException {
        User loginUser;
        String sql;
        Statement statement;
        ResultSet resultSet;
        
        sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        
        resultSet.next();
        if(resultSet.isFirst() && resultSet.isLast()) {
            System.out.println("User matched");
            String login_id = resultSet.getString("idUser");
            String login_nombre = resultSet.getString("username");
            String login_password = resultSet.getString("password");
            loginUser = new User(login_id, login_nombre, login_password);
        }
        else {
            System.out.println("User not found");
            String login_id = null;
            String login_nombre = null;
            String login_password = null;
            loginUser = new User(login_id, login_nombre, login_password);
        }
        return loginUser;
    }
 
    public void setUser(String username, String password) throws SQLException{
        String sql;
        Statement statement;
        ResultSet resultSet;
        sql = "INSERT INTO users (username,password) VALUES ('" + username + "', '" + password + "')";
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        if(statement.executeUpdate(sql) != 0) System.out.println("Project added successfully!");
        else System.out.println("Insert query could not be executed!");
        con.desconectar();
    }
 
}
