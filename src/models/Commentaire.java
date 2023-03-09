/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Commentaire {
    private int id_comment, id_user;
   
   private Evenement id;
   private String commentaire;
    
    
    public Commentaire(){
    
    
    }

    public Commentaire(int id_user, Evenement id, String commentaire) {
        this.id_user = id_user;
        this.id = id;
        this.commentaire = commentaire;
    }

    public Commentaire(int id_comment, int id_user, Evenement id, String commentaire) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.id = id;
        this.commentaire = commentaire;
    }

   

   

    public int getId_comment() {
        return id_comment;
    }

    public int getId_user() {
        return id_user;
    }

    

    public Evenement getId() {
        return id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

   

    public void setId(Evenement id) {
        this.id = id;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    
   

    

    
    
    
    
    
    
    
    
    
    
}
