<%-- 
    Document   : displayproduct
    Created on : Aug 24, 2018, 5:13:11 PM
    Author     : akedare
--%>

<%@page import="com.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.model.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                
                List<Product> pList = (List<Product>) request.getAttribute("pList");
                //out.println("pList Size:" + pList.size());
            %>
            </div>
            <div align="right">
             <form action="logout.jsp" method="GET">                    
                    <button class="btn" type="submit"> Logout </button>
             </form>
            </div>
                    
        <hr/>
        
        <div align="center">
            <div style="border: solid 1px;padding: 20px; width:600px;">
                <c:choose>
                    <c:when test="${pList.size() > 0}">
                    <table border="1">
                        <thead>
                            <th>Id</th>
                            <th>Product Name</th>
                            <th>Product Type</th>
                            <th>Manufacturer</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${pList}" var="prod">
                              <tr>
                                <td><c:out value="${prod.pId}" /></td>
                                <td><c:out value="${prod.pName}" /></td>
                                <td><c:out value="${prod.pType}" /></td>
                                <td><c:out value="${prod.pManf}" /></td>
                                <td><c:out value="${prod.quantity}" /></td>
                                <td><c:out value="${prod.price}" /></td>
                              </tr>
                            </c:forEach>
                        </tbody>
                      </table>
                    </c:when>
                    <c:otherwise>
                        There are no matching products found ! 
                        <br/>
                         <a href="searchproduct.jsp">Search</a> again.
                    </c:otherwise>
                </c:choose>
                
            </div>
        </div>
        
    </body>
</html>
