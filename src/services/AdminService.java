    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;
import interfaces.AdminInterface;
import models.Admin;
import models.User;
import util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author kanza
 */
public class AdminService implements AdminInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

    
    public boolean exists(String username) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM admin");
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
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM Admin");
    ResultSet rs = a.executeQuery();
     while (rs.next()) {
        Pattern pattern = Pattern.compile(em);
    return pattern.matcher(email).matches();
    }
    return false;

}
    public boolean validphonenumber(String phoneNumber) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM Admin");
    ResultSet rs = a.executeQuery();
    String cutString = phoneNumber.substring(0, 8);
     while (rs.next()) {
        if (phoneNumber!=cutString) {
            System.out.println("coorect your phonenb");
            return true;
        }
    }
    return false;

}
//       public boolean insertuser(User user) throws SQLException {
//    
//    Admin p=new Admin();
//    PreparedStatement a = cnx.prepareStatement("INSERT INTO `user`(`username`,`email`,`password`,`roles`) VALUES (?,?,?,?)");
//    ResultSet rs = a.executeQuery();
//     while (rs.next()) {
//        if (user.getRoles()!="admin") {
//            user.setUsername(p.getUsername());
//            user.setPassword(p.getPassword());
//            user.setType("admin");
//            System.out.println("u re not an admin");
//            return true;
//        }
//    }
//     
//    return false;
//
//}
    
    
    @Override
    public Admin saveAdmin(Admin p) {
        String email= p.getEmail();
        try {
            if(exists(p.getUsername())!=true){
//                if(isValidEmail(email)){
//                if(validphonenumber(p.getPhoneNumber())!=true){
                   
                    try {
                        PreparedStatement a = cnx.prepareStatement( "INSERT INTO `admin`(`firstname`, `lastname`, `email`, `phonenumber`, `username`, `password`) VALUES (?,?,?,?,?,?)");
//                        String password = p.getPassword();
//                        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                        a.setString(1, p.getFirstname());
                        a.setString(2, p.getLastname());
                        a.setString(3, p.getEmail());
                        a.setString(4, p.getPhoneNumber());
                        a.setString(5, p.getUsername());
                        a.setString(6, p.getPassword());
                        a.executeUpdate();
                        
                        System.out.println("Admin Added successfully!");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
//                }}
            } 
        }catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Admin> fetchAdmin() {
          List<Admin> admin = new ArrayList<>();
          
        try {
            String req = "SELECT * FROM admin";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Admin p = new Admin();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setEmail(rs.getString("email"));
                p.setPhoneNumber(rs.getString("phonenumber"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                
                admin.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return admin;
    }

    @Override
    public Admin getAdmin(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAdmin(Admin p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "UPDATE `admin` SET `firstname`=?,`lastname`=?,`email`=?,`phonenumber`=?,`username`=?,`password`=? WHERE `username`=?");
//             String password = p.getPassword();
//             String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getEmail());
            a.setString(4, p.getPhoneNumber());
            a.setString(5, p.getUsername());
            a.setString(6, p.getPassword());
            a.setString(7, p.getUsername());

            a.executeUpdate();
            System.out.println("Admin modified successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAdmin(String username) {
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `admin` WHERE username=?");
            
            a.setString(1, username);
            a.executeUpdate();
            System.out.println("Admin deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }