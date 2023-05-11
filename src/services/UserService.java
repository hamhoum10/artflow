/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.UserInterface;
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
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author kanza
 */
public class UserService implements UserInterface {
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
     public User Userinsert(User u){
         
    try {
    PreparedStatement a1 = cnx.prepareStatement("INSERT INTO `user`(`username`,`email` `password`,`roles`) VALUES (?,?,?,?)");
    String password = u.getPassword();
    String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    a1.setString(1, u.getUsername());
     a1.setString(2, u.getEmail());
    a1.setString(3, encryptedPassword);
    a1.setString(4, u.getRoles());
    a1.executeUpdate();
        System.out.println("user added succefully");
     } catch (SQLException ex) {
        ex.printStackTrace();
      }
    return u;
     }
     @Override
     public int test(String username, String password){
         int i= -1;
         try{   
             PreparedStatement a1 = cnx.prepareStatement("SELECT `username`,`email` `password`,`roles` FROM user");

        //a1.setString(1, u.getUsername());

            ResultSet rs=a1.executeQuery();
           // System.out.println(u.getUsername().equals(rs.getString("username")));
           while(rs.next()){
               User m =new User();
                String pwd = password;
    String encryptedPassword = BCrypt.hashpw(pwd, BCrypt.gensalt());
                if (username.equals(rs.getString("username"))==false||encryptedPassword.equals(rs.getString("password"))==false){
                      i=1;
                    System.out.println("loged in userservice");
                    break;

                }
//                else{
//                    System.out.println("log");
//                    i= 1;
//                    //break;
//
//                }
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        //System.out.println(i);
        // System.out.println(i);
           return i;

     
     
     
     }
     
     
      @Override
    public void UpdateUser(User p) {
               try {
            String req =  "UPDATE `user` SET `username`=?,`email`=?,`password`=? WHERE `username`=?";
            PreparedStatement a = cnx.prepareStatement(req);
//            String password = p.getPassword();
//            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());            
           
            a.setString(1, p.getUsername());
            a.setString(2, p.getRoles());
            a.setString(3, p.getPassword());
           // a.setString(3, p.getType());
            a.setString(4, p.getUsername());
            a.executeUpdate();
            System.out.println("user modified successfully!");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
     
     @Override
      public int authentification(User m){
       int i=0 ;
//               String saltvalue = PassBasedEnc.getSaltvalue(30);  

       			//StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();     

        try {
    PreparedStatement a1 = cnx.prepareStatement("SELECT * FROM `user` WHERE username=?");
    a1.setString(1, m.getUsername());
    
        
            ResultSet rs=a1.executeQuery();
            //while(rs.next()){
                if (m.getUsername().equals(rs.getString("username"))){
                    i= 1;  
                    System.out.println("loged in");

                }
                else{
                    System.out.println("error");

                    i= -1;
                   
                }
           // }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
//          if (i==-1){
//                    System.out.print("verify your info \n");
//                }
//                else{
//                    i=1;
//                     System.out.print("user authentifié avec succés \n");
//                }
       
      return i ;     
   }

    @Override
    public List<User> fetchUser() {
List<User> user = new ArrayList<>();
        try {
            String req = "SELECT * FROM user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                User p = new User();
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));

                user.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return user;
    }    
        PreparedStatement stmt = null;

    @Override
    public List<User> getUserbyId(int id) {
               List<User> users = new ArrayList<>();
        //User u =new User();
        try {
            String req = "SELECT * FROM `user` WHERE id=?";
               PreparedStatement ste = cnx.prepareStatement(req);
               ste.setInt(1, id);
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
                User u = new User(rs.getInt(1),rs.getString("username"),rs.getString("email"),rs.getString("password"),rs.getString("roles"));
               
//                u.setId(rs.getInt(1));
//                u.setUsername(rs.getString("username"));
//                u.setPassword(rs.getString("password"));

                users.add(u);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
}
    
    
    @Override
    public User getUserbyusername(String username) {
               //List<User> users = new ArrayList<>();
        User u =new User();
        try {
            String req = "SELECT * FROM `user` WHERE username="+ "'"+username+"'";
               PreparedStatement ste = cnx.prepareStatement(req);
//               ste.setString(1, username);
//               ResultSet rs = ste.executeQuery();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
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
               
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setRoles(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setUsername(rs.getString(5));
               
                //users.add(u);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
}
    
     @Override
    public void deleteUser(String username) {
try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `user` WHERE username=?");
            
            a.setString(1, username);
            a.executeUpdate();
            System.out.println("user deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    }
     

