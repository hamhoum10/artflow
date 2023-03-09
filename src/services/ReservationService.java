/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import GUIissa.ListeReservationController;
import interfaces.ReservationInterface;
import models.Client;
import models.Evenement;
import models.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyConnection;


/**
 *
 * @author Lenovo
 */
public class ReservationService implements ReservationInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

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
            
            String req = "INSERT INTO `reservation`(`nb_place`, `dateres`, `id_event`, `id_client`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getNb_place());
          //  ps.setDouble(2, r.getPrice());
           ps.setDate(2, r.getDateres());
            ps.setInt(3, ListeReservationController.id_event); // tu va attribuer un valeur static (id_event) lors de la creation d'un evenement
            ps.setInt(4, r.getId_client());
            
            
            ps.executeUpdate();
            System.out.println("reservation a ete ajoutée avec Success!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Reservation> fetchReservations(int id) {
         List<Reservation> Reservations = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM reservation where id_res ="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Reservation r = new Reservation();
                Evenement e =new Evenement();
               
                
                
                //r.setId(rs.getInt(1));
                r.setId(rs.getInt("id_res"));
                
              // Client c =new Client();
                
              //  c.setFirstname(rs.getString("c.firstname"));
//                r.setNb_place(rs.getInt(2));
//                r.setPrice(rs.getDouble(3));
                 r.setNb_place(rs.getInt("nb_place"));
                //r.setPrice(rs.getDouble("price"));
                r.setDateres(rs.getDate("dateres"));
                r.setId_client(rs.getInt("id_client"));
              // r.getEvent().setId(rs.getInt("id_event"));
                
                
                
               
                
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
            String req = "update `reservation` set `nb_place`=?, `dateres`=?, `id_event`=? where `id_res`=? ";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setInt(1, r.getNb_place());
          //  ps.setDouble(2, r.getPrice());
            ps.setDate(2, r.getDateres());
            ps.setInt(3,r.getEvent().getId());
           // ps.setInt(3, r.getClient().getId_client());
            
           
           
            ps.setInt(4, r.getId());

         
           
            ps.executeUpdate();
            System.out.println("Reservation a ete modifiée avec Success!");
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void suppReservation(int id_res) {
        String req = "DELETE FROM `reservation` where id_res = "+id_res;
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
            
            String req = "SELECT * FROM `reservation` ORDER BY "+nom_column + " "+Asc_Dsc+" ";
            Statement st = cnx.createStatement();
            
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Reservation r  = new Reservation();
                 r.setId(rs.getInt(1));
                 r.setNb_place(rs.getInt(2));
              //   r.setPrice(rs.getDouble(3));
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
            
            String req = "SELECT * FROM `reservation` WHERE id= "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
            r.setId(rs.getInt(1));
           r.setNb_place(rs.getInt(2));
          //   r.setPrice(rs.getDouble(3));
            
            
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       
        
        return r;
    
    }
    
    
    
   
    
//    public double totalMontalReservation(Reservation r){
//        Reservation cc = new Reservation();
//        Double totalPrixReservation=0.0 ;
//        try {
//            String sql = "SELECT  SUM(E.prix * R.nb_place) AS total from `Reservation` as R , `evemt` As E where r.id_event  = "+r.getId()+"  and R.id_event = E.id";
//            
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                totalPrixReservation = rs.getDouble("total");//total est colonne virtuell, il n'existe pas dans la table panier
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return totalPrixReservation;

 public double totalMontalReservation(int id_client){
        Reservation cc = new Reservation();
        Double totalPrixReservation=0.0 ;
        try {
            //String sql = "SELECT  SUM(E.prix * R.nb_place) AS total from `Reservation` as R , `evemt` As E where r.id_event  = "+r+"  and R.id_event = E.id";
            String sql = "SELECT  SUM(E.prix * R.nb_place) AS total from `Reservation` as R JOIN `evemt` As E JOIN `client` as C on  R.id_event =E.id AND R.id_client =C.id  WHERE R.id_client= "+id_client ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                totalPrixReservation = rs.getDouble("total");//total est colonne virtuell, il n'existe pas dans la table panier
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrixReservation;    
    
        
    }
    public int getReservationId(Client client){
        int id=0;
        try {
            String sql = "SELECT id_res from `reservation` where id_client = " +client.getId();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
              id= rs.getInt("id_res");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    return id;
    }
}
