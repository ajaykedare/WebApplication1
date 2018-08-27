<%-- 
    Document   : logout
    Created on : Aug 24, 2018, 5:28:47 PM
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
        <div align="center" class="teal"> 
            <h2 >JAVA EE Training</h2>            
        </div>
        
        <div align="right">
            <%
                LoginBean login = (LoginBean) session.getAttribute("lb");
                //out.println(login.getUsername());
                out.println("<br/>");
                session = request.getSession(false); // to continue in the same session
                out.println("Session Id: " + session.getId());
                
                if(session !=null){
                    session.removeAttribute("mycart");
                    session.removeAttribute("lb");
                    session.invalidate();
                }
            %>
            </div>
        <hr/>
        <div align="center">
            <p>Thank you <b><%= login.getUsername()%></b> for visiting. </p> 
            <br/>
            <a href="login.html"> Relogin</a>
        </div>
    </body>
</html>
