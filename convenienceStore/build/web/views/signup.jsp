<%-- 
    Document   : signup
    Created on : 23-abr-2021, 3:44:30
    Author     : hapib
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="../user" method="get">
            <input type="submit" name="signupUser" value="Enviar">
        </form>
        <a href="../index.jsp">Log in</a>
    </body>
</html>
