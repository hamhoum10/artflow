/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enchere;

import com.itextpdf.text.DocumentException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import models.Client;
import models.Enchere;
import models.Participant;

import services.ClientService;
import services.EnchereService;
import utils.MyConnection;
import com.itextpdf.text.pdf.PdfReader;
import java.io.FileNotFoundException;
//import org.junit.Test;
//
//import java.io.IOException;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
/**
 *
 * @author Elizabeth
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException, DocumentException {
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
//    en.setTitre("lila kalba");
//    en.setDescription("avec souhabi");
//    en.setPrixdepart(6666);
//    en.setDate_limite(d);
//    en.setImg("img.png");
//    es.AddEnchere(en);



// UPDATE AUCTION     
//    en.setTitre("TRY CATCH");
//    en.setDescription("IF U CAN");
//    en.setPrixdepart(2341);
//    en.setDate_limite(d);
//    en.setIde(23);
//    en.setImg("img.png");
//    es.updateEnchere(en);

// DELETE ENCHERE
//en.setIde(20);
//es.deleteEnchere(20);

//affichage enchere
// System.out.println(es.fetchEnchere());
//   System.out.println(es.fetchEnchereByname("NADA"));
//     System.out.println(cs.fetchClient());
// System.out.println(cs.fetchClientByName("mzou"));


//ADD A CLIENT 
//cl.setFirstname("rym");
//cl.setLastname("saidi");
//cl.setAddress("2050 EZZAHRA");
//cl.setPhone(92678543);
//cl.setEmail("rym@a.com");
//cl.setUsername("reem");
//cl.setPwd("reiei");
//cs.addClient(cl);

// ADD PARTICIPANT TO THE AUCTION     
//cl.setId(20);
//en.setIde(24);
//p.setClient(cl);
//p.setEnchere(en);
//p.setMontant(1100); 
//es.addParticipant(p);


//UPDATE PARTICIPATION
//cl.setId(1);
//en.setIde(1);
//
//p.setClient(cl);
//p.setEnchere(en);
//p.setMontant(666);
//es.updateParticipant(p);


// DELETE PARTICIPANT 
//cl.setId(1);
//en.setIde(1);
//
//p.setClient(cl);
//p.setEnchere(en);
//es.deleteParticipant(p);



// verification -----> bid must be superiro to the old soum
//cl.setId(2);
//en.setIde(1);
//p.setClient(cl);
//p.setEnchere(en);
//p.setMontant(600);
//es.effectuerParticipation(p);



//affichage le montant le plus grand d'une enchere 
//en.setIde(20);
//p.setEnchere(en);
//System.out.println( es.getHighestBidAmount(p));    
    


/*

 Enchere enchere = new Enchere(22,"kahelani", "shutty", 2341, date, "image");
 //  es.AddEnchere(enchere);
Client client = new Client();
//cs.addClient(client);

Participant participant = new Participant(client, enchere, 1000.0);
// es.addParticipant(participant);

//---------------------------------------------------------------------to get who's the winner after thr time is iup'
Participant winningBidder = es.getWinningBidder(enchere);
if (winningBidder != null) {
    System.out.println("The winning bidder is: " + winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom() + " with a bid of " + winningBidder.getMontant());
}
else {
    System.out.println("No winning bidder found!");
}
    
*/
     



 
/*
Enchere enchere = new Enchere(22,"kahelani", "shutty", 2341, date, "image");
String winningBidder = es.generatePdfFromQueryResult(enchere);
    try {
        winningBidder = es.generatePdfFromQueryResult(enchere);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    System.out.println("Winning bidder: " + winningBidder);
}


*/





/*
 String filename = "my-pdf-file";
    int Id = 1;
     // create a Participant object
    // set properties of the Participant object
    Enchere enchere = new Enchere(22,"kahelani", "shutty", 2341, date, "image");
    p.setClient(new Client("John", "Doe"));

    Pdf pdf = new Pdf(); // create an instance of the Pdf class
    try {
        pdf.GeneratePdf(filename, p, 1); // call the GeneratePdf method
    } catch (Exception e) {
        e.printStackTrace();
    }
}
*/




    

//p.GeneratePdf();
    
    
    
   
    
    
    
    
    }
}












    
    

    
   

    
  


