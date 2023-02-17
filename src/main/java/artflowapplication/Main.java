package artflowapplication;

import interfaces.livraisonInterface;
import interfaces.stockInterface;
import models.livraison;
import models.stock;
import services.livraisonService;
import services.stockService;
import util.MyConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("");
        System.out.println("hell");
      //  MyConnection cnx = new MyConnection();
        //stock init
        //stockInterface st = new stockService() ;
        livraisonInterface st = new livraisonService() ;
        livraison s = new livraison();
//        s.setId(2);
        s.setArtiste("testtes");
        s.setId_commende(5);
        s.setName("yasser");
        s.setAddres("mourouj");
        s.setUser_name("ahmed");
        st.addlivraison(s);

        System.out.println(st.fetchlivraison());
        s.setId(1);
        st.updateAlllivraison(s);
        System.out.println(st.fetchlivraison());
        st.deleatlivraisonById(1);
        System.out.println(st.fetchlivraison());
       stockInterface sf = new stockService() ;
        stock sa = new stock();
//        s.setId(2);
        sa.setArtiste("testtes");
        sa.setId_commende(5);
        sa.setName("yasser");
        sa.setAddres("mourouj");
        sa.setUser_name("ahmed");
        sf.addstock(sa);

        System.out.println(st.fetchlivraison());
        s.setId(1);
        sf.updateAllstock(sa);
        System.err.println(sf.fetchstock());
        sf.deleatstockById(1);
        System.out.println(sf.fetchstock());



       /* stock s2 = new stock();
        s2.setArtiste("ahmid");
        s2.setId_commende(5);
        s2.setName("mona");*/
      //  System.out.println(st.filtreParCommende(5));


       // st.addstock(s);
        //st.addstock(s2);
       // System.out.println(st.SelectById(6));

       // System.out.println(st.fetchstock());
        //st.deleatstockById(5);
       //System.out.println( st.SelectById(16));
        //System.out.println(st.fetchstock());
    }
}