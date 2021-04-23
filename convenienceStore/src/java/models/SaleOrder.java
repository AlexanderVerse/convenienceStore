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
public class SaleOrder {
    private String id,idSale,idProduct,quantity,subtotal;
    public SaleOrder(String id, String idSale,  String idProduct, String quantity, String subtotal){
        this.id = id;
        this.idSale = idSale;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.subtotal = subtotal;
        
    }
    public String getid(){
        return id;
    }
    public String getidSale(){
        return idSale;
    }
    public String getidProduct(){
        return idProduct;
    }
    public String getquantity(){
        return quantity;
    }
    public String getsubtotal(){
        return subtotal;
    }
}
