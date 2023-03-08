/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ClientInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Client;
import models.Participant;
import utils.MyConnection;


/**
 *
 * @author Elizabeth
 */
public class ClientService implements  ClientInterface {

    Client c = new Client();
    Connection cnx = MyConnection.getInstance().getCnx();
    
    @Override
    public Client fetchClientByName(String username) {
       try {
            
            String req = "SELECT * FROM client WHERE `username` = '"+username+" '";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
               c.setId(rs.getInt("id"));
                c.setFirstname(rs.getString("firstname"));
                c.setLastname(rs.getString("lastname"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getInt("phonenumber"));
                c.setEmail(rs.getString("email"));
                c.setUsername(rs.getString("username"));
                   c.setPwd(rs.getString("password"));
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return c ;
    }   

    @Override
    public List<Client> fetchClient() {

        List<Client> client = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `client` ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                         Client cl = new Client();
                cl.setId(rs.getInt("id"));
                cl.setFirstname(rs.getString("firstname"));
                cl.setLastname(rs.getString("lastname"));
                cl.setAddress(rs.getString("address"));
                cl.setPhone(rs.getInt("phonenumber"));
                cl.setEmail(rs.getString("email"));
                cl.setUsername(rs.getString("username"));
                cl.setPwd(rs.getString("password"));
                client.add(cl);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return client;    }
    
    
    
    
    
     public void addClient(Client c) {

        try {
            String req = "INSERT INTO `client`(`firstname`, `lastname`, `address`, `phonenumber`, `email`, `username`,`password`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, c.getFirstname());
            st.setString(2, c.getLastname());
              st.setString(3, c.getAddress());
                st.setInt(4, c.getPhone());
                  st.setString(5, c.getEmail());
                    st.setString(6, c.getUsername());
                    st.setString(7, c.getPwd());
                 
           
            
          
            st.executeUpdate();
            System.out.println("client added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
    
    
    
    
    
    
  }

  
    
    
    

