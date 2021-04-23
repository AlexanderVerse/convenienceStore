<%-- 
    Document   : corteTotal
    Created on : 23/04/2021, 10:23:05 AM
    Author     : coque
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Corte total</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <body>
        <h1>Corte Total</h1>

        <table class="table table-striped" style="width:100%">
             <tr>
                <th>idSale</th>
                <th>idVendor</th>
                <th>SaleTotal</th>
             </tr>
             <c:forEach var="item" items="${sales}">

                 <tr>
                     <td>${item.getidSale()}</td>
                     <td>${item.getIdvendor()}</td>
                     <td>${item.getSaleTotal()}</td>
                 </tr>

             </c:forEach>

        </table>
        <table class="table table-striped" style="width:100%">
             <tr>
                <th>id</th>
                <th>idSale</th>
                <th>idProduct</th>
                <th>quantity</th>
                <th>subtotal</th>
                
             </tr>
             <c:forEach var="item1" items="${salesorders}">

                 <tr>
                     <td>${item1.getid()}</td>
                     <td>${item1.getidSale()}</td>
                     <td>${item1.getidProduct()}</td>
                     <td>${item1.getquantity()}</td>
                     <td>${item1.getsubtotal()}</td>
                 </tr>

             </c:forEach>

        </table>
    </body>
</html>
