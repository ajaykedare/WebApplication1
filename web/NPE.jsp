<%-- 
    Document   : NPE
    Created on : Aug 24, 2018, 2:24:20 PM
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
        <h1>Hello World in NPE.jsp!</h1>
        
        <%= new StringBuffer("Object has been garbage collected or set to null") %>
        <%= exception.getMessage() %>
        
    </body>
</html>
