/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author Elizabeth
 */
public class Enchere {

    private int ide;
    private String titre;
    private String description;
    private double prixdepart;
    private Date date_limite;
    private String img;

    public Enchere() {
    }

    public Enchere(int ide, String titre, String description, double prixdepart, Date date_limite, String img) {
        this.ide = ide;
        this.titre = titre;
        this.description = description;
        this.prixdepart = prixdepart;
        this.date_limite = date_limite;
        this.img=img;
    }

    public Enchere(String titre, String description, double prixdepart, Date date_limite, String img) {
        this.titre = titre;
        this.description = description;
        this.prixdepart = prixdepart;
        this.date_limite = date_limite;
        this.img = img;
    }

   

    
    
    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrixdepart() {
        return prixdepart;
    }

    public void setPrixdepart(double prixdepart) {
        this.prixdepart = prixdepart;
    }

    public Date getDate_limite() {
        return date_limite;
    }

    public void setDate_limite(Date date_limite) {
        this.date_limite = date_limite;
    }

    
     public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    @Override
    public String toString() {
        return "Enchere: "+ "id enchere : " + ide +System.lineSeparator() + ", titre=" + titre +System.lineSeparator()+ ", description=" + description +System.lineSeparator()+ ", prixdepart=" + prixdepart +System.lineSeparator()+ ", date_limite=" + date_limite +System.lineSeparator()+ ", img=" + img +System.lineSeparator() ;
    }
//"prénom : " + prénomClientCommande + System.lineSeparator()+
    /*
    
    
    public String toString() {
        return  "Article_name : " + article.getNom_article() +System.lineSeparator()+
                "Article_type : " + article.getType() +System.lineSeparator()+
                "Article_description : " + article.getDescription() +System.lineSeparator()+
                "Article_price : " + article.getPrice() +System.lineSeparator()+
                "Quantity : " + quantity +System.lineSeparator()+
                "id_panier : " + id_panier +System.lineSeparator();

    }
    
     */

//    public Object getItems() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    
    
    

}
