<%-- 
    Document   : notificationRegister
    Created on : 2 Jun 2024, 11:15:21 pm
    Author     : Arifah S66428
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession httpSession = request.getSession(false);
    if (httpSession != null) {
        String studentid = (String) httpSession.getAttribute("studentid");
        String name = (String) httpSession.getAttribute("name");
        httpSession.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Notification</title>
</head>
<body>
    <h1>Registration Successful</h1>
    <p>Student ID: <%= studentid %></p>
    <p>Name: <%= name %></p>
    <a href="studentRegister.jsp">Register Another Student</a>
</body>
</html>
<%
    } else {
%>
<p>Session expired. Please <a href="studentRegister.jsp">register again</a>.</p>
<%
    }
%>
