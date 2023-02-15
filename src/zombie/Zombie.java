/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombie;

import Interface.EvenementInterface;
import Interface.ReservationInterface;
import Models.Artiste;
import Models.Client;
import Models.Evenement;
import Models.Reservation;
import Service.EvenementService;
import Service.ReservationService;
import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Zombie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        
        EvenementInterface ps = new EvenementService();
        
//        Artiste a = new Artiste();
//        //Artiste init
//        a.setId_artiste(1);
//        a.setFirstname("Abakar issa ali haggar");
//        a.setLastname("Ali Haggar");
//        a.setBirthplace("Tunis");
//        a.setBirthdate("Esprit");
//        a.setDescription("Tchadien");
//        a.setImage("eeee");
//        a.setAddress("Ariana");
//        a.setPhonenumber("885852");
//        a.setUsername("Ronaldo");
//        a.setPassword("0258963147");
//        a.setEmail("ayoub.barnat@esprit.tn");
//        
//        
//        
//         //Evenement init
       //Evenement e = new Evenement();
   //   e.setArtiste(a);
     //   e.setId(16);
//       e.setName("ZARA MAHAMAT HAGGAR");
//        e.setCapacity("51");
//        e.setDescription("ndjamena");
//        e.setDate("diguel");
//       e.setFinish_hour("Enseignante");
//        e.setStart_hour("888");
//       e.setImage("C:/Users/Lenovo/Desktop/esprit.png");
//        e.setLocation("aiisiis");
        
        
//        
//        
////        
////        //add action
 // ps.addEvenement(e);
   //System.out.println(ps.fetchEvenements());
 //ps.modEvenement(e);
  //ps.suppEvenement(16);
    
        //System.out.println(ps.sortBy("capacity","DESC")); 
        //System.out.println(ps.readById(17));
   
   ReservationInterface rs = new ReservationService();
   
//   Client c = new Client();
////        //Artiste init
//       c.setId_client(1);
//       c.setFirstname("Ayoub");
//        c.setLastname("Barnat");
//        //c.setbirthdate(000);
//       c.setBirthdate(new Date(2023, 02, 01));
//        c.setAddress("Ariana");
//        c.setPhonenumber("885852");
//        c.setUsername("Ronaldo");
//        c.setPassword("0258963147");
//        c.setEmail("ayoub.barnat@esprit.tn");
   
   
   Reservation r = new Reservation();
//  r.setId(6);
//   r.setNb_place(145);
//   r.setPrice(117500);
//   r.setClient(c);
//    //rs.addReservation(r);
   System.out.println(rs.fetchReservations());
//    r.setPrice(2023);
    
  // rs.modReservation(r);
 // rs.suppReservation(7);
 
 //System.out.println(ps.sortBy("price","DESC")); 
 //System.out.println(ps.readById(6));
       
    }
    
}
