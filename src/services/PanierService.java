package services;

import java.io.IOException;
import models.Article;
import models.Client;
import models.Ligne_panier;
import models.Panier;
import util.Conditions;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.DisplayClientFXMLController;
import pidevAuth.LoginFXMLController;

public class PanierService {
    public PanierService() {
    }
    Connection cnx = MyConnection.getInstance().getCnx();
    // onn click +produit /wala awel myconnecti el user  ==> creation de panier(userid)
    //mesh ywali ana panier 7adher w baed ki nenzel ajouter produit n3ayto lel ligne_panierservice w najitw el product

    // Créer une nouvelle commande
    public void createPanier(Panier p) {
        ClientService cs =new ClientService();
              
        try {
            int  rowAjiouté=0;
            Conditions c =new Conditions();
            String sql = "insert into `panier`(`id_client`) values (?) ";
            PreparedStatement  ps = cnx.prepareStatement(sql);
            if(c.DoUserIdExistinPanier(cs.getidclientbyusername(DisplayClientFXMLController.user1))==false) { //normali just id_client static from nada
                ps.setInt(1, cs.getidclientbyusername(DisplayClientFXMLController.user1));
                rowAjiouté =ps.executeUpdate();
                System.out.println("Panier Created" +rowAjiouté);
            }else{
                System.out.println("Panier of this user already exist");
            }
            /*if(rowAjiouté==1){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id_autoincremant = rs.getInt(1);
                    p.setId_panier(id_autoincremant);
                    System.out.println(id_autoincremant);
                }
            }*/



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public double totalmontantPanier(int id_client){
        Double totalPrixPanier=0.0 ;
        try {
            String sql = "SELECT SUM( prix_unitaire * quantity) AS total FROM panier JOIN ligne_panier ON panier.id_panier = ligne_panier.id_panier WHERE panier.id_client = "+ id_client;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                totalPrixPanier = rs.getDouble("total");//total est colonne virtuell, il n'existe pas dans la table panier
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrixPanier;
    }
    public double totalmontantPanierWith20Discount(int id_client){
        Double totalPrixPanierWithDiscount=0.0 ;
        try {
            String sql = "SELECT SUM( prix_unitaire * quantity * 0.8) AS total FROM panier JOIN ligne_panier ON panier.id_panier = ligne_panier.id_panier WHERE panier.id_client = "+ id_client;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                totalPrixPanierWithDiscount = rs.getDouble("total");//total est colonne virtuell, il n'existe pas dans la table panier
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrixPanierWithDiscount;
    }
    public int getPanierIdByUser(Client c) {
        int panierId = 0;
        String query = "SELECT id_panier FROM panier p JOIN client c  on p.id_client = c.id  WHERE username = ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setString(1, c.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                panierId = rs.getInt("id_panier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return panierId;
    }

    //hethi lel javafx
    public int getPanierIdByIDUser(int id_client) {
        int panierId = 0;
        String query = "SELECT id_panier FROM panier p JOIN client c  on p.id_client = c.id  WHERE id = ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setInt(1, id_client);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                panierId = rs.getInt("id_panier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return panierId;
    }
    
}
