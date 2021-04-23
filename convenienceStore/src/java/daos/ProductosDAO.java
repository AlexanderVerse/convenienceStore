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
import models.Producto;

/**
 *
 * @author hapib
 */
public class ProductosDAO {
    private Conexion con;
    private Connection connection;
        
    public ProductosDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Producto> getProductos() throws SQLException {
        List<Producto> listaProductos;
        String sql;
        Statement statement;
        ResultSet resultSet;
        
        listaProductos = new ArrayList<>();
        sql = "SELECT * FROM listproduct";
        
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        System.out.println("Products query executed successfully!");
        while (resultSet.next()) {
            String idProduct = resultSet.getString("idProduct");
            String productName = resultSet.getString("productName");
            String trademark = resultSet.getString("trademark");
            String stock = resultSet.getString("stock");
            String priceByUnit = resultSet.getString("priceByUnit");
            String idCategory = resultSet.getString("idCategory");
            Producto itemProducto = new Producto(idProduct, productName, trademark, stock, priceByUnit, idCategory);
            listaProductos.add(itemProducto);
        }
        System.out.println("Returning products to controller");
        con.desconectar();
        return listaProductos;
    }
}
