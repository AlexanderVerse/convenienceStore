<%-- 
    Document   : ventas
    Created on : 23-abr-2021, 12:06:29
    Author     : hapib
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mis ventas</h1>
        <form action="controller_orders" method="post" >
            <input type="submit" name="callOrdersControllerRequest" value="Nueva venta" />
        </form>
    </body>
</html>
