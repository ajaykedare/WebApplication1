/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.model.LoginBean;
import com.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author akedare
 */
@WebServlet(name = "LoginSessionServlet", urlPatterns = {"/doLoginSession"})
public class LoginSessionServlet extends HttpServlet {

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
            
            System.out.println("In LoginSession ");
            // 1. Read the Form parameters
            String name=request.getParameter("username");
            String pass = request.getParameter("password");
            
            
            System.out.println("Name: " + name);
            System.out.println("Pass: " + pass);
            String query = "select * from login where name=? and pass=?";
            try (Connection conn = ds.getConnection();) {
                                
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, pass);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                     
                    out.println("In success");
                    LoginBean loginBean = new LoginBean();
                    loginBean.setUsername(rs.getString(1));
                    loginBean.setPassword(rs.getString(2));
                    
                    HttpSession session = request.getSession(true);
                    System.out.println("Session Id:" + session.getId());
                    List<Product> cart = new ArrayList<>();
                    session.setAttribute("lb", loginBean);
                    session.setAttribute("mycart", cart);
                    
                    RequestDispatcher rd1 = request.getRequestDispatcher("searchproduct.jsp");
                    rd1.forward(request, response);
                    
                    
                } else {
                    RequestDispatcher rd2 = request.getRequestDispatcher("Error.jsp");
                    rd2.forward(request, response);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            
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
