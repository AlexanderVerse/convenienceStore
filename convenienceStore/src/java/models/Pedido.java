/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hapib
 */
public class Pedido {
    String idSale;
    String idVendor;
    String saleTotal;

    public Pedido(String idSale, String idVendor, String saleTotal) {
        this.idSale = idSale;
        this.idVendor = idVendor;
        this.saleTotal = saleTotal;
    }

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public String getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(String idVendor) {
        this.idVendor = idVendor;
    }

    public String getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(String saleTotal) {
        this.saleTotal = saleTotal;
    }
    
    
}
