/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author MediaStudio
 */
public class Rate {
    Double rating;
    Artiste rater;
    Article Article;

    public Rate() {
    }

    public Rate(Double rating, Artiste rater, Article Article) {
        this.rating = rating;
        this.rater = rater;
        this.Article = Article;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Artiste getRater() {
        return rater;
    }

    public void setRater(Artiste rater) {
        this.rater = rater;
    }

    public Article getArticle() {
        return Article;
    }

    public void setArticle(Article Article) {
        this.Article = Article;
    }

    @Override
    public String toString() {
        return "Rate{" + "rating=" + rating + ", rater=" + rater + ", Article=" + Article + '}';
    }

    
    
    
    
}
