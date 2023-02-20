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
public class stock {
    int id_stock,id_commende;
    String name ,artiste;

    public stock() {
    }

    public stock(int id_stock, int id_commende, String name, String artiste) {
        this.id_stock = id_stock;
        this.id_commende = id_commende;
        this.name = name;
        this.artiste = artiste;
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public int getId_commende() {
        return id_commende;
    }

    public void setId_commende(int id_commende) {
        this.id_commende = id_commende;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    @Override
    public String toString() {
        return "stock{" + "id_stock=" + id_stock + ", id_commende=" + id_commende + ", name=" + name + ", artiste=" + artiste + '}';
    }
    
    
    
    
}
