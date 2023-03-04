/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombie;

import Interface.ArtisteInterface;
import Interface.ClientInterface;
import Interface.CommentaireInterface;
import Interface.EvenementInterface;
import Interface.ReservationInterface;
import Models.Artiste;
import Models.Client;
import Models.Commentaire;
import Models.Evenement;
import Models.Reservation;
import Service.ArtisteSerice;
import Service.ClientService;
import Service.CommentaireService;
import Service.EvenementService;
import Service.ReservationService;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.sql.Date;
import java.time.LocalDate;

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
        LocalDate locald = LocalDate.of(2023, 02 - 1, 12);
        Date d = new Date(2023, 02, 23);
        d = d.valueOf(locald);
        Service.ArtisteSerice ar = new Service.ArtisteSerice();
       // System.out.println(ar.fetchArtiste());
        
        Service.EvenementService ss= new Service.EvenementService();
       // System.out.println(ss.fetchEvenements().add(e));
        
        EvenementInterface ps = new EvenementService();
        ArtisteInterface km = new ArtisteSerice();
        ClientInterface cl = new ClientService();
        Client g = new Client();
        Artiste a = new Artiste();
        //Artiste init
        a.setId_artiste(1);
        a.setFirstname("Abakar issa ali haggar");
        a.setLastname("Ali Haggar");
        a.setBirthplace("Tunis");
        a.setBirthdate("Esprit");
        a.setDescription("Tchadien");
        a.setImage("eeee");
        a.setAddress("Ariana");
        a.setPhonenumber("885852");
        a.setUsername("Ronaldo");
        a.setPassword("0258963147");
        a.setEmail("ayoub.barnat@esprit.tn");
       //a.setEmail(email);
        
        
        
         //Evenement init
       Evenement e = new Evenement();
        //Date d = new Date(2023, 02, 2);
     // a.setId_artiste(1);
      
        e.setId(57);
       e.setName("Baradine chardine");
        e.setCapacity("41");
        e.setDescription("Ariana");
        //e.setDate_evemt(LocalDate.of(2000, 1, 1));
         e.setDate_evemt(d);
       e.setFinish_hour("Enseignante");
        e.setStart_hour("888");
       e.setImage("C:/Users/Lenovo/Desktop/esprit.png");
        e.setLocation("Diguel");
        e.setArtiste(a);
        a.setId_artiste(1);
        
         e.setPrix(1.55);
        
        
        
//        
//        //add action
    //ps.addEvenement(e);
     // System.out.println(ps.fetchEvenements());
       //System.out.println(km.fetchClientByName("Nada"));
   // ps.modEvenement(e);
 // ps.suppEvenement(35);
    
        //System.out.println(ps.sortBy("capacity","DESC")); 
        //System.out.println(ps.readById(17));
   
   ReservationInterface rs = new ReservationService();
   ClientInterface mk = new ClientService();
   
   Client c = new Client();
        //Artiste init
       c.setId_client(1);
       c.setFirstname("Ayoub");
        c.setLastname("Barnat");
        //c.setbirthdate(000);
       //c.setBirthdate(new Date(2023, 02, 01));
        c.setAddress("Ariana");
        c.setPhonenumber("885852");
        c.setUsername("Ronaldo");
        c.setPassword("0258963147");
        c.setEmail("ayoub.barnat@esprit.tn");
        
//   
//   
  Reservation r = new Reservation();
                r.setId(22);
                r.setNb_place(2);
                
                 r.setPrice(1);
                 r.setClient(g);
                 g.setId_client(1);
                 r.setName("issa");
                 
             // r.setId_client(1);
        //rs.addReservation(r);
        //System.out.println(mk.fetchClientByName("Malek"));
       System.out.println(rs.fetchReservations());
//    //r.setPrice(2023);
//    
//         rs.modReservation(r);
// rs.suppReservation(7);
// 
// System.out.println(ps.sortBy("price","DESC")); 
// System.out.println(ps.readById(6));
//        CommentaireInterface cs = new CommentaireService();
//        ClientInterface ci = new ClientService();
//        Commentaire c = new Commentaire();
//        //Evenement ee = new Evenement();
//        Client rr = new Client();
//        c.setId_evemt(55);
//        //c.setCommentaire("jj");
//        rr.setId_client(2);
//       // c.setId_commentaire(1);
//      c.setId(1);
//       
//        cs.ajouter(c);
//       
   }
    
}
