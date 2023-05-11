/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import services.AdminService;
import interfaces.ClientInterface;
import models.Client;
import models.User;
import util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import models.Artiste;
import org.springframework.security.crypto.bcrypt.BCrypt;
import pidevAuth.LoginFXMLController;
import static pidevAuth.WelcomePageController.static_userwelcome;

/**
 *
 * @author kanza
 */
public class ClientService implements ClientInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

        public boolean exists(String username) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM client");
    ResultSet rs = a.executeQuery();
   
     while (rs.next()) {
        if (username.equals(rs.getString("username"))) {
            System.out.println("this user already exists");
            
            return true;
        }
    }
    return false;

}
    
        public boolean isValidEmail(String email) throws SQLException {
       String em ="^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM Client");
    ResultSet rs = a.executeQuery();
     while (rs.next()) {
        Pattern pattern = Pattern.compile(em);
    return pattern.matcher(email).matches();
    }
    return false;

}
    public boolean validphonenumber(String phonenumber) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM client");
    ResultSet rs = a.executeQuery();
    String cutString = phonenumber.substring(0, 8);
     while (rs.next()) {
        if (phonenumber!=cutString) {
            System.out.println("coorect your phonenb");
            return true;
        }
    }
    return false;

}
  
    @Override
    public Client saveClient(Client p) {
        String email= p.getEmail();
        
//        
        try {
            if(exists(p.getUsername())!=true){
//                if(isValidEmail(email)){
//                if(validphonenumber(p.getPhonenumber())!=true){
            try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `client`(`firstname`, `lastname`,`address`, `phonenumber`,`email`,`username`, `password`) VALUES (?,?,?,?,?,?,?)");
//            String password = p.getPassword();
//                    String saltvalue = PassBasedEnc.getSaltvalue(30);  
//
//            String encryptedPassword = PassBasedEnc.generateSecurePassword(password, saltvalue);
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getAddress());
            a.setString(4, p.getPhonenumber());
            a.setString(5, p.getEmail());
            a.setString(6, p.getUsername());
            a.setString(7,p.getPassword());
            a.executeUpdate();
            System.out.println("client Added successfully!");
         } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
//                }}
            } 
        }catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;    }

    @Override
    public List<Client> fetchClient() {
        List<Client> client = new ArrayList<>();
        try {
            String req = "SELECT * FROM client";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Client p = new Client();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setAddress(rs.getString("address"));
                p.setPhonenumber(rs.getString("phonenumber"));
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
            String req =  "UPDATE `client` SET `firstname`=?,`lastname`=?,`address`=?,`phonenumber`=?,`email`=?,`username`=?,`password`=? WHERE `username`=?";
            PreparedStatement a = cnx.prepareStatement(req);
//            String password = p.getPassword();
//            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());            
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getAddress());
            a.setString(4, p.getPhonenumber());
            a.setString(5, p.getEmail());
            a.setString(6, p.getUsername());
            a.setString(7, p.getPassword());
            a.setString(8, p.getUsername());
            a.executeUpdate();
            System.out.println("client modified successfully!");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void deleteClient(String username) {
try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `client` WHERE username=?");
            
            a.setString(1, username);
            a.executeUpdate();
            System.out.println("client deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public Client getClientbyusername(String username) {
               //List<User> users = new ArrayList<>();
        Client u =new Client();
        try {
            String req = "SELECT * FROM `client` WHERE username= "+"'"+username+"'" ;
               PreparedStatement ste = cnx.prepareStatement(req);
//               ste.setString(1, username);
               ResultSet rs = ste.executeQuery();
//            String req ="SELECT * FROM user WHERE `id`=?";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//PreparedStatement a1 = cnx.prepareStatement("SELECT * FROM user WHERE `id`=?");
//                ResultSet rs=a1.executeQuery();
//            stmt = cnx.prepareStatement(req);
//            stmt.setInt(1,u.getId() ); // set the ID to fetch
//            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //User u = new User(rs.getString("username"),rs.getString("password"),rs.getString("type"));
               
                u.setId(rs.getInt("id"));
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setAddress(rs.getString("address"));
                u.setPhonenumber(rs.getString("phonenumber"));
                u.setEmail(rs.getString("email"));                
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                
                //users.add(u);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
}
     public int getidclientbyusername(String username) throws SQLException{
         int id_client=0;
         
try {
    String req ="select `id` from `client`where `username`= ?";

            PreparedStatement a = cnx.prepareStatement( req); 
            a.setString(1, username);
            ResultSet rs= a.executeQuery();
            while(rs.next()){
            id_client=rs.getInt("id");
            System.out.println("client added successfully!");}
            //a.close();
       
     }
 catch (SQLException ex) {
            ex.printStackTrace();
        }
return id_client; 
     }
    
     
     
     
     
     
     
     
     
     
     
     }
