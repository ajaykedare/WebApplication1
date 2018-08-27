<%-- 
    Document   : useTags
    Created on : Aug 24, 2018, 12:11:10 PM
    Author     : akedare
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/WEB-INF/tlds/mytags" prefix="ajay"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <h1>Hello World!</h1>
        <ajay:hello/>
        
        <br/>
        <ajay:jdbc driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" username="system" password="root123"/>
        <br/>
        
        <c:forEach begin="1" end="10" step="1" var="i">
            <c:out value="${i}"/>
            <br/>
        </c:forEach>
    

