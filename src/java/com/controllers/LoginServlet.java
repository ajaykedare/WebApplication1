/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.model.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author akedare
 */
public class LoginServlet extends HttpServlet {
    
    @Resource(mappedName = "jdbc/AjayDS")
    private DataSource ds;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //Read the context from the web.xml
            String driver = getServletContext().getInitParameter("driver");            
            System.out.println("Context Param : "+ driver);
            
            
            //Read the server COnfig
            String outStyle = getServletConfig().getInitParameter("style");
            System.out.println("Out Style: " + outStyle);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            
            // 1. Read the Form parameters
            String name=request.getParameter("username");
            String pass = request.getParameter("password");
            
            String query = "select * from login where name=? and pass=?";
            try (Connection conn = ds.getConnection();) {
                                
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, pass);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    //out.println("<h3>Welcome....."+name+"</h3>");
                    //request.setAttribute("val", "This is value passed1");
                    //RequestDispatcher rd1 = request.getRequestDispatcher("/doSuccess");
                     
                    System.out.println("In success");
                    //Create a model and set to scope
                    LoginBean loginBean = new LoginBean();
                    loginBean.setUsername(rs.getString(1));
                    loginBean.setPassword(rs.getString(2));
                    
                    request.setAttribute("lb", loginBean);
                    
                    RequestDispatcher rd1 = request.getRequestDispatcher("Success.jsp");
                    rd1.forward(request, response);
                } else {
                    //out.println("<h3>Invalid Login for "+name+"</h3>");
                    //RequestDispatcher rd2 = request.getRequestDispatcher("/doError");
                    RequestDispatcher rd2 = request.getRequestDispatcher("Error.jsp");
                    rd2.forward(request, response);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            //4. Presentation
           
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
