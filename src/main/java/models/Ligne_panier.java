package models;

import java.util.List;

public class Ligne_panier {


    // Variables pour la gestion du panier
    private int id;
    //private int id_article;
    private  Article article;
    private int id_panier;

    private Double prix_unitaire;
    private int quantity;

    private String nom_article;

    private String description;

    // Constructeur
    public Ligne_panier() {}

    public Ligne_panier(Article article, int id_panier , int quantity) {
        this.article = article;
        this.id_panier = id_panier;
        //this.prix = prix;
        this.quantity = quantity;
    }





// Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


/*public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }*/

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }*/

    /*@Override
    public String toString() {
        return "Ligne_panier{" +
                "id=" + id +
                ", article=" + article +
                ", id_panier=" + id_panier +
                ", prix_unitaire=" + prix_unitaire +
                ", quantity=" + quantity +
                ", nom_article='" + nom_article + '\'' +
                ", description='" + description + '\'' +
                '}';
    }*/

  /*  @Override
    public String toString() {
        return "Nom_article='" + nom_article + System.lineSeparator()+
                "Description='" + description + System.lineSeparator() +
                "Prix_unitaire=" + prix_unitaire  + System.lineSeparator() +
                "Quantity=" + quantity+ System.lineSeparator();
    }*/

    @Override
    public String toString() {
        return "Ligne_panier{" +
                "article_name=" + article.getNom_article() +System.lineSeparator()+
                "article_description=" + article.getDescription() +System.lineSeparator()+
                "article_price=" + article.getPrice() +System.lineSeparator()+
                "article_type=" + article.getType() +System.lineSeparator()+
                ", id_panier=" + id_panier +System.lineSeparator()+
                ", quantity=" + quantity +System.lineSeparator()+
                '}';
    }
}
