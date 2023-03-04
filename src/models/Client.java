/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Elizabeth
 */
public class Client {
    private int idc;
   
    private String nom;
    private String prenom;
   

    public Client() {
    }

    public Client(int idc, String nom, String prenom) {
        this.idc = idc;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    
    
    
    

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Client{" + "idc=" + idc + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
    
}
