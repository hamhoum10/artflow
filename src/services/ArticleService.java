
package services;

import interfaces.ArticleInterface;
import java.util.List;


import interfaces.ArticleInterface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Article;
import models.Artiste;
import models.Categorie;
import models.Client;
import models.stock;
import util.MyConnection;

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
            FileInputStream videoFile = new FileInputStream(a.getImage());
            byte[] png_Article = new byte[videoFile.available()];
            videoFile.read(png_Article);
            ps.setInt(1, a.getClient().getId_client());
            ps.setInt(2,a.getArtiste().getId_artiste());
            ps.setString(3, a.getNom_article());
            ps.setDouble(4, a.getPrice());
            ps.setString(5, a.getType());
            ps.setBytes(6,png_Article);
            ps.setString(7, a.getDescription());
            ps.setInt(8, a.getQuantity());
            ps.setInt(9, a.getCategorie().getId_categorie());
            ps.executeUpdate();
            System.out.println("Article Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
            }
        

    }

    @Override
    public void ModifyArticle(Article t) {
        try {    
            String req = "update `article`  set `id_client`=?,`id_artiste`=?,`Nom_article`=?,`Price`=?,"
                    + " `Type`=?,`Image`=?, `Description`=?,`Quantity`=? , `id_categorie`=? where `id_article`= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
          FileInputStream videoFile = new FileInputStream(t.getImage());
            byte[] png_Article = new byte[videoFile.available()];
            videoFile.read(png_Article);
            ps.setInt(1, t.getClient().getId_client());
            ps.setInt(2, t.getArtiste().getId_artiste());
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
                Client h =new Client();
                
                p.setId_article(rs.getInt(1));
                h.setId_client(rs.getInt(2));
                e.setId_artiste(rs.getInt(3));
                p.setNom_article(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setType(rs.getString(6));
                p.setDescription(rs.getString(8));
                p.setQuantity(rs.getInt(9));
                
               
                c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                e.setNom_artiste(rs.getString(15));
                e.setPrenom_artiste(rs.getNString(16));
                p.setCategorie(c);
                p.setArtiste(e);
                p.setClient(h);
                
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
            
            String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.Id_artiste and price between "+min +" and "+max ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article v = new Article();
                Categorie c=new Categorie();
                                Artiste h = new Artiste();
                                Client b =new Client();
                                v.setId_article(rs.getInt(1));
                                b.setId_client(rs.getInt(2));
                                h.setId_artiste(rs.getInt(3));
                v.setNom_article(rs.getString(4));
                v.setPrice(rs.getDouble(5));
                v.setType(rs.getString(6));
               v.setDescription(rs.getString(8));
               c.setId_categorie(rs.getInt(10));
               c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                v.setCategorie(c);
          h.setNom_artiste(rs.getString("Nom_artiste"));
                h.setPrenom_artiste(rs.getString("Prenom_artiste"));
                v.setArtiste(h);
                v.setClient(b);

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
            
            String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.Id_artiste and Id_article = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article a = new Article();
                Categorie c=new Categorie();
                                Artiste h = new Artiste();
                                Client b =new Client();

                a.setId_article(rs.getInt(1));
                b.setId_client(rs.getInt(2));
                h.setId_artiste(rs.getInt(3));
                a.setNom_article(rs.getString(4));
                a.setPrice(rs.getDouble(5));
                a.setType(rs.getString(6));
                a.setDescription(rs.getString(8));
                c.setId_categorie(rs.getInt(10));
                c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                a.setCategorie(c);
                a.setArtiste(h);
                a.setClient(b);
                 h.setNom_artiste(rs.getString("Nom_artiste"));
                h.setPrenom_artiste(rs.getString("Prenom_artiste"));
          
                
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
            
            String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.Id_artiste and `a`.`Nom_article`like '%"+c+"%' or `a`.`type` like '%"+c+"%'or `a`.`description` like '%"+c+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article a = new Article();
                Categorie r=new Categorie();
                Artiste h = new Artiste();
                Client b =new Client();

                               a.setId_article(rs.getInt("Id_article"));
                                b.setId_client(rs.getInt("Id_client"));
                                h.setId_artiste(rs.getInt("Id_artiste"));
                                a.setNom_article(rs.getString("Nom_article"));

                a.setPrice(rs.getDouble("Price"));
                a.setType(rs.getString("Type"));
                a.setDescription(rs.getString("Description"));
                a.setQuantity((int) rs.getDouble("Quantity"));
                a.setCategorie(r);
                a.setArtiste(h);
                a.setClient(b);
                r.setId_categorie(rs.getInt("Id_categorie"));
                r.setDescription(rs.getString("Description"));
                r.setName_categorie(rs.getString("Name_categorie"));
                h.setNom_artiste(rs.getString("Nom_artiste"));
                h.setPrenom_artiste(rs.getString("Prenom_artiste"));
                
               Articles.add(a);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }    

    @Override
    public List<Article> fetchArticleById_categorie(int id_categorie) {
List<Article> Articles = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `article` as a,`categorie` as c where a.Id_categorie=c.Id_categorie and a.id_categorie = "+id_categorie;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article a = new Article();
                Categorie c=new Categorie();
                Client b =new Client();
                Artiste j = new Artiste();
                a.setId_article(rs.getInt(1));
                b.setId_client(rs.getInt(2));
                j.setId_artiste(rs.getInt(3));
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
        
        return Articles;    }

    @Override
    public List<Article> fetchArticleTriByPrice() {
       List<Article> Articles = new ArrayList<>();
        try {
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.Id_artiste ORDER BY Price ";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();                                
                Client b =new Client();

                p.setId_article(rs.getInt(1));
                b.setId_client(rs.getInt(2));
                e.setId_artiste(rs.getInt(3));
                p.setNom_article(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setType(rs.getString(6));
                p.setDescription(rs.getString(8));
                p.setQuantity(rs.getInt(9));
                c.setId_categorie(rs.getInt("Id_categorie"));
                c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                e.setId_artiste(rs.getInt(14));
                e.setNom_artiste(rs.getString(15));
                e.setPrenom_artiste(rs.getNString(16));
                p.setCategorie(c);
                p.setArtiste(e);
                p.setClient(b);
                Articles.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }

    @Override
    public List<Article> fetchArticleTriByName() {
 List<Article> Articles = new ArrayList<>();
        try {
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.Id_artiste ORDER BY Nom_article ";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                Client b =new Client();
                p.setId_article(rs.getInt(1));
                b.setId_client(rs.getInt(2));
                e.setId_artiste(rs.getInt(3));
                p.setNom_article(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setType(rs.getString(6));
                p.setDescription(rs.getString(8));
                p.setQuantity(rs.getInt(9));
                c.setId_categorie(rs.getInt("Id_categorie"));
                c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                e.setId_artiste(rs.getInt(14));
                e.setNom_artiste(rs.getString(15));
                e.setPrenom_artiste(rs.getNString(16));
                p.setCategorie(c);
                p.setArtiste(e);
                p.setClient(b);
                Articles.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }

    @Override
    public List<Article> fetchArticleTriByCategorie() {
     List<Article> Articles = new ArrayList<>();
        try {
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.Id_artiste ORDER BY a.Id_categorie ";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                Client b =new Client();
                p.setId_article(rs.getInt(1));
                b.setId_client(rs.getInt(2));
                e.setId_artiste(rs.getInt(3));
                p.setNom_article(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setType(rs.getString(6));
                p.setDescription(rs.getString(8));
                p.setQuantity(rs.getInt(9));
                c.setId_categorie(rs.getInt("Id_categorie"));
                c.setName_categorie(rs.getString(11));
                c.setDescription(rs.getString(12));
                e.setId_artiste(rs.getInt(14));
                e.setNom_artiste(rs.getString(15));
                e.setPrenom_artiste(rs.getNString(16));
                p.setCategorie(c);
                p.setArtiste(e);
                p.setClient(b);
                Articles.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }
 }

    
    
    
    

