<%-- 
    Document   : Success
    Created on : Aug 23, 2018, 4:19:21 PM
    Author     : akedare
--%>

<%@page import="com.model.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            Welcome ..<b><%= request.getParameter("username")%></b> 
        </h1>
        You are successfully logged in.
        
        <br/>
        
<!--        <div>Welcome in MVC</div>
        
        
            <% 
                LoginBean lbean= (LoginBean) request.getAttribute("lb");                
                out.println("Hi.."+lbean.getUsername());
            %>
        
        
        <br/>
        Welcome in MVC1 with standard actions....
        
        <jsp:useBean id="lb" class="com.model.LoginBean" scope="request"> </jsp:useBean>
        <jsp:getProperty name="lb" property="username"></jsp:getProperty> !!-->
        
        <br/>
        
        <jsp:useBean id="lb1" class="com.model.LoginBean" scope="request">
            <jsp:setProperty name="lb1" property="username" />
        </jsp:useBean>
        <jsp:getProperty name="lb1" property="username"></jsp:getProperty>
        Welcome in EL in MVC1....
        ${lb1.username}
        
    </body>
</html>
