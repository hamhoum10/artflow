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
import models.Artiste;
import models.Client;
import util.MyConnection;

/**
 *
 * @author MediaStudio
 */
public class ClientService implements ClientInterface {
           Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public Client fetchClientByName(String name) {
Client client = new Client();
        try {
            
            String req = "SELECT * FROM client WHERE Nom_client = '"+name+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                client.setId_client(rs.getInt(1));
                client.setNom_client(rs.getString(2));
                client.setPrenom_client(rs.getString(3));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return client;    }

    @Override
    public List<Client> fetchClient() {
    List<Client> client = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `client` ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Client e = new Client();
                e.setId_client(rs.getInt("Id_client"));

                e.setNom_client(rs.getString("Nom_client"));
                e.setPrenom_client(rs.getString("Prenom_client"));
                

                client.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return client;    }
    
}
