package com.example.newartflow;

import models.Dashbord;
import models.livraison;
import models.stock;
import services.DashbordService;
import services.livraisonService;
import services.stockService;

import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("hello");
        stock l =new stock();
        DashbordService d = new DashbordService();
        livraisonService ll = new livraisonService();
        stockService ls = new stockService();
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
        List<Dashbord> dd=d.fetchDashbord();
        for (int i = 0;i< dd.size();i++){

            System.out.println(dd.get(i).getMonth());
        }


    }
}
