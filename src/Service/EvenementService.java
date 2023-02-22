/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.EvenementInterface;
import Models.Artiste;
import Models.Evenement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Myconnection;

/**
 *
 * @author Lenovo
 */
public class EvenementService  implements EvenementInterface{
    Connection cnx = Myconnection.getInstance().getCnx();

    @Override
    public void addEvenement(Evenement e) {
      
        try {
            
            String req = "INSERT INTO `evemt`(`date`, `description`,`finish_hour`,`start_hour`, `location`,`capacity`,`image`,`name`, `id_artiste`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
//            FileInputStream videoFile = new FileInputStream(e.getImage());
//            byte[] image = new byte[videoFile.available()];
//            videoFile.read(image);
            
            ps.setString(1, e.getDate());
   
            ps.setString(2, e.getDescription());
            ps.setString(3, e.getFinish_hour());
            ps.setString(4, e.getStart_hour());
             ps.setString(5, e.getLocation());
            ps.setString(6, e.getCapacity());
           ps.setString(7,e.getImage());
           
           
            
            ps.setString(8, e.getName());
            ps.setInt(9, e.getArtiste().getId_artiste());
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
        try {
            
            String req = "SELECT * FROM evemt";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Evenement p = new Evenement();
                
                p.setId(rs.getInt(1));
                p.setDate(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setFinish_hour(rs.getString(4));
                p.setStart_hour(rs.getString(5));
                p.setLocation(rs.getString(6));
                p.setCapacity(rs.getString(7));
                p.setImage(rs.getString(8));
                p.setName(rs.getString(9));
                
               
                
               Evenements.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Evenements;
    }

    @Override
    public void modEvenement(Evenement e) {
        
        try {    
            String req = "update `Evemt` set `date`=?, `description`=?, `finish_hour`=?, `start_hour`=?, `location`=?, `capacity`=?, `image`=?, `name`=?, `id_artiste`=? where `id` =? ";
            PreparedStatement ps = cnx.prepareStatement(req);
           
           ps.setString(1, e.getDate());
           ps.setString(2, e.getDescription());
           ps.setString(3, e.getFinish_hour());
           ps.setString(4, e.getStart_hour());
           ps.setString(5, e.getLocation());
           ps.setString(6, e.getCapacity());
           ps.setString(7, e.getImage());
           ps.setString(8, e.getName());
           
           ps.setInt(9, e.getArtiste().getId_artiste());
           ps.setInt(10, e.getId());

         
           
            ps.executeUpdate();
            System.out.println("Evenement a ete Modifie avec  Success!");
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
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
                 e.setDate(rs.getString(2));
                 e.setDescription(rs.getString(3));
                 e.setFinish_hour(rs.getString(4));
                 e.setStart_hour(rs.getString(5));
                 e.setLocation(rs.getString(6));
                 e.setCapacity(rs.getString(7));
                 e.setImage(rs.getString(8));
                 e.setName(rs.getString(9));
                 
                 
                 
                 
                 
                 
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
        
 
             try {
            
            String req = "SELECT * FROM evemt WHERE id= "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
            e.setId(rs.getInt(1));
            e.setDate(rs.getString(2));
            e.setDescription(rs.getString(3));
            e.setFinish_hour(rs.getString(4));
            e.setStart_hour(rs.getString(5));
            e.setLocation(rs.getString(6));
             e.setCapacity(rs.getString(7));
              e.setImage(rs.getString(8));
               e.setName(rs.getString(9));

           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
        return e;
    
        
    
    }
    
    
}   
      

    

    

    
    

