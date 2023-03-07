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
import Models.User;
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

        Service.EvenementService ss = new Service.EvenementService();
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

//        e.setId(57);
//        e.setName("Baradine chardine");
//        e.setCapacity("41");
//        e.setDescription("Ariana");
//        //e.setDate_evemt(LocalDate.of(2000, 1, 1));
//        e.setDate_evemt(d);
//        e.setFinish_hour("Enseignante");
//        e.setStart_hour("888");
//        e.setImage("C:/Users/Lenovo/Desktop/esprit.png");
//        e.setLocation("Diguel");
//        e.setArtiste(a);
//        a.setId_artiste(1);
//
//        e.setPrix(1.55);

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
//        c.setId_client(1);
//        c.setFirstname("Ayoub");
//        c.setLastname("Barnat");
//        //c.setbirthdate(000);
//        //c.setBirthdate(new Date(2023, 02, 01));
//        c.setAddress("Ariana");
//        c.setPhonenumber("885852");
//        c.setUsername("Ronaldo");
//        c.setPassword("0258963147");
//        c.setEmail("ayoub.barnat@esprit.tn");

        ReservationService mr = new ReservationService();
        Reservation r = new Reservation();
        

        

//   
//   
        r.setId(22);
        r.setNb_place(120);

       // r.setPrice(1);
        // r.setClient(g);
      //  g.setId_client(1);
        //  r.setName("issa");
        e.setId(60);
        e.setPrix(10.0);
        r.setEvent(e);
        r.setDateres(new Date(2023, 02, 01));
        
         

         System.out.println(mr.totalMontalReservation(48)); 
         
        // r.setId_client(1);
        // rs.addReservation(r);
        //System.out.println(mk.fetchClientByName("Malek"));
        //System.out.println(rs.fetchReservations());
//    //r.setPrice(2023);
//    
       // rs.modReservation(r);
                  //  rs.suppReservation(39);
// 
// System.out.println(ps.sortBy("price","DESC")); 
// System.out.println(ps.readById(6));

//        

//        User u = new User();
//        //  Category c = new Category();
//          Evenement p = new Evenement();
//          Commentaire co = new Commentaire();
//
//                        Commentaire comment = new Commentaire();
//                   comment.setId_user(1);
//
//                   comment.setCommentaire("c'est une bonne initiative");
//                   Evenement evemt = new Evenement();
//                   evemt.setId(10);
//                  comment.setId(evemt);
//
//                //   Call the addComment() method
//                 CommentaireInterface comm = new CommentaireService();
//                   comm.addComment(comment);
//
//                  // comm.supprimer(2);
//
//                  co.setCommentaire("This is the edit edit comment");
        // co.setId_comment(1);
        //   comm.modifier(co);
//        
//       
    }

}
