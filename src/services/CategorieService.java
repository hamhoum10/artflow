/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.CategorieInterface;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Article;
import models.Categorie;
import models.stock;
import util.MyConnection;

/**
 *
 * @author MediaStudio
 */
public class CategorieService implements CategorieInterface {
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addCategorie(Categorie c) {
         try {
            
            String req = "INSERT INTO `Categorie`( `name_categorie`, `description`,`Id_stock`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, c.getName_categorie());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getStock().getId_stock());
            ps.executeUpdate();
            System.out.println("Categorie Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void ModifyCategorie(Categorie c) {
        try {    
            String req = "update `Categorie` set `name_categorie`=?, `description`=? ,`Id_stock`=? WHERE `Id_categorie`=?";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setString(1, c.getName_categorie());
           ps.setString(2, c.getDescription());
            ps.setInt(3, c.getStock().getId_stock());
           ps.setInt(4, c.getId_categorie());

         
            
            ps.executeUpdate();
            System.out.println("Categorie Modified Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    @Override
    public void deleteCategorie(int id) {
       String req = "DELETE FROM `Categorie` where id_categorie = "+id;
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie deleted Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Categorie> fetchCategorie() {
List<Categorie> Categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `categorie` as c,`stock` as s where c.Id_stock=s.Id_stock";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie e = new Categorie();
                stock t = new stock();
                e.setId_categorie(rs.getInt("Id_categorie"));

                e.setName_categorie(rs.getString("Name_categorie"));
                e.setDescription(rs.getString("Description"));
                t.setId_stock(rs.getInt("Id_stock"));

                t.setId_stock(rs.getInt("Id_stock"));
                t.setName(rs.getString("Name"));
                t.setArtiste(rs.getString("Artiste"));
                t.setId_commende(rs.getInt("Id_commende"));
                e.setStock(t);
                Categories.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Categories;    }

    @Override
    public List<Categorie> fetchCategorieById(int id) {
        List<Categorie> Categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `categorie` as c,`stock` as s where c.Id_stock=s.Id_stock and  Id_categorie = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie l = new Categorie();
                stock t = new stock();
                l.setId_categorie(rs.getInt(1));
                l.setName_categorie(rs.getString(2));
                l.setDescription(rs.getString(3));
                t.setId_stock(rs.getInt("Id_stock"));
                l.setStock(t);
                t.setName(rs.getString("Name"));
                t.setArtiste(rs.getString("Artiste"));
                t.setId_commende(rs.getInt("Id_commende"));
                
               Categories.add(l);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Categories;
    }    

    @Override
    public List<Categorie> fetchCategorieBycaracter(String c) {
        List<Categorie> Categories = new ArrayList<>();
        try {
            
String req = "SELECT * FROM `categorie` as c,`stock` as s where c.Id_stock=s.Id_stock and  `Name_categorie`like '%"+c+"%' or `description` like '%"+c+"%'";            
Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie l = new Categorie();
                 stock t = new stock();

                l.setId_categorie(rs.getInt(1));
                l.setName_categorie(rs.getString(2));
                l.setDescription(rs.getString(3));
                t.setId_stock(rs.getInt("Id_stock"));
                l.setStock(t);
                t.setName(rs.getString("Name"));
                t.setArtiste(rs.getString("Artiste"));
                t.setId_commende(rs.getInt("Id_commende"));
               Categories.add(l);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Categories;
    }

    @Override
    public List<Categorie> fetchArticleTriByName() {
      List<Categorie> Categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `categorie` as c,`stock` as s where c.Id_stock=s.Id_stock ORDER BY Name_categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie e = new Categorie();
                stock t = new stock();
                e.setId_categorie(rs.getInt("Id_categorie"));

                e.setName_categorie(rs.getString("Name_categorie"));
                e.setDescription(rs.getString("Description"));
                t.setId_stock(rs.getInt("Id_stock"));
                t.setName(rs.getString("Name"));
                t.setArtiste(rs.getString("Artiste"));
                t.setId_commende(rs.getInt("Id_commende"));
                e.setStock(t);
                Categories.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Categories;    }

    @Override
    public List<Categorie> fetchArticleTriBystock() {
      List<Categorie> Categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `categorie` as c,`stock` as s where c.Id_stock=s.Id_stock ORDER BY s.Id_stock";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie e = new Categorie();
                stock t = new stock();
                e.setId_categorie(rs.getInt("Id_categorie"));

                e.setName_categorie(rs.getString("Name_categorie"));
                e.setDescription(rs.getString("Description"));
                t.setId_stock(rs.getInt("Id_stock"));
                t.setName(rs.getString("Name"));
                t.setArtiste(rs.getString("Artiste"));
                t.setId_commende(rs.getInt("Id_commende"));
                e.setStock(t);
                Categories.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Categories;    }

public Categorie fetchCategorieByName(String name) {
        Categorie categorie = new Categorie();
        try {
            
            String req = "SELECT * FROM Categorie WHERE Name_categorie = '"+name+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                categorie.setId_categorie(rs.getInt(1));
                categorie.setName_categorie(rs.getString(2));
                categorie.setDescription(rs.getString(3));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return categorie;
    }   
    

    
    
    
}
