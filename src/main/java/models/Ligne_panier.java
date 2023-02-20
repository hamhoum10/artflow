package models;

public class Ligne_panier {


    // Variables pour la gestion du panier
    private int id;
    //private int id_article;
    private  Article article;
    private int id_panier;

    //private Double prix;
    private int quantity;

    // Constructeur
    public Ligne_panier() {}

    public Ligne_panier(Article article, int id_panier /*Double prix*/, int quantity) {
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

    /*public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }*/

    @Override
    public String toString() {
        return "Ligne_panier{" +
                "id=" + id +
                ", article=" + article +
                ", id_panier=" + id_panier +
                /*", prix=" + prix +*/
                ", quantity=" + quantity +
                '}';
    }
}
