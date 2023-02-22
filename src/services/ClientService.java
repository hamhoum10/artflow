/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ClientInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Client;
import utils.MyConnection;


/**
 *
 * @author Elizabeth
 */
public class ClientService implements  ClientInterface {

    Client c = new Client();
    Connection cnx = MyConnection.getInstance().getCnx();
    
    @Override
    public Client fetchClientByName(String nom) {
       try {
            
            String req = "SELECT * FROM client WHERE `nom` = '"+nom+" '";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
               c.setIdc(rs.getInt("idc"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
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

                cl.setIdc(rs.getInt("idc"));

               cl.setNom(rs.getString("nom"));
               cl.setPrenom(rs.getString("prenom"));
                

                client.add(cl);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return client;    }
    
    
    
  }

  
    
    
    

