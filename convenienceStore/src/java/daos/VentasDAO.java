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
import models.Venta;
import models.Producto;
import models.Sale;

/**
 *
 * @author hapib
 */
public class VentasDAO {
    private Conexion con;
    private Connection connection;
    
    public VentasDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Sale> getVentas() throws SQLException {
        List<Sale> listaProductos;
        String sql;
        Statement statement;
        ResultSet resultSet;
        
        listaProductos = new ArrayList<>();
        sql = "SELECT * FROM sale";
        
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        System.out.println("Ventas query executed successfully!");
        while (resultSet.next()) {
            String idSale = resultSet.getString("idSale");
            String idVendor = resultSet.getString("idVendor");
            String saleTotal = resultSet.getString("saleTotal");
            Sale itemPedido = new Sale(idSale, idVendor, saleTotal);
            listaProductos.add(itemPedido);
        }
        System.out.println("Returning ventas to controller");
        con.desconectar();
        return listaProductos;
    }
}
