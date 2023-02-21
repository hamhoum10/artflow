/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enchere;

import java.sql.Date;
import java.time.LocalDate;
import models.Client;
import models.Enchere;
import models.Participant;
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
    public static void main(String[] args) {
        // TODO code application logic here
        MyConnection c = MyConnection.getInstance();
        Enchere en = new Enchere();
        Client cl = new Client();
        Participant p = new Participant();
        EnchereService es = new EnchereService();
        LocalDate locald = LocalDate.of(2023, 02 - 1, 12);
        Date d = new Date(2023, 02, 23);
        d = d.valueOf(locald);
        
        
//AJOUT AUCTION   
//    en.setTitre("symfony");
//    en.setDescription("today");
//    en.setPrixdepart(5673);
//    en.setDate_limite(d);
//    es.AddEnchere(en);

// UPDATE AUCTION     
//    en.setTitre("ryyym");
//    en.setDescription("haven");
//    en.setPrixdepart(2341);
//    en.setDate_limite("23-06-2023");
//    en.setIde(4);
//    es.updateEnchere(en);

// DELETE ENCHERE
//en.setIde(2);
//es.deleteEnchere(en);

//affichage enchere
 //System.out.println(es.fetchEnchere());


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
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }

}
