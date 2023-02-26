/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enchere;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import models.Client;
import models.Enchere;
import models.Participant;
import services.ClientService;
import services.EnchereService;
import utils.MyConnection;

/**
 *
 * @author Elizabeth
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        MyConnection c = MyConnection.getInstance();
        Enchere en = new Enchere();
        ClientService cs = new ClientService ();
        Client cl = new Client();
        Participant p = new Participant();
        EnchereService es = new EnchereService();
       // LocalDate locald = LocalDate.of(2023, 02 - 1, 12);
        Date d = new Date(2023, 01, 12);
       // d = d.valueOf(locald);
        
        LocalDate locald = LocalDate.of(2024, 02 - 1, 12);
        
   //   LocalDate today = LocalDate.now(); // get the current date
      Date date = java.sql.Date.valueOf(locald); // convert LocalDate to Date

        
//AJOUT AUCTION   
//    en.setTitre("symfony");
//    en.setDescription("today");
//    en.setPrixdepart(5673);
//    en.setDate_limite(d);
//    en.setImg("img/gh.hy");
//    es.AddEnchere(en);

// UPDATE AUCTION     
//    en.setTitre("TRY CATCH");
//    en.setDescription("IF U CAN");
//    en.setPrixdepart(2341);
//    en.setDate_limite(d);
//    en.setIde(3);
//    en.setImg("img.png");
//    es.updateEnchere(en);

// DELETE ENCHERE
//en.setIde(2);
//es.deleteEnchere(en);

//affichage enchere
// System.out.println(es.fetchEnchere());
//   System.out.println(es.fetchEnchereByname("NADA"));
//     System.out.println(cs.fetchClient());
// System.out.println(cs.fetchClientByName("mzou"));

// ADD PARTICIPANT TO THE AUCTION     
//cl.setIdc(1);
//en.setIde(1);
//p.setClient(cl);
//p.setEnchere(en);
//p.setMontant(100);
//es.addParticipant(p);


//UPDATE PARTICIPATION
//cl.setIdc(1);
//en.setIde(1);
//
//p.setClient(cl);
//p.setEnchere(en);
//p.setMontant(666);
//es.updateParticipant(p);


// DELETE PARTICIPANT 
//cl.setIdc(1);
//en.setIde(1);
//
//p.setClient(cl);
//p.setEnchere(en);
//es.deleteParticipant(p);



// verification -----> bid must be superiro to the old soum
//cl.setIdc(2);
//en.setIde(1);
//p.setClient(cl);
//p.setEnchere(en);
//p.setMontant(600);
//es.effectuerParticipation(p);



//affichage le montant le plus grand d'une enchere 
//en.setIde(20);
//p.setEnchere(en);
//System.out.println( es.getHighestBidAmount(p));    
    




 Enchere enchere = new Enchere(22,"kahelani", "shutty", 2341, date, "image");
 //  es.AddEnchere(enchere);
Client client = new Client();
//cs.addClient(client);

Participant participant = new Participant(client, enchere, 1000.0);
// es.addParticipant(participant);


Participant winningBidder = es.getWinningBidder(enchere);
if (winningBidder != null) {
    System.out.println("The winning bidder is: " + winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom() + " with a bid of " + winningBidder.getMontant());
}
//else {
//    System.out.println("No winning bidder found!");
//}
    

     

    
    }

    
   }
   
 
    
  


