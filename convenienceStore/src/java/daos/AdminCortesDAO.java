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
import models.Sale;
import models.SaleOrder;

/**
 *
 * @author coque
 */
public class AdminCortesDAO {
    private Conexion con;
    private Connection connection;
    public AdminCortesDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Sale> getSale() throws SQLException {
        Statement statement;
        ResultSet resultSet;
        List<Sale> sales = new ArrayList<Sale>();
        String sql;
        sql = "SELECT * from sale";
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String idSale = resultSet.getString("idSale");
            String idVendor = resultSet.getString("idVendor");
            String saleTotal = resultSet.getString("saleTotal");
            Sale sale = new Sale(idSale,idVendor,saleTotal);
            sales.add(sale);
        }
        con.desconectar();
        return sales;
        //SaleOrder saleorder = new SaleOrder();

    }
    public List<SaleOrder> getSaleOrder() throws SQLException{
        Statement statement;
        ResultSet resultSet;
        List<SaleOrder> salesorders = new ArrayList<SaleOrder>();
        String sql;
        sql = "SELECT * from sale_order";
        con.conectar();
        connection = con.getJdbcConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String idSale = resultSet.getString("idSale");
            String idProduct = resultSet.getString("idProduct");
            String quantity = resultSet.getString("quantity");
            String subtotal = resultSet.getString("subtotal");
            
            SaleOrder saleorder = new SaleOrder(id,idSale,idProduct,quantity,subtotal);
            salesorders.add(saleorder);
        }
        con.desconectar();
        return salesorders;
    }
}
