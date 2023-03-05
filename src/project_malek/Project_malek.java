/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_malek;

import interfaces.ArticleInterface;
import interfaces.ArtisteInterface;
import interfaces.CategorieInterface;
import interfaces.ClientInterface;
import interfaces.RateInterface;
import interfaces.StockInterface;
import models.Article;
import models.Artiste;
import models.Categorie;
import models.Client;
import models.Rate;
import models.stock;
import services.ArticleService;
import services.ArtisteService;
import services.CategorieService;
import services.ClientService;
import services.RateService;
import services.StockService;


/**
 *
 * @author MediaStudio
 */
public class Project_malek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArticleInterface ai = new ArticleService();
        Article a= new Article();
        CategorieInterface pi = new CategorieService();
        Categorie c = new Categorie(); 
                ArtisteInterface al = new ArtisteService();
           
        Artiste ar = new Artiste();
        StockInterface ins = new StockService();
        stock st = new stock();
        RateInterface re = new RateService();
        Rate b=new Rate();
        
        
 a.setId_article(35);
        ar.setId_artiste(9);
        a.setNom_article("rym");
        a.setDescription("project");
        a.setImage("C:/Users/MediaStudio/Desktop/icon.png");
        a.setQuantity(2);
        a.setType("pi");
        a.setPrice(29.1);
     c.setId_categorie(8);
     a.setCategorie(c);
     a.setArtiste(ar);
//    ai.ModifyArticle(a);
////        c.setDescription("nada");
////        c.setName_categorie("kanzari");
//        
//      ai.addArticle(a);
////     a.setCategorie(c);
////        a.setId_article(2);
//ai.deleteArticle(37);
//       
// ai.ModifyArticle(a);
//   
//System.out.println(ai.fetchArticleByPrice(19.0, 152.00));
//System.err.println(ai.fetchArticleById(21));
//System.out.println(ai.fetchArticleTriByPrice());
//System.err.println(ai.fetchArticleTriByName());
//System.out.println(ai.fetchArticleTriByCategorie());
//System.out.println(ai.fetchArticleByCaracter("b"));
////// TODO code application logic here
//      
//        c.setDescription("rym");
//        c.setName_categorie("saidi");
//     st.setId_stock(1);
//      c.setStock(st);
////     
////ai.addArticle(a);
//  
////        pi.deleteCategorie(9);
//
// pi.addCategorie(c);
////pi.ModifyCategorie(c);
////
////System.out.println(pi.fetchCategorieById(2));
////System.out.println(pi.fetchCategorie());
////System.out.println(pi.fetchCategorieBycaracter("malek"));
////////pi.ModifyCategorie(c);
//////////ai.ModifyArticle(a);
////////System.out.println(ai.fetchArticleByCaracter("rym"));
////// //System.out.println(ai.fetchArticleById_categorie(1));
////System.out.println(pi.fetchArticleTriByName());
////System.out.println(pi.fetchArticleTriBystock());

//  System.out.println(al.fetchArtisteByName("hello"));
//        System.out.println(cli.fetchClientByName("rim"));
//System.out.println(cli.fetchClient());

//st.setArtiste("ryam");
//st.setName("artist");
//st.setId_commende(1);
//        System.out.println(ins.fetchStockByName("picaso"));
//System.out.println(ins.fetchStock());

//System.out.println(re.afficherRating(b));

    }
    
}     