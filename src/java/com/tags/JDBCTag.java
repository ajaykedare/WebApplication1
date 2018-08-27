/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author akedare
 */
public class JDBCTag extends SimpleTagSupport{

    private String driver;
    private String url;
    private String username;
    private String password;
    
    
    @Override
    public void doTag() throws JspException, IOException {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            
            getJspContext().getOut().println("Connection Established with the DB..." + conn);
            
        } catch (ClassNotFoundException | SQLException ex) { // Java7 feature: Multi catch block
            Logger.getLogger(JDBCTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    } 
}
