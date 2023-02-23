package com.example.newartflow;

import models.livraison;
import models.stock;
import services.livraisonService;
import services.stockService;

public class main {
    public static void main(String[] args) {
        System.out.println("hello");
        stock l =new stock();
        stockService ls = new stockService();
        l.setName("ahahah");
        l.setUser_name("babababa");
        l.setId_commende(1);
        l.setId(1);
        l.setArtiste("adasd");
        l.setAddres("77");
        ls.updateAllstock(l);
        System.out.println(ls.fetchstock());
    }
}
