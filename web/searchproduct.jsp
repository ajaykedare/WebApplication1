<%-- 
    Document   : searchproduct
    Created on : Aug 24, 2018, 4:19:06 PM
    Author     : akedare
--%>

<%@page import="com.model.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
    </head>
    <body>
        <div align="center" class="teal"> 
            <h2 >JAVA EE Training</h2>            
        </div>
        
        <div align="right">
            Welcome ... <%
                LoginBean login = (LoginBean) session.getAttribute("lb");
                out.println(login.getUsername());
                out.println("<br/>");
                session = request.getSession(false); // to continue in the same session
                out.println("Session Id: " + session.getId());
            %>
            </div>
        <hr/>
        
        <div align="center">
            <div style="border: solid 1px;padding: 20px; width:400px;">
                <form action="doSearch">
                    
                    <div class="row">
                        <div class="input-field col s12">
                          <input id="pname" type="text" class="validate" name="pname">
                          <label for="pname">Enter a product to search</label>
                        </div>
                    </div>
                    
                    <button class="btn" type="submit"> Search </button>
                </form>
                
            </div>
        </div>
    </body>
</html>
