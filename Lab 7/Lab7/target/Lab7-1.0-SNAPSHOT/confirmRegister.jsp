<%-- 
    Document   : confirmRegister
    Created on : 2 Jun 2024, 11:14:55 pm
    Author     : Arifah S66428
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%
    String studentid = request.getParameter("studentid");
    String name = request.getParameter("name");

    session.setAttribute("studentid", studentid);
    session.setAttribute("name", name);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Confirm Registration</title>
</head>
<body>
    <h1>Confirm Registration</h1>
    <p>Student ID: <%= studentid %></p>
    <p>Name: <%= name %></p>
    <form action="notificationRegister.jsp" method="POST">
        <input type="submit" value="Proceed"/>
    </form>
</body>
</html>
