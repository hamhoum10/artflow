package com.example.testjavafx;

import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        //FAMA PROB FI ID AUTO INCREM KIFEH NAMLOU RECUPERATION MTE3O ALKHTR WA9TLI ON PASSE EL INSTANCE MTA CLASS FI PARAMETREN GETID TE3O MAHESH EL AUTO GENERTATED


        Client c1 =new Client("leo","miaoui","04-12-2000","arian","9874563","med@gmail.com","medboss","0321545defz");
        ClientService cs=new ClientService();
        Categorie c=new Categorie();
        Artiste med =new Artiste("Mohamed","Miaoui","ariana","04/12/2000","yasuo main","fdf","borjba","9684565","med","yasuo","med@gmail.com");
        ArtisteService as =new ArtisteService();
        //as.saveArtiste(med);
        Article ps4 =new Article(50,10,950.0,"VideoGame","idk","console game","Playstation 4",c,med,50);
        Article pc =new Article(2,10,2450.0,"VideoGame","idk","console game","Playstation 4",c,med,50);
        Article yasser =new Article(5,10,2450.0,"yossri","idk","mechant","yossri_mechant",c,med,50);
        ArticleService a =new ArticleService();
        a.addArticle(yasser);

        Client cboss=new Client("lotfi","la3meri","01/1/1922","ariana","9683025","lotfi@gmail.com","lotf","04451");
        ClientService cl=new ClientService();
        //cl.saveClient(cboss);
        //a.addArticle(pc);
        //cs.saveClient(c1);
        Panier panier=new Panier(2);
        PanierService psss=new PanierService();
        Panier pmed=new Panier(3);
        //psss.createPanier(pmed);
        //psss.createPanier(panier);
       // Ligne_panier lp=new Ligne_panier(ps4,1,200.0,5);
        Ligne_panier ligne_panierps4=new Ligne_panier(ps4,3,5);
        Ligne_panier ligne_panierpc=new Ligne_panier(pc, 4, 2);
        Ligne_panier lyessr= new Ligne_panier(yasser,4,4);
        Ligne_PanierService lps =new Ligne_PanierService();
        //lps.AjouterDansTableligne_Panier(lyessr,28);
        //lps.deleteFromLigne_panierByArticle(3,14);
        lps.deleteAllFromLigne_panier(4);


        //lps.AjouterDansTableligne_Panier(lp2);
        Commande commande1 =new Commande(psss.getPanierIdForUser(1), "en attente",5000,"17/02/2023",2080,"ariana");
        Commande c2 =new Commande(4,"done",411,"58/8455/260",2500,"sdzefz");
        CommandeService commandeService =new CommandeService();
        //commandeService.create(c2);
        //System.out.println(commandeService.readCommandesbyPanier(4));


        //System.out.println(psss.readelementPanierbyiduser(2));
        //lps.deleteAllFromLigne_panier(1);



    }
}