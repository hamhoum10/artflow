/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.CommentaireInterface;
import models.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyConnection;
import models.Client;
import models.Evenement;
import java.sql.Date;
import models.Client;

/**
 *
 * @author Lenovo
 */
public class CommentaireService implements CommentaireInterface{
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addComment(Commentaire t) {
        
        try {
            String insertCommentQuery = "INSERT INTO parler(id_user, Id,Commentaire) VALUES (?, ?, ?)";
            PreparedStatement insertCommentStmt = cnx.prepareStatement(insertCommentQuery);
            insertCommentStmt.setInt(1, t.getId_user());
            insertCommentStmt.setInt(2, t.getId().getId());
            insertCommentStmt.setString(3, t.getCommentaire());
            int result = insertCommentStmt.executeUpdate();
            if (result > 0) {
                System.out.println("Comment added successfully");
            } else {
                System.out.println("Error adding comment: No rows affected");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @Override
    public void modifier(Commentaire co) {
        try {
            String req = "UPDATE comment SET Comment = ? WHERE Id_comment = ?";
            PreparedStatement com = cnx.prepareStatement(req);
            com.setString(1, co.getCommentaire());
            com.setInt(2, co.getId_comment());
            int result = com.executeUpdate();
            if (result > 0) {
                System.out.println("Comment modified");
            } else {
                System.out.println("No comment found with Id_comment " + co.getId_comment());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    @Override
    public void supprimer(int commentId) {
        try {
            String req = "DELETE FROM parler WHERE Id_comment = ?";
            PreparedStatement com = cnx.prepareStatement(req);
            com.setInt(1, commentId);
            int result = com.executeUpdate();
            if (result > 0) {
                System.out.println("Comment deleted");
            } else {
                System.out.println("No comment found with Id_comment " + commentId);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Commentaire fetchCommentByEvemtId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> fetchCommentaireByEvemtId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evenement> fetchEvemts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evenement fetchEvemt(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commentaire fetchCommentByEvemtId(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> fetchCommentByPostId(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> recuperer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

   
    
    

   
    

