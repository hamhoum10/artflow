/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Myconnection {
    
     static final String URL ="jdbc:mysql://localhost:3306/artiflow";
    static final String USER ="root";
    static final String PASSWORD ="";
    //var
    private Connection cnx;
    //1
    static Myconnection instance;
    
    private Myconnection(){
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public Connection getCnx() {
        return cnx;
    }

    //3
    public static Myconnection getInstance() {
        if(instance == null)
            instance = new Myconnection();
        
        return instance;
    }
    
    
    
}
