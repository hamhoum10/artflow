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
public class Artiste {
    int id_artiste;
    String nom_artiste;
    String prenom_artiste;

    public Artiste() {
    }

    public Artiste(int id_artiste, String nom_artiste, String prenom_artiste) {
        this.id_artiste = id_artiste;
        this.nom_artiste = nom_artiste;
        this.prenom_artiste = prenom_artiste;
    }

    public int getId_artiste() {
        return id_artiste;
    }

    public void setId_artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    public String getNom_artiste() {
        return nom_artiste;
    }

    public void setNom_artiste(String nom_artiste) {
        this.nom_artiste = nom_artiste;
    }

    public String getPrenom_artiste() {
        return prenom_artiste;
    }

    public void setPrenom_artiste(String prenom_artiste) {
        this.prenom_artiste = prenom_artiste;
    }

    @Override
    public String toString() {
        return "Artiste{" + "id_artiste=" + id_artiste + ", nom_artiste=" + nom_artiste + ", prenom_artiste=" + prenom_artiste + '}';
    }

    public void getId_artiste(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
