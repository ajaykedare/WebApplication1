<%-- 
    Document   : Hello
    Created on : Aug 23, 2018, 3:54:01 PM
    Author     : akedare
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Welcome Ajay ...!!
        You logged in at <%= new Date() %>
        <br/>
        Another way to print:
        <%
            Date d = new Date();
            out.println(d);
        %>
    </body>
</html>
