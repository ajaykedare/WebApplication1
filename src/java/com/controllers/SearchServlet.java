/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

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
@WebServlet(name = "SearchServlet", urlPatterns = {"/doSearch"})
public class SearchServlet extends HttpServlet {

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
            
            HttpSession session = request.getSession(false);
            
            if(session != null) {
                String pName=request.getParameter("pname");
                System.out.println("Product to search :" + pName);
                String query = "select * from product where pName =? ";
                 try (Connection conn = ds.getConnection();) {

                    PreparedStatement ps = conn.prepareStatement(query);
                     System.out.println("ps:" + ps);
                    //ps.setString(1, "'%"+pName+"%'");
                    ps.setString(1, pName);
                    ResultSet rs = ps.executeQuery();
                    List<Product> pList = new ArrayList<>();
                    while(rs.next()){
                        Product product = new Product();
                        product.setpId(rs.getInt("pId"));
                        product.setpName(rs.getString("pName"));
                        product.setpType(rs.getString("pType"));
                        product.setpManf(rs.getString("pManf"));
                        product.setQuantity(rs.getDouble("quantity"));
                        product.setPrice(rs.getDouble("price"));
                        
                        pList.add(product);
                    } 
                     System.out.println("Product :" + pList.size());
                    request.setAttribute("pList", pList);
                    
                    RequestDispatcher rd1 = request.getRequestDispatcher("displayproduct.jsp");
                    rd1.forward(request, response);
                 }catch(SQLException ex){
                     ex.printStackTrace();
                 }
            } else {
                
                out.println("Session Expired...Please ");
                out.println("<a href=\"login.html\"> Relogin</a>");               
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
