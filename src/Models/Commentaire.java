/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Lenovo
 */
public class Commentaire {
    private int id;
    private String commentaire;
    private int id_client;
    private int id_evemt;
    
    
    
    public Commentaire(){
    
    }

    public Commentaire(int id, String commentaire, int id_client, int id_evemt) {
        this.id = id;
        this.commentaire = commentaire;
        this.id_client = id_client;
        this.id_evemt = id_evemt;
    }

    public int getId() {
        return id;
    }

   

   

   

    public String getCommentaire() {
        return commentaire;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_evemt() {
        return id_evemt;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_evemt(int id_evemt) {
        this.id_evemt = id_evemt;
    }

    
    
    
    
}
