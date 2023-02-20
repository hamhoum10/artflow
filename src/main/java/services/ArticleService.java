
package services;

import interfaces.ArticleInterface;
import models.Article;
import models.Artiste;
import models.Categorie;
import util.MyConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MediaStudio
 */
public class ArticleService implements ArticleInterface {
 
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addArticle(Article a) {
        try {
            
            String req = "INSERT INTO `article`(`id_client`,`id_artiste`,`Nom_article`,`price`, `type`, `image`, `description`, `quantity`,`id_categorie`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            /*FileInputStream videoFile = new FileInputStream(a.getImage());
            byte[] png_Article = new byte[videoFile.available()];
            videoFile.read(png_Article);*/
            ps.setInt(1, a.getId_client());
            ps.setInt(2,a.getId_artiste());
            ps.setString(3, a.getNom_article());
            ps.setDouble(4, a.getPrice());
            ps.setString(5, a.getType());
            ps.setBytes(6, null); //radithha null fi db mesh najm nda5l null wnjareb
            ps.setString(7, a.getDescription());
            ps.setInt(8, a.getQuantity());
            ps.setInt(9, a.getCategorie().getId_categorie());
            ps.executeUpdate();
            System.out.println("Article Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  /* catch (FileNotFoundException ex) {
                Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        

    }

    @Override
    public void ModifyArticle(Article t) {
        try {    
            String req = "update `article` set `id_client`=?,`id_artiste`=?,`Nom_article`=?,`Price`=?, `Type`=?,`Image`=?, `Description`=?,`Quantity`=?,`id_categorie`=? where `id_article`= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
          FileInputStream videoFile = new FileInputStream(t.getImage());
            byte[] png_Article = new byte[videoFile.available()];
            videoFile.read(png_Article);
            ps.setInt(1, t.getId_client());
            ps.setInt(2, t.getId_artiste());
            ps.setString(3, t.getNom_article());

            ps.setDouble(4, t.getPrice());
            ps.setString(5, t.getType());
            ps.setBytes(6,png_Article);
            ps.setString(7, t.getDescription());
            ps.setInt(8, t.getQuantity());
            ps.setInt(9, t.getCategorie().getId_categorie());
            ps.setInt(10, t.getId_article());

            
            ps.executeUpdate();
            System.out.println("article Modified Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void deleteArticle(int id) {
        String req = "DELETE FROM `article` where id_article = "+id;
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("article deleted Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Article> fetchArticle() {
       List<Article> Articles = new ArrayList<>();
        try {
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.Id_artiste";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                p.setId_article(rs.getInt(1));
                p.setId_client(rs.getInt(2));
                p.setId_artiste(rs.getInt(3));
                p.setNom_article(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setType(rs.getString(6));
                p.setDescription(rs.getString(8));
                p.setQuantity(rs.getInt(9));
                c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                e.setId(rs.getInt(14));
                e.setFirstname(rs.getString(15));
                e.setLastname(rs.getNString(16));
                p.setCategorie(c);
                p.setArtiste(e);
                Articles.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }

    @Override
    public List<Article> fetchArticleByPrice(Double min, Double max) {
        List<Article> Articles = new ArrayList<>();

        try {
            
            String req = "SELECT * FROM `article` as a,`categorie` as c where a.Id_categorie=c.Id_categorie and price between "+min +" and "+max ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article v = new Article();
                Categorie c=new Categorie();

                                v.setId_article(rs.getInt(1));
                                v.setId_client(rs.getInt(2));
                                v.setId_artiste(rs.getInt(3));
                v.setNom_article(rs.getString(4));
                v.setPrice(rs.getDouble(5));
                v.setType(rs.getString(6));
               v.setDescription(rs.getString(8));
               c.setId_categorie(rs.getInt(10));
               c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                v.setCategorie(c);
          

                 Articles.add(v);
               
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                    return Articles;

    }

    @Override
    public List<Article> fetchArticleById(int id) {
     List<Article> Articles = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `article` as a,`categorie` as c where a.Id_categorie=c.Id_categorie and Id_article = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article a = new Article();
                Categorie c=new Categorie();
                a.setId_article(rs.getInt(1));
                a.setId_client(rs.getInt(2));
                a.setId_client(rs.getInt(3));
                a.setNom_article(rs.getString(4));
                a.setPrice(rs.getDouble(5));
                a.setType(rs.getString(6));
                a.setDescription(rs.getString(8));
                c.setId_categorie(rs.getInt(10));
                c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                a.setCategorie(c);
          
                
               Articles.add(a);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }    

     @Override
    public List<Article> fetchArticleByCaracter(String c) {
     List<Article> Articles = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `article` WHERE `Nom_article`like '%"+c+"%' or `type` like '%"+c+"%'or `description` like '%"+c+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article a = new Article();
                Categorie r=new Categorie();
                               a.setId_article(rs.getInt("Id_article"));
                                a.setId_client(rs.getInt("Id_client"));
                                a.setId_artiste(rs.getInt("Id_artiste"));
                                a.setNom_article(rs.getString("Nom_article"));

                a.setPrice(rs.getDouble("Price"));
                a.setType(rs.getString("Type"));
                a.setDescription(rs.getString("Description"));
                r.setId_categorie(rs.getInt("Id_categorie"));
               
                
               Articles.add(a);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }    
    
    
    
}
