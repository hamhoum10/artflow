/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.ClientInterface;
import Models.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Myconnection;
import java.util.regex.Pattern;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.springframework.security.crypto.bcrypt.BCrypt;


/**
 *
 * @author Lenovo
 */
public class ClientService implements ClientInterface{
    Connection cnx = Myconnection.getInstance().getCnx();

    @Override
    public Client saveClient(Client p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `client`(`firstname`, `lastname`,`address`, `phonenumber`,`email`,`username`, `password`) VALUES (?,?,?,?,?,?,?)");
            
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getAddress());
            a.setString(4, p.getEmail());
            a.setString(5, p.getPhonenumber());
            a.setString(6, p.getUsername());
            a.setString(7, p.getPassword());
            a.executeUpdate();
            System.out.println("client Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;    }

    @Override
    public List<Client> fetchClients() {
         List<Client> client = new ArrayList<>();
        try {
            String req = "SELECT * FROM client";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Client p = new Client();
                p.setId_client(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setAddress(rs.getString("address"));
                p.setPhonenumber(rs.getString("phoneNumber"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));

                client.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return client;
        
    }

    @Override
    public Client getClient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateClient(Client p) {
         try {
            String req =  "UPDATE `client` SET `firstname`=?,`lastname`=?,`address`=?,`phonenumber`=?,`email`=?,`username`=?,`password`=? WHERE `id`=?";
            PreparedStatement a = cnx.prepareStatement(req);
            String password = p.getPassword();
          //  String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());            
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getAddress());
            a.setString(4, p.getPhonenumber());
            a.setString(5, p.getEmail());
            a.setString(6, p.getUsername());
           // a.setString(7, encryptedPassword);
            a.setInt(8, p.getId_client());
            a.executeUpdate();
            System.out.println("client modified successfully!");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteClient(int id) {
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `client` WHERE id=?");
            
            a.setInt(1, id);
            a.executeUpdate();
            System.out.println("client deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Client fetchClientByName(String name) {
        Client client = new Client();
        try {
            String req = "SELECT * FROM client where firstname ='"+name+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                client.setId_client(rs.getInt(1));
                client.setFirstname(rs.getString("firstname"));
                client.setLastname(rs.getString("lastname"));
                client.setAddress(rs.getString("address"));
                client.setPhonenumber(rs.getString("phoneNumber"));
                client.setEmail(rs.getString("email"));
                client.setUsername(rs.getString("username"));
                client.setPassword(rs.getString("password"));
                System.out.println(client);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(client);
        return client;
    }
       
    }
    

    
    

