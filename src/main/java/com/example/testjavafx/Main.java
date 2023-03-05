package com.example.testjavafx;

import com.stripe.exception.StripeException;
import models.*;
import services.*;
import util.Stripeapi;


public class Main {
    public static void main(String[] args) throws StripeException {
        //FAMA PROB FI ID AUTO INCREM KIFEH NAMLOU RECUPERATION MTE3O ALKHTR WA9TLI ON PASSE EL INSTANCE MTA CLASS FI PARAMETREN GETID TE3O MAHESH EL AUTO GENERTATED
        Client lotfi=new Client("lotfi","la3meri","01/1/1922","ariana","9683025","lotfi@gmail.com","lotf","04451");
        Client amine =new Client("amine","teemo","04-12-2878","arian","9874563","med@gmail.com","gazouza","0321545defz");
        ClientService cs=new ClientService();
        //cs.saveClient(amine);
        //System.out.println(amine.getUsername());
        Categorie c=new Categorie();
        Artiste med =new Artiste("Mohamed","Miaoui","ariana","04/12/2000","yasuo main","fdf","borjba","9684565","med","yasuo","med@gmail.com");
        ArtisteService as =new ArtisteService();
        //as.saveArtiste(med);
        Article ps4 =new Article(50,10,12.0,"VideoGame","idk","Playstaion 4 is a Gaming console that allow the user to have an amazing adventure in a virtuelle world were joy and happiness have no limits","Playstation 4",c,med,50);
        Article gun =new Article(9,5,5.0,"weapon","vovodvds","a dangerous tool that allow u to protect you're self from intruders and kill them if needed ;)","AK47",c,med,14);
        Article headphone =new Article(30,10,47.0,"electronics","idk","audio device that allow you to listen to a vast variety of shitty music and end up with ligma ","Airpods",c,med,50);

        ArticleService a =new ArticleService();
        //a.addArticle(ps4);
        //a.addArticle(gun);
        //a.addArticle(headphone);

        //cl.saveClient(cboss);
        //a.addArticle(pc);
        //cs.saveClient(c1);
        Panier panierAmine=new Panier(amine); //baed ki nada trigel fazet getid user nwali just naddi client
        Panier p4 =new Panier(lotfi);
        PanierService psss=new PanierService();
        psss.createPanier(panierAmine);
        //psss.createPanier(panierAmine);
        //System.out.println(panierOmar.getId_panier());
        //psss.createPanier(pmed);
        //psss.createPanier(panier);

        Ligne_panier ligne_panierps4=new Ligne_panier(ps4,p4,5);//njmo nrodo quanity just 1 w fi panier tzid
        Ligne_panier ligne_paniergun =new Ligne_panier(gun,p4,2);
        Ligne_panier ligne_panierheadphone =new Ligne_panier(headphone,p4,1);

        Ligne_PanierService lps =new Ligne_PanierService();
        //System.out.println(lps.readelementPanierbyiduser(3));
        lps.AjouterDansTableligne_Panier(ligne_paniergun);
        lps.AjouterDansTableligne_Panier(ligne_panierheadphone);
        lps.AjouterDansTableligne_Panier(ligne_panierps4);
        //lps.deleteFromLigne_panierByArticle(3,14);
        //lps.deleteAllFromLigne_panier(4);
        // just mesh njareb el git
        //System.out.println(psss.readelementPanierbyiduser(2));

        Stripeapi stp =new Stripeapi();
        PanierService ps =new PanierService();
        //stp.Payer();
        //stp.verifyCardAndPay("4242424242424242",11,23,"454","2222","Mohamed");
        //stp.verifyCard("bla@gmail.com","4242424242424242",12,2023,"585");
        //lps.AjouterDansTableligne_Panier(lp2);
        //Commande commande1 =new Commande(psss.getPanierIdForUser(1), "en attente",5000,"17/02/2023",2080,"ariana");
        Commande c2 =new Commande(4,"med","mi",98554158,"done",psss.totalmontantPanier(3),2500,"sdzefz");
        CommandeService commandeService =new CommandeService();
        //commandeService.create(c2);
        //System.out.println(commandeService.readCommandesbyPanier(4));


        //System.out.println(psss.readelementPanierbyiduser(2));
        //lps.deleteAllFromLigne_panier(1);


    }
}