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

    public Enchere() {
    }

    public Enchere(int ide, String titre, String description, double prixdepart, Date date_limite) {
        this.ide = ide;
        this.titre = titre;
        this.description = description;
        this.prixdepart = prixdepart;
        this.date_limite = date_limite;
    }

    public Enchere(String titre, String description, double prixdepart, Date date_limite) {
        this.titre = titre;
        this.description = description;
        this.prixdepart = prixdepart;
        this.date_limite = date_limite;
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

    @Override
    public String toString() {
        return "Enchere{" + "ide=" + ide + ", titre=" + titre + ", description=" + description + ", prixdepart=" + prixdepart + ", date_limite=" + date_limite + '}';
    }
    
    
    

}
