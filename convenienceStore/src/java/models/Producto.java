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
public class Producto {
    String idProduct;
    String productName;
    String trademark;
    String stock;
    String priceByUnit;
    String idCategory;

    public Producto(String idProduct, String productName, String trademark, String stock, String priceByUnit, String idCategory) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.trademark = trademark;
        this.stock = stock;
        this.priceByUnit = priceByUnit;
        this.idCategory = idCategory;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPriceByUnit() {
        return priceByUnit;
    }

    public void setPriceByUnit(String priceByUnit) {
        this.priceByUnit = priceByUnit;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
    
    
}
