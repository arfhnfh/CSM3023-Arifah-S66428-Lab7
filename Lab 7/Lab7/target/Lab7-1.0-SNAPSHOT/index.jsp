<%-- 
    Document   : index
    Created on : 29 May 2024, 3:56:24 pm
    Author     : Arifah S66428
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample Perform CRUD Using Java Servlet</title>
    </head>
    <body>
        <h1>Sample Perform CRUD Using Java Servlet!</h1>
        <jsp:forward page="/UserController?action=listUser" />
    </body>
</html>
