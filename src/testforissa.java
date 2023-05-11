
import java.sql.Date;
import java.time.LocalDate;
import javafx.event.Event;
import models.Artiste;
import models.Evenement;
import services.ArtisteService;
import services.ClientService;
import services.EvenementService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MediaStudio
 */
public class testforissa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        EvenementService e = new EvenementService();
        Artiste a = new Artiste();
         LocalDate locald = LocalDate.of(2023, 02 - 1, 12);
        Date d = new Date(2023, 02, 23);
        d = d.valueOf(locald);
//        Service.ArtisteSerice ar = new Service.ArtisteSerice();
//        // System.out.println(ar.fetchArtiste());
//
    EvenementService ss = new services.EvenementService();
    
        ArtisteService ar = new ArtisteService();
        
      ClientService cs=new ClientService();
        Artiste a1 = new Artiste();
        System.out.println(ar.fetchArtisteByName("issa"));
        a1=ar.fetchArtisteByName("issa");
    Evenement e1=new Evenement("Derby", "14h", "20h", "20", "gffff", "aziz.jpg", "ariana", a1, d, 12.0);
    e.addEvenement(e1);
    }
    
}
