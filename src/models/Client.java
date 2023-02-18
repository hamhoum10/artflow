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
public class Client {
    int id_client;
    String nom_client;
    String prenom_client;

    public Client() {
    }

    public Client(int id_client, String nom_client, String prenom_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + '}';
    }
    
    
}
