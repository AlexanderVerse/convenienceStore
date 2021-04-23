<%-- 
    Document   : ordenes
    Created on : 23-abr-2021, 9:23:17
    Author     : hapib
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New order</title>
    </head>
    <body>
        <h2>Orden</h2>
        <label>Vendor id: ${idVendor}</label><br>
        <label>Producto id:</label>
        <select name="productos">
            <c:forEach var="itemProducto" items="${listaProductos}">
                <option value="${itemProducto.getIdProduct()}">${itemProducto.getProductName()}</option>
            </c:forEach>
        </select><br>
        <label>Cantidad:</label><input type="text" value="" placeholder="Ingresa la cantidad" /><br>
        <label>Subtotal:</label>
        <input type="submit" value="Guardar" />
    </body>
</html>
