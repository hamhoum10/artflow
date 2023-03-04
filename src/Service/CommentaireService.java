/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.CommentaireInterface;
import Models.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Myconnection;
import Models.Client;

/**
 *
 * @author Lenovo
 */
public class CommentaireService implements CommentaireInterface{
    Connection cnx = Myconnection.getInstance().getCnx();

    @Override
    public void ajouter(Commentaire t) {
        try {
            String req = "insert into commentaire(commentaire,id_client,id) values("+t.getCommentaire()+ ",'" + t.getId_client()+"'," + t.getId_evemt()+ ");";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Comment ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Commentaire t) {
        try {
          
            String req = "update commentaire set commentaire=? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setString(1, t.getCommentaire());
            ps.setInt(2, (int) t.getId_evemt());
            ps.executeUpdate();
            System.out.println("Commentaire  modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    @Override
    public void supprimer(Commentaire t) {
       try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM commentaire WHERE id = "+id_commentaire+"";
                st.executeUpdate(req);      
      System.out.println("Comment supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }
    

    @Override
    public List<Commentaire> recuperer(int idp) {
         List<Commentaire> comments = new ArrayList<>();
        try {
            String req = "select * from commentaire where posts_id= "+idp;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Commentaire p = new Commentaire();
                p.setId_commentaire(rs.getInt(1));
           
                p.setCommentaire(rs.getString("commentaire"));
              
                p.setId_client(idp);
               comments.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return comments;
    }
    }

   
    

