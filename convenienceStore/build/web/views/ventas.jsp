<%-- 
    Document   : ventas
    Created on : 23-abr-2021, 12:06:29
    Author     : hapib
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mis ventas</h1>
        <c:forEach var="venta" items="${listaVentas}">
            <label>Venta: ${venta.getidSale()}</label><br>
            <label>Vendedor: ${venta.getIdvendor()}</label><br>
            <label>Total: ${venta.getSaleTotal()}</label><br><br>
            <input type="text" name="idVendor" value="${idVendor}" style="display: none">
        </c:forEach>
        <form action="controller_orders" method="post" >
            <input type="submit" name="callOrdersControllerRequest" value="Nueva venta" />
        </form>
    </body>
</html>
