/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Article;

/**
 *
 * @author MediaStudio
 */
public interface ArticleInterface {
    
    //ajout
    public void addArticle(Article t);
    
    //modification
    public void ModifyArticle(Article t);
    
    //suppression
    public void deleteArticle(int id);
    
    
    //list : select
    public List<Article> fetchArticle();
    
    //affectation
    //public void affecterJoueur(Player p, Team t);
        public List<Article> fetchArticleByPrice(Double min , Double max);
            public List<Article> fetchArticleById(int id);

            public List<Article> fetchArticleByCaracter(String c);
                        public List<Article> fetchArticleById_categorie(int id_categorie);
                        public List<Article> fetchArticleTriByPrice();
                        public List<Article> fetchArticleTriByName();
                        public List<Article> fetchArticleTriByCategorie();


            


}


