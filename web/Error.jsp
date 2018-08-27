<%-- 
    Document   : Error
    Created on : Aug 23, 2018, 4:26:44 PM
    Author     : akedare
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Invalid username <b> <%= request.getParameter("username")%></b></h1>
        <a href="login.html"> Relogin</a>
    </body>
</html>
