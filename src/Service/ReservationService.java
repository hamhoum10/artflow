/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.ReservationInterface;
import Models.Client;
import Models.Reservation;
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
public class ReservationService implements ReservationInterface {
    Connection cnx = Myconnection.getInstance().getCnx();

    @Override
    public void addReservation(Reservation r) {
     
//     try {
//            String req = "INSERT INTO `reservation`(`nb_place`, `price`, `id_client`) VALUES ('"+ r.getNb_place()+"',"+r.getPrice()+", "+r.getClient()+")";
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Reservation a ete avec success!");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
try {
            
            String req = "INSERT INTO `reservation`(`nb_place`, `price`, `id_client`, `name`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getNb_place());
            ps.setDouble(2, r.getPrice());
            ps.setInt(3, r.getClient().getId_client());
            ps.setString(4,r.getName() );
            ps.executeUpdate();
            System.out.println("reservation a ete ajoutée avec Success!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Reservation> fetchReservations() {
         List<Reservation> Reservations = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM reservation as r join client as a where r.id_client=a.id_client";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Reservation r = new Reservation();
                Client c = new Client();
                
                //r.setId(rs.getInt(1));
                 r.setId(rs.getInt("id"));
                
              // Client c =new Client();
                c.setId_client(rs.getInt("Id_client"));
                
              //  c.setFirstname(rs.getString("c.firstname"));
                r.setClient(c);
//                r.setNb_place(rs.getInt(2));
//                r.setPrice(rs.getDouble(3));
                 r.setNb_place(rs.getInt("nb_place"));
                r.setPrice(rs.getDouble("price"));
                r.setName(rs.getString("name"));
                
                
                
               
                
               Reservations.add(r);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Reservations;
    }

    @Override
    public void modReservation(Reservation r) {


 try {    
            String req = "update `reservation` set `nb_place`=?, `price`=?, `id_client`, `name`=? where `id`=? ";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setInt(1, r.getNb_place());
            ps.setDouble(2, r.getPrice());
           // ps.setInt(3, r.getClient().getId_client());
            
           
            ps.setInt(3, r.getClient().getId_client());
             ps.setString(4, r.getName());
            ps.setInt(5, r.getId());

         
           
            ps.executeUpdate();
            System.out.println("Reservation a ete modifiée avec Success!");
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void suppReservation(int id) {
        String req = "DELETE FROM `reservation` where id = "+id;
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation a ete  supprimée avec Success!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList sortBy(String nom_column, String Asc_Dsc) {
         ArrayList<Reservation> reservations = new ArrayList<>();
         Client c = new Client();
         
        try {
            
            String req = "SELECT * FROM reservation ORDER BY "+nom_column + " "+Asc_Dsc+" ";
            Statement st = cnx.createStatement();
            
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Reservation r  = new Reservation();
                 r.setId(rs.getInt(1));
                 r.setNb_place(rs.getInt(2));
                 r.setPrice(rs.getDouble(3));
                // r.setId_client(c.getId_client());
                 
                 
                 
                 
                 
                 
                 
                reservations.add(r);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return reservations;
    }

    @Override
    public Reservation readById(int id) {
         Reservation r = new Reservation();
        
 
             try {
            
            String req = "SELECT * FROM reservation WHERE id= "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
            r.setId(rs.getInt(1));
           r.setNb_place(rs.getInt(2));
             r.setPrice(rs.getDouble(3));
            
            
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       
        
        return r;
    
    }
    
    
}
