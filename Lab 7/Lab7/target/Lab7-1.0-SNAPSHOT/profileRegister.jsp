<%-- 
    Document   : profileRegister
    Created on : 2 Jun 2024, 11:11:20 pm
    Author     : Arifah S66428
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Profile Registration</title>
</head>
<body>
    <h1>Profile Registration</h1>
    <form action="profileServlet" method="POST">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" maxlength="15" required/><br/>
        <label for="icno">IC No:</label>
        <input type="text" name="icno" id="icno" maxlength="15" required/><br/>
        <label for="firstname">First Name:</label>
        <input type="text" name="firstname" id="firstname" maxlength="50" required/><br/>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>

