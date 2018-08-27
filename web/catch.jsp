<%-- 
    Document   : catch
    Created on : Aug 24, 2018, 2:11:47 PM
    Author     : akedare
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World in Catch JSP!</h1>
        
        <%= exception.getMessage() %>
        <% exception.printStackTrace();%>
    </body>
</html>
