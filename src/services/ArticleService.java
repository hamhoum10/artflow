





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
import pidevAuthAdmin.LoginAdminController;
import pidevAuthArtiste.LoginArtisteController;
import util.MyConnection;
import util.QrCodeGenerator;

/**
 *
 * @author MediaStudio
 */
public class ArticleService implements ArticleInterface {
 
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addArticle(Article a) {
        try {
            System.out.println("a"+a);
//            String req = "INSERT INTO `article`(`id_client`,`id_artiste`,`Nom_article`,`price`, `type`, `image`, `description`, `quantity`,`id_categorie`) VALUES (?,?,?,?,?,?,?,?,?)";
                       String req = "INSERT INTO `article`(`id_artiste`,`Nom_article`,`price`, `type`, `image`, `description`, `quantity`,`id_categorie`) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
            ArtisteService as =new ArtisteService();
            
////            ps.setInt(1,a.getArtiste().getId());
//            if(LoginAdminController.usernameAdmin==null)
                ps.setString(1,LoginArtisteController.usernameArtiste);
//            else
//                ps.setString(1,LoginAdminController.usernameAdmin);
            ps.setString(2, a.getNom_article());
            ps.setDouble(3, a.getPrice());
            ps.setString(4, a.getType());
            ps.setString(5,a.getImage());
            ps.setString(6, a.getDescription());
            ps.setInt(7, a.getQuantity());
            ps.setInt(8, a.getCategorie().getId_categorie());
                        System.out.println("id t3adet");

            ps.executeUpdate();
            System.out.println("Article Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void ModifyArticle(Article t) {
        try {    
            String req = "update `article`  set `id_artiste`=?,`Nom_article`=?,`Price`=?, `Type`=?,`Image`=?, `Description`=?,`Quantity`=? , `id_categorie`=? where `id_article`= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
                     ArtisteService as =new ArtisteService();

//            if(LoginAdminController.usernameAdmin==null)
                ps.setString(1,LoginArtisteController.usernameArtiste);
//            else
//                ps.setString(1,LoginAdminController.usernameAdmin);
            ps.setString(2, t.getNom_article());

            ps.setDouble(3, t.getPrice());
            ps.setString(4, t.getType());
            ps.setString(5,t.getImage());
            ps.setString(6, t.getDescription());
            ps.setInt(7, t.getQuantity());
            ps.setInt(8, t.getCategorie().getId_categorie());
            ps.setInt(9, t.getId_article());
            

            
            ps.executeUpdate();
            System.out.println("article Modified Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                
                
                p.setId_article(rs.getInt("Id_article"));
                
                e.setUsername(rs.getString("Username"));
                p.setNom_article(rs.getString("Nom_article"));
                p.setPrice(rs.getDouble("Price"));
                p.setType(rs.getString("Type"));
                p.setDescription(rs.getString("Description"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setImage(rs.getString("image"));
                c.setId_categorie(rs.getInt("Id_categorie"));
               
                c.setName_categorie(rs.getString("Name_categorie"));
                c.setDescription(rs.getString("Description"));
                e.setLastname(rs.getString("Lastname"));
                e.setFirstname(rs.getNString("Firstname"));
                p.setCategorie(c);
               p.setArtiste(e);
               
                if(GenerateQrCode(p)){
                    System.out.println("ajout qr code avec success\n");
                }
                else{
                    System.out.println("erreur d'ajout\n");
                }
                Articles.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }
      
    
    
    
    
    
    
    @Override
    public List<Article> fetchArticlebyusername(String usernameartiste) {
       List<Article> Articles = new ArrayList<>();
        try {
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                
                
                p.setId_article(rs.getInt("Id_article"));
                
                e.setUsername(rs.getString("Username"));
                p.setNom_article(rs.getString("Nom_article"));
                p.setPrice(rs.getDouble("Price"));
                p.setType(rs.getString("Type"));
                p.setDescription(rs.getString("Description"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setImage(rs.getString("image"));
                c.setId_categorie(rs.getInt("Id_categorie"));
               
                c.setName_categorie(rs.getString("Name_categorie"));
                c.setDescription(rs.getString("Description"));
                e.setLastname(rs.getString("Lastname"));
                e.setFirstname(rs.getNString("Firstname"));
                p.setCategorie(c);
               p.setArtiste(e);
               
                if(GenerateQrCode(p)){
                    System.out.println("ajout qr code avec success\n");
                }
                else{
                    System.out.println("erreur d'ajout\n");
                }
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
            
            String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username and price between "+min +" and "+max ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                
                
                p.setId_article(rs.getInt("Id_article"));
                
                e.setUsername(rs.getString("Username"));
                p.setNom_article(rs.getString("Nom_article"));
                p.setPrice(rs.getDouble("Price"));
                p.setType(rs.getString("Type"));
                p.setDescription(rs.getString("Description"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setImage(rs.getString("image"));
                c.setId_categorie(rs.getInt("Id_categorie"));
               
                c.setName_categorie(rs.getString("Name_categorie"));
                c.setDescription(rs.getString("Description"));
                e.setLastname(rs.getString("Lastname"));
                e.setFirstname(rs.getNString("Firstname"));
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
    public List<Article> fetchArticleById(int id) {
     List<Article> Articles = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username and Id_article = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Article a = new Article();
                Categorie c=new Categorie();
                                Artiste h = new Artiste();
                                

                a.setId_article(rs.getInt(1));
                h.setUsername(rs.getString(2));
                a.setNom_article(rs.getString(3));
                a.setPrice(rs.getDouble(4));
                a.setType(rs.getString(5));
                a.setDescription(rs.getString(7));
                c.setId_categorie(rs.getInt(9));
                c.setName_categorie(rs.getString(10));
                c.setDescription(rs.getString(11));
                a.setCategorie(c);
                a.setArtiste(h);
                 h.setLastname(rs.getString("Lastname"));
                h.setFirstname(rs.getString("Firstname"));
          
                
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
            
            String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username and (`a`.`Nom_article`like '%"+c+"%' or `a`.`type` like '%"+c+"%'or `a`.`description` like '%"+c+"%')";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                System.out.println(rs);
                Article p = new Article();
                Categorie cat=new Categorie();
                Artiste e = new Artiste();
                
                
                p.setId_article(rs.getInt("Id_article"));
                
                e.setUsername(rs.getString("Username"));
                p.setNom_article(rs.getString("Nom_article"));
                p.setPrice(rs.getDouble("Price"));
                p.setType(rs.getString("Type"));
                p.setDescription(rs.getString("Description"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setImage(rs.getString("image"));
                cat.setId_categorie(rs.getInt("Id_categorie"));
               
                cat.setName_categorie(rs.getString("Name_categorie"));
                cat.setDescription(rs.getString("Description"));
                e.setLastname(rs.getString("Lastname"));
                e.setFirstname(rs.getNString("Prenom_artiste"));
                p.setCategorie(cat);
               p.setArtiste(e);
               
                
                Articles.add(p);
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
                Artiste j = new Artiste();
                a.setId_article(rs.getInt("Id_article"));
                j.setUsername(rs.getString("Username"));
                a.setNom_article(rs.getString("Nom_article"));
                a.setPrice(rs.getDouble("Price"));
                a.setType(rs.getString("Type"));
                a.setDescription(rs.getString("Description"));
                c.setId_categorie(rs.getInt("Id_categorie"));
                c.setName_categorie(rs.getString("Name_categorie"));
                c.setDescription(rs.getString("Description"));
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
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username ORDER BY Price ";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();                                

                p.setId_article(rs.getInt("Id_article"));
                e.setUsername(rs.getString("Username"));;
                p.setNom_article(rs.getString("Nom_article"));
                p.setPrice(rs.getDouble("Price"));
                p.setType(rs.getString("Type"));
                p.setDescription(rs.getString("Description"));
                p.setQuantity(rs.getInt("Quantity"));
                c.setId_categorie(rs.getInt("Id_categorie"));
                c.setName_categorie(rs.getString("Name_categorie"));
                c.setDescription(rs.getString("Description"));
                e.setId(rs.getInt("Id_artiste"));
                e.setLastname(rs.getString("Lastname"));
                e.setFirstname(rs.getNString("Firstname"));
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
    public List<Article> fetchArticleTriByName() {
 List<Article> Articles = new ArrayList<>();
        try {
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username ORDER BY Nom_article ";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                
                
                p.setId_article(rs.getInt("Id_article"));
                
                e.setUsername(rs.getString("Username"));
                p.setNom_article(rs.getString("Nom_article"));
                p.setPrice(rs.getDouble("Price"));
                p.setType(rs.getString("Type"));
                p.setDescription(rs.getString("Description"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setImage(rs.getString("image"));
                c.setId_categorie(rs.getInt("Id_categorie"));
               
                c.setName_categorie(rs.getString("Name_categorie"));
                c.setDescription(rs.getString("Description"));
                e.setLastname(rs.getString("Lastname"));
                e.setFirstname(rs.getNString("Firstname"));
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
    public List<Article> fetchArticleTriByCategorie() {
     List<Article> Articles = new ArrayList<>();
        try {
            
          String req = "SELECT * FROM `article` as a,`categorie` as c , `artiste` as r where a.Id_categorie=c.Id_categorie and a.Id_artiste = r.username ORDER BY a.Id_categorie ";
//String req="select e.Id_article,e.Id_client,e.Id_artiste,e.Nom_article,e.Price,e.Type,e.Description,e.Quantity,e.Id_categorie,d.Id_categorie,d.Name_categorie,d.Description from `categorie` d inner join `article`e on e.Id_categorie=d.Id_categorie";
//          String req="select * from `article`e inner join `categorie` d on e.Id_categorie=d.Id_categorie";

          Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {   
                System.out.println(rs);
                Article p = new Article();
                Categorie c=new Categorie();
                Artiste e = new Artiste();
                p.setId_article(rs.getInt("Id_article"));
                e.setUsername(rs.getString("Username"));
                p.setNom_article(rs.getString("Nom_article"));
                p.setPrice(rs.getDouble("Price"));
                p.setType(rs.getString("Type"));
                p.setDescription(rs.getString("Description"));
                p.setQuantity(rs.getInt("Quantity"));
                c.setId_categorie(rs.getInt("Id_categorie"));
                c.setName_categorie(rs.getString("Name_categorie"));
                c.setDescription(rs.getString("Description"));
                e.setId(rs.getInt("Id"));
                e.setLastname(rs.getString("Lastname"));
                e.setFirstname(rs.getNString("Firstname"));
                p.setCategorie(c);
                p.setArtiste(e);
                
                Articles.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Articles;
    }
    public boolean GenerateQrCode(Article a){
        return QrCodeGenerator.GenerateQrCode(a.getArtiste()+"\n"+a.getCategorie(), a.getId_article());
    }
 }

    
    
    
    

