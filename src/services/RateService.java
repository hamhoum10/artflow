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
import util.MyConnection;

/**
 *
 * @author MediaStudio
 */
public class RateService implements RateInterface {
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void updateRating(Rate r) {
        try {
            if(afficherRating(r)==0)
            {
                String req = "INSERT INTO rating(`rate`,`id_Article`,`id_rater`) VALUES (?,?,?)";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setDouble(1, r.getRating());
                ps.setInt(2, r.getArticle().getId_article());
                ps.setInt(3, r.getRater().getId());
                
                ps.executeUpdate();
                System.out.println("rate is inserted");
            }
            else
            {
                String req = "update rating set `rate`=? where `id_Article`= ? and `id_rater`=? ";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setDouble(1, r.getRating());
                ps.setInt(2, r.getArticle().getId_article());
                ps.setInt(3, r.getRater().getId());
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
        try {
            
            String req = "SELECT * FROM rating where id_Rater="+r.getRater().getId()+" and id_Article="+r.getArticle().getId_article();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                return(rs.getDouble("rate"));
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
            
            String req = "SELECT AVG(rate) FROM rating where Id_article="+e.getId_article();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                return(rs.getDouble("AVG(rate)"));
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
        
    }
}
