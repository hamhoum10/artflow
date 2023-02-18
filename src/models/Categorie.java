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
public class Categorie {
    
    int id_categorie  ;
    String name_categorie;
    String description;
    stock stock;

    public Categorie() {
    }

    public Categorie(int id_categorie, String name_categorie, String description, stock stock) {
        this.id_categorie = id_categorie;
        this.name_categorie = name_categorie;
        this.description = description;
        this.stock = stock;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getName_categorie() {
        return name_categorie;
    }

    public void setName_categorie(String name_categorie) {
        this.name_categorie = name_categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public stock getStock() {
        return stock;
    }

    public void setStock(stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", name_categorie=" + name_categorie + ", description=" + description + ", stock=" + stock + '}';
    }

   
    
    
    
}
