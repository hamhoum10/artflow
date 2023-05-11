/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ArtisteInterface;
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
import models.Categorie;
import models.User;
import util.MyConnection;
import static pidevAuthArtiste.LoginArtisteController.usernameArtiste;

/**
 *
 * @author MediaStudio
 */
public class ArtisteService implements ArtisteInterface {
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public Artiste fetchArtisteByName(String name) {
      Artiste artiste = new Artiste();
        try {
            
            String req = "SELECT * FROM Artiste WHERE username = '"+name+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                artiste.setId(rs.getInt(1));
                artiste.setFirstname(rs.getString(2));
                artiste.setLastname(rs.getString(3));
                artiste.setUsername(rs.getString("username"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return artiste;
    }  
    
    

//    @Override
//    public List<Artiste> fetchArtiste() {
//List<Artiste> artiste = new ArrayList<>();
//        try {
//            
//            String req = "SELECT * FROM `artiste` ";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {                
//                Artiste e = new Artiste();
//                e.setId(rs.getInt("Id_artiste"));
//
//                e.setFirstname(rs.getString("Firstname"));
//                e.setLastname(rs.getString("Lastname"));
//                
//
//                artiste.add(e);
//            }
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//        return artiste;    }
//        
    
    public String getArtistNameById(String id){
        System.out.println(fetchArtiste().stream().filter(a->a.getUsername()==id).findFirst().get().getFirstname());
        return fetchArtiste().stream().filter(a->a.getUsername()==id).findFirst().get().getFirstname();
        
    }
        
        
        public boolean exists(String username) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM artiste");
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
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM artiste");
    ResultSet rs = a.executeQuery();
     while (rs.next()) {
        Pattern pattern = Pattern.compile(em);
    return pattern.matcher(email).matches();
    }
    return false;

}
    public boolean validphonenumber(String phonenumber) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM artiste");
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
     public User Userinsert(User u){
    try {
    PreparedStatement a1 = cnx.prepareStatement("INSERT INTO `user`(`username`, `password`,`type`) VALUES (?,?,?)");
    ResultSet rs = a1.executeQuery();
    a1.setString(1, u.getUsername());
    a1.setString(2, u.getPassword());
    a1.setString(3, u.getRoles());
    a1.executeUpdate();
        System.out.println("0000");
     } catch (SQLException ex) {
        ex.printStackTrace();
      }
    return u;
     }

    
    @Override
    public Artiste saveArtiste(Artiste p) {
        String email= p.getEmail();
        
        try {
            if(exists(p.getUsername())!=true){
//                if(isValidEmail(email)){
//                if(validphonenumber(p.getPhonenumber())!=true){
                   
        try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `artiste`(`firstname`, `lastname`,`birthplace`,`birthdate`,`description`,`image`,`address`, `phonenumber`,`email`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
//            String password = p.getPassword();
//            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            //FileInputStream imagefile= new FileInputStream(p.getImage());
           // fls= new FileInputStream(file);
            //byte[] image =new byte[imagefile.available()];
            //imagefile.read(image);
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getBirthplace());
            a.setDate(4, p.getBirthdate());
            a.setString(5, p.getDescription());
            a.setString(6, p.getImage());
            a.setString(7, p.getAddress());
            a.setString(8, p.getPhonenumber());
            a.setString(9, p.getEmail());
            a.setString(10, p.getUsername());
            a.setString(11, p.getPassword());
            
            a.executeUpdate();
           System.out.println("artiste Added successfully!");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
               // }}
            } 
        }catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Artiste> fetchArtiste() {
          List<Artiste> artiste = new ArrayList<>();
          
        try {
            String req = "SELECT * FROM artiste";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Artiste p = new Artiste();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setBirthplace(rs.getString("birthplace"));
                p.setBirthdate(rs.getDate("birthdate"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                p.setAddress(rs.getString("address"));
                p.setPhonenumber(rs.getString("phoneNumber"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));

                artiste.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return artiste;
    }

    @Override
    public Artiste getArtiste(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateArtiste(Artiste p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "UPDATE `artiste` SET `firstname`=?,`lastname`=?,`birthplace`=?,`birthdate`=?,`description`=?,`image`=?,`address`=?,`phoneNumber`=?,`email`=?,`username`=?,`password`=? WHERE `username`=?");
//            String password = p.getPassword();
//            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getBirthplace());
            a.setDate(4, p.getBirthdate());
            a.setString(5, p.getDescription());
            a.setString(6, p.getImage());
            a.setString(7, p.getAddress());
            a.setString(8, p.getPhonenumber());
            a.setString(9, p.getEmail());
            a.setString(10, p.getUsername());
            a.setString(11, p.getPassword());

            a.setString(12, p.getUsername());


            a.executeUpdate();
            System.out.println("artiste modified successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteArtiste(String username) {
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `artiste` WHERE username=?");
            
            a.setString(1, username);
            a.executeUpdate();
            System.out.println("artiste deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public Artiste getArtistebyusername(String username) {
               //List<User> users = new ArrayList<>();
        Artiste u =new Artiste();
        try {
            String req = "SELECT * FROM `artiste` WHERE username=?";
               PreparedStatement ste = cnx.prepareStatement(req);
               ste.setString(1, username);
               ResultSet rs = ste.executeQuery();
               
            while (rs.next()) {
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
    
    
    public int getidArtistbyUsername(String username){
        Artiste u =new Artiste();
        int id=0;
        try {
            String req = "SELECT id FROM `artiste` WHERE username=?";
               PreparedStatement ste = cnx.prepareStatement(req);
               ste.setString(1, username);
               ResultSet rs = ste.executeQuery();
               
            while (rs.next()) {
               
                u.setId(rs.getInt("id"));
                id =u.getId();
//                System.out.println(id_artiste);
                
                //users.add(u);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    
    
    
     public int getidArtistetbyusername(String username) throws SQLException{
         int id=0;
         
try {
    String req ="select `id` from `artiste`where `username`= ?";

            PreparedStatement a = cnx.prepareStatement( req); 
            a.setString(1, username);
            ResultSet rs= a.executeQuery();
            while(rs.next()){
            id=rs.getInt("id");
            System.out.println("client added successfully!");}
            //a.close();
       
     }
 catch (SQLException ex) {
            ex.printStackTrace();
        }
return id; 
     }
    
    
    

//    @Override
//    public Artiste fetchArtisteByName(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
}

