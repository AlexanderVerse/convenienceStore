/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author coque
 */
public class Sale {
    private String idSale, idVendor, saleTotal;
    public Sale(String idSale, String idVendor,String saleTotal){
        this.idSale = idSale;
        this.idVendor = idVendor;
        this.saleTotal = saleTotal;
    }
    public String getidSale(){
        return idSale;
    }
    public String getIdvendor(){
        return idVendor;
    }
    public String getSaleTotal(){
        return saleTotal;
    }
}
