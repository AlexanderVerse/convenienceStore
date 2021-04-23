/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Servicios.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author hapib
 */
public class PedidosDAO {
    private Conexion con;
    private Connection connection;
    
    public PedidosDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
}
