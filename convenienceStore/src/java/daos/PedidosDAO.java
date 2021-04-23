/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Servicios.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Pedido;
import models.Producto;

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
    
    public List<Pedido> getPedidos() throws SQLException {
        List<Pedido> listaProductos;
        String sql;
        Statement statement;
        ResultSet resultSet;
        
        listaProductos = new ArrayList<>();
        sql = "SELECT * FROM sale";
        
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        System.out.println("Products query executed successfully!");
        while (resultSet.next()) {
            String idSale = resultSet.getString("idSale");
            String idVendor = resultSet.getString("idVendor");
            String saleTotal = resultSet.getString("saleTotal");
            Pedido itemPedido = new Pedido(idSale, idVendor, saleTotal);
            listaProductos.add(itemPedido);
        }
        System.out.println("Returning products to controller");
        con.desconectar();
        return listaProductos;
    }
}
