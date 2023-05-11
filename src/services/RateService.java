/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.RateInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Article;
import models.Rate;
import pidevAuth.LoginFXMLController;
import pidevAuthArtiste.LoginArtisteController;
import util.MyConnection;
import services.UserService;

/**
 *
 * @author MediaStudio
 */
public class RateService implements RateInterface {
        Connection cnx = MyConnection.getInstance().getCnx();
        UserService user = new UserService();
        ClientService cl = new ClientService();
        
    
    @Override
    public void updateRating(Rate r) {
        try {
            if(afficherRating(r)==0)
            {
                String req = "INSERT INTO rating(`id_Article`,`id_user`,`rating`) VALUES (?,?,?)";
                PreparedStatement ps = cnx.prepareStatement(req);
                
                ps.setInt(1, r.getArticle().getId_article());
                ps.setInt(2, cl.getidclientbyusername(LoginFXMLController.usernamewelcome));
                ps.setDouble(3, r.getRating());
                          

                
                ps.executeUpdate();
                System.out.println("rate is inserted");
            }
            else
            {
                String req = "update rating set `rating`=? where `id_Article`= ? and `id_user`=? ";
                PreparedStatement ps = cnx.prepareStatement(req);
                  
                ps.setInt(2, r.getArticle().getId_article());
                ps.setInt(3, user.getUserbyusername(LoginFXMLController.usernamewelcome).getId());
                ps.setDouble(1, r.getRating());
                ps.executeUpdate();
                System.out.println("rate is updated");

            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Double afficherRating(Rate r) {
        Rate rating = new Rate();
        
        if(user.getUserbyusername(LoginFXMLController.usernamewelcome).getUsername()!=null)
        try {
            
            String req = "SELECT * FROM rating where id_user="+user.getUserbyusername(LoginFXMLController.usernamewelcome).getId()+" and id_Article="+r.getArticle().getId_article();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                return(rs.getDouble("rating"));
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public Double afficherRateavg(Article e) {
        Rate rating = new Rate();
        try {
            
            String req = "SELECT AVG(rating) FROM rating where Id_article="+e.getId_article();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                return(rs.getDouble("AVG(rating)"));
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
        
    }
    public Double afficherRateavg1() {
        Rate rating = new Rate();
        try {
            
            String req = "SELECT AVG(rating) FROM rating ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                return(rs.getDouble("AVG(rating)"));
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;}
}
