/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.EvenementInterface;
import models.Artiste;
import models.Evenement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidevAuthAdmin.LoginAdminController;
import pidevAuthArtiste.LoginArtisteController;
import util.MyConnection;

 


/**
 *
 * @author Lenovo
 */
public class EvenementService  implements EvenementInterface{
    Connection cnx = MyConnection.getInstance().getCnx();
    
        public boolean exists(String name) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM evemt");
    ResultSet rs = a.executeQuery();
     while (rs.next()) {
        if (name.equals(rs.getString("name"))) {
            System.out.println("Veuillez choisir un autre theme");
            return true;
        }
    }
    return false;

}
      public String SelectUsernameById(int Id) throws SQLException{
     String username = "";   
    String req = "SELECT username from artiste where id_artiste = "+Id;  
     Statement st = cnx.createStatement();
      ResultSet rs = st.executeQuery(req);
      while (rs.next()){
       username = rs.getString("username");
    }
      return username;
    }

    @Override
    public void addEvenement(Evenement e) {
      
        try {
            
            String req = "INSERT INTO `evemt`(`date_evemt`, `description`,`finish_hour`,`start_hour`, `location`,`capacity`,`image`,`name`,`id_artiste`,`prix`,`username`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
//            FileInputStream videoFile = new FileInputStream(e.getImage());
//            byte[] image = new byte[videoFile.available()];
//            videoFile.read(image);
            
            //ps.setString(1, e.getDate());
           //ps.setDate(1, e.getDate_evemt());
//            LocalDate date = date_.getValue();
//            en.setDate_limite(java.sql.Date.valueOf(date));
            //ps.setDate(1, e.getDate_evemt()!= null ? Date.valueOf(e.getDate_evemt()) : null);
             
         // ps.setDate(1, Date.valueOf(e.getDate_evemt()));
          ps.setDate(1, e.getDate_evemt());
            ps.setString(2, e.getDescription());
            ps.setString(3, e.getFinish_hour());
            ps.setString(4, e.getStart_hour());
             ps.setString(5, e.getLocation());
            ps.setString(6, e.getCapacity());
           ps.setString(7,e.getImage());
           
           
            
            ps.setString(8, e.getName());
            //ps.setInt(9, e.getId().getId_artiste());
           // ps.setInt(9, e.getId_artiste().getId_artiste());
         //  ps.setInt(9, e.getArtiste().getId_artiste());
        //  ps.setInt(9, e.getArtiste().getId_artiste());
         ps.setInt(9, e.getArtiste().getId());
         
       
        
            ps.setDouble(10, e.getPrix());
            
            ps.setString(11, LoginArtisteController.usernameArtiste);
          
           ps.executeUpdate();
            System.out.println("Evenement Ajoute avec Success!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        catch (FileNotFoundException ex) {
//            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
//        }   
        

    }
   
    

    @Override
    public List<Evenement> fetchEvenements() {
        List<Evenement> Evenements = new ArrayList<>();
        List<Artiste> artiste = new ArrayList<>();
        ArtisteService as = new ArtisteService();
        try {
            
            //String req = "SELECT * FROM evemt AS e JOIN artiste AS a ON e.username = a.username";  
            String req = "SELECT * FROM evemt ";  
           //""
           //SELECT * FROM evemt as e join artiste as a on e.id_artiste=a.id_artiste
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Evenement e = new Evenement();
               e.setId(rs.getInt(1));
            //e.setDate(rs.getString(2));
            e.setDate_evemt(rs.getDate(3));
            e.setDescription(rs.getString(4));
            e.setFinish_hour(rs.getString(5));
            e.setStart_hour(rs.getString(6));
            e.setLocation(rs.getString(7));
             e.setCapacity(rs.getString(8));
              e.setImage(rs.getString(9));
               e.setName(rs.getString(10));
//               e.setArtiste(rs.getInt());
               e.setPrix(rs.getDouble(11));
               e.setUsername((rs.getString(12)));
                                                                    
                
               Evenements.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Evenements;
    }
    

    @Override
    public void modEvenement(Evenement e) {
        
        try {    
            String req = "update `evemt` set `date_evemt`=?, `description`=?, `finish_hour`=?, `start_hour`=?, `location`=?, `capacity`=?, `image`=?, `name`=?, `id_artiste`=? ,`prix`=?,`username`=? where `id` =? ";
            PreparedStatement ps = cnx.prepareStatement(req);
           
           //ps.setString(1, e.getDate());
         //  ps.setDate(1, e.getDate());
         //ps.setDate(1, e.getDate_evemt());
           ps.setDate(1, e.getDate_evemt());
           ps.setString(2, e.getDescription());
           ps.setString(3, e.getFinish_hour());
           ps.setString(4, e.getStart_hour());
           ps.setString(5, e.getLocation());
           ps.setString(6, e.getCapacity());
           ps.setString(7, e.getImage());
           ps.setString(8, e.getName());
           ps.setInt(9, e.getArtiste().getId());
           ps.setDouble(10, e.getPrix());
           ps.setString(11, LoginArtisteController.usernameArtiste);
           
           
           ps.setInt(12, e.getId());
           

         
           
             ps.executeUpdate();
          
            System.out.println("Evenement a ete Modifie avec  Success!");
           
            
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public ArrayList sortBy(String nom_column, String Asc_Dsc) {
        ArrayList<Evenement> evenements = new ArrayList<>();
         
        try {
            
            String req = "SELECT * FROM evemt ORDER BY "+nom_column + " "+Asc_Dsc+" ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Evenement e  = new Evenement();
                 e.setId(rs.getInt(1));
                // e.setDate_evemt(2, Date.valueOf(e.getDate_evemt()));
                 e.setDescription(rs.getString(3));
                 e.setFinish_hour(rs.getString(4));
                 e.setStart_hour(rs.getString(5));
                 e.setLocation(rs.getString(6));
                 e.setCapacity(rs.getString(7));
                 e.setImage(rs.getString(8));
                 e.setName(rs.getString(9));
                 e.setPrix(rs.getDouble(10));
                 
                 
                 
                 
                 
                 
                evenements.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return evenements;
    
    }

    @Override
    public Evenement readById(int id) {
         Evenement e = new Evenement();
         ArtisteService as = new ArtisteService();

        
 
             try {
            
            String req = "SELECT * FROM evemt WHERE id= "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
           while (rs.next()) { 
            e.setId(rs.getInt(1));
            //e.setDate(rs.getString(2));
            e.setDate_evemt(rs.getDate(2));
            e.setDescription(rs.getString(3));
            e.setFinish_hour(rs.getString(4));
            e.setStart_hour(rs.getString(5));
            e.setLocation(rs.getString(6));
             e.setCapacity(rs.getString(7));
              e.setImage(rs.getString(8));
               e.setName(rs.getString(9));
//               e.setArtiste(as.fetchArtisteById(rs.getInt(10)));
               e.setPrix(rs.getDouble(11));
               e.setUsername(rs.getString(12));
           }

           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
        return e;
    
        
    
    }

    @Override
    public void suppEvenement(int id) {
        
        String req = "DELETE FROM `evemt` where id = "+id;
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement supprimer avec Success!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
}   
      

    

    

    
    

