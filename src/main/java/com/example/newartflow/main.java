package com.example.newartflow;

import models.Dashbord;
import models.livraison;
import models.stock;
import services.CommandeService;
import services.DashbordService;
import services.livraisonService;
//import services.stockService;

import java.sql.SQLException;
import java.util.List;


public class main {
    public static void main(String[] args) throws SQLException {
        System.out.println("hello");
        stock l = new stock();
        CommandeService c = new CommandeService();
        DashbordService d = new DashbordService();
        livraisonService ll = new livraisonService();
//        stockService ls = new stockService();
        l.setName("ahahah");
        l.setUser_name("babababa");
        l.setId_commende(1);
//        l.setId(12);
        l.setArtiste("ddd");
        l.setAddres("abc");
//        ls.updateAllstock(l);
//        System.out.println(ls.fetchstock());
//        System.out.println(ll.fetchlivraison());
//        ls.moveToLivraison(l);
//        System.out.println(ls.fetchstock());
//        System.out.println(ll.fetchlivraison());
//        System.out.println(ll.SelectByUserliv("o"));
//ll.SmsNotification();
//        System.out.println(c.getNumById("dsfdsf"));
        ll.SmsNotification("yasser");
    }


}
