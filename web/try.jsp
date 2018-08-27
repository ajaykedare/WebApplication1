<%-- 
    Document   : try
    Created on : Aug 24, 2018, 2:08:16 PM
    Author     : akedare
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page errorPage="catch.jsp"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World in the try.jsp !</h1>
        
        <!--Dynamic Include-->
        <jsp:include page="login.html"/>
        
        <!--Static Include-->
        
        <%@include file="login.html" %>%>
        <%
            out.println("Division 5/0 = ");
            int result = 5/2;
            out.println("Result = " + result);
            
            String name="ds";
            out.println(name.length());

        %>
    </body>
</html>
